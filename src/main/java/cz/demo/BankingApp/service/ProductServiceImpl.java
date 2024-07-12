package cz.demo.BankingApp.service;

import cz.demo.BankingApp.constant.ProductType;
import cz.demo.BankingApp.dto.Mapper.ProductMapper;
import cz.demo.BankingApp.dto.Mapper.ProductDefinitionMapper;
import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.*;

import cz.demo.BankingApp.entity.repository.ProductDefinitionRepository;
import cz.demo.BankingApp.entity.repository.ProductRepository;
import cz.demo.BankingApp.entity.repository.UserRepository;
import cz.demo.BankingApp.service.interfaces.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Future;


@Service
@EnableAsync
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDefinitionRepository productDefinitionRepository;
    @Autowired
    ProductDefinitionMapper productDefinitionMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserRepository userRepository;


    @Override
    public List<ProductDefinitionDTO> getAllDefinitions() {
        return productDefinitionRepository.findAll().stream()
                .map(m -> productDefinitionMapper.toDTO(m))
                .toList();
    }

    @Override
    public ProductDefinitionDTO getDefinitionByProductKey(String key) {
        return productDefinitionMapper.toDTO(productDefinitionRepository.findByProductKey(key));
    }

    @Override
    public ProductDefinitionDTO crateNewProductDefinition(ProductDefinitionDTO newDefinition) {
        ProductDefinitionEntity entity = productDefinitionMapper.toEntity(newDefinition);
        return productDefinitionMapper.toDTO(productDefinitionRepository.saveAndFlush(entity));
    }

    @Override
    public void generateTestData() {
        ProductDefinitionEntity loanDefinition = productDefinitionRepository.findByProductKey("TEST01");
        ProductDefinitionEntity accountDefinition = productDefinitionRepository.findByProductKey("TEST02");
        UserEntity user = new UserEntity(null, "password","test", "testovic", "test@test.com", "123456/1234","+420123456789");
        LocalDate datum = LocalDate.of(1980, 1, 1);
        ProductEntity account = new ProductEntity(null, accountDefinition, datum, user, 100000000.0f, null, null,"CZ00000000000110010", null, null, datum);
        ProductEntity loan = new ProductEntity(null, loanDefinition, datum, user, 100000000.0f, 100000000, 100,"CZ00000000000110010", 50, 50, datum);
        userRepository.saveAndFlush(user);
        productRepository.saveAndFlush(loan);
        productRepository.saveAndFlush(account);
    }

    @Override
    public ProductDefinitionDTO updateProductDefinition(ProductDefinitionDTO newDefinition) {
        ProductDefinitionEntity entity = productDefinitionRepository.findByProductKey(newDefinition.getProductKey());
        ProductDefinitionEntity updatedEntity = productDefinitionMapper.dtoToEntityRemap(entity, newDefinition);
        return productDefinitionMapper.toDTO(productDefinitionRepository.saveAndFlush(updatedEntity));
    }

    @Override
    @PostConstruct
    public void setBillingDate() {

        Timer timer = new Timer();
        LocalDate today = LocalDate.now();
        LocalDateTime tomorrowMidnight = LocalDateTime.of(today.plusDays(1), LocalTime.of(0,0,0));
        long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(),tomorrowMidnight);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                billProducts(LocalDate.now());
            }
        };
        timer.schedule(task,delay, 1000*60*60*24);
    }


    @Override
    @Async
    public Future<List<ProductEntity>> billProducts(LocalDate today) {
        //find who should pay today
        List<ProductEntity> productsToBill = productRepository.findByNextBillingDate(today);

        for (ProductEntity e : productsToBill) {
            //bill everyone
            if (e.getProductDefinition().getRate() > 1) {
                e.setBalance(e.getBalance() - e.getProductDefinition().getRate());
            } else {
                if (e.getProductDefinition().getProductType() == ProductType.ACCOUNT) {
                    e.setBalance(e.getBalance() - e.getBalance() * e.getProductDefinition().getRate());
                } else {
                    float payment = e.getFixedRate() +
                            ((e.getAmountBorrowed() * e.getProductDefinition().getRate()) / e.getTotalNumberOfPayments());
                    e.setBalance(e.getBalance() - payment);
                }
            }

            //if loan has been paid off, nextBillingDate=null
            if (e.getProductDefinition().getProductType() == ProductType.LOAN && e.getNumberOfPaymentsRemaining() == 1) {
                e.setNextBillingDate(null);
            } else {
                //set next billing date
                switch (e.getProductDefinition().getUnit()) {
                    case DAY -> {
                        LocalDate nextBill = today.plusDays(e.getProductDefinition().getPayRateValue());
                        e.setNextBillingDate(nextBill);
                    }
                    case MONTH -> {
                        LocalDate nextBill = today.plusMonths(e.getProductDefinition().getPayRateValue());
                        e.setNextBillingDate(nextBill);
                    }
                }
            }
        }
        return new AsyncResult<>(productRepository.saveAllAndFlush(productsToBill));
    }
}
