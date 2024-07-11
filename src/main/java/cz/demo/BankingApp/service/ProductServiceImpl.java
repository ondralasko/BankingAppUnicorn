package cz.demo.BankingApp.service;

import cz.demo.BankingApp.constant.Operation;
import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.dto.AccountDTO;
import cz.demo.BankingApp.dto.LoanDTO;
import cz.demo.BankingApp.dto.Mapper.AccountMapper;
import cz.demo.BankingApp.dto.Mapper.LoanMapper;
import cz.demo.BankingApp.dto.Mapper.ProductDefinitionMapper;
import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.AccountEntity;
import cz.demo.BankingApp.entity.LoanEntity;
import cz.demo.BankingApp.entity.ProductDefinitionEntity;

import cz.demo.BankingApp.entity.Product;
import cz.demo.BankingApp.entity.repository.AccountRepository;
import cz.demo.BankingApp.entity.repository.LoanRepository;
import cz.demo.BankingApp.entity.repository.ProductDefinitionRepository;
import cz.demo.BankingApp.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
@EnableAsync
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDefinitionRepository productDefinitionRepository;
    @Autowired
    ProductDefinitionMapper productDefinitionMapper;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    LoanMapper loanMapper;


    @Override
    public List<ProductDefinitionDTO> getAllDefinitions() {
        return productDefinitionRepository.findAll().stream()
                .map(m->productDefinitionMapper.toDTO(m))
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
    public ProductDefinitionDTO updateProductDefinition(ProductDefinitionDTO newDefinition) {
        ProductDefinitionEntity entity = productDefinitionRepository.findByProductKey(newDefinition.getProductKey());
        for(Product e: entity.getProducts()){
            float newRatio = newDefinition.getRate()/e.getProductDefinition().getRate();
            if(e.getProductDefinition().getRate()>1){
                int newRate = Math.round(e.getProductDefinition().getRate()*newRatio);
                e.getProductDefinition().setRate(newRate);
            }else{
                float newRate= Math.round(e.getProductDefinition().getRate()*newRatio * 100)/100.0F;
                e.getProductDefinition().setRate(newRate);
            }
            e.getProductDefinition().setUnit(newDefinition.getUnit());
            e.getProductDefinition().setPayRateValue(newDefinition.getPayRateValue());
        }
        ProductDefinitionEntity updatedEntity = productDefinitionMapper.dtoToEntityRemap(entity, newDefinition);
        return productDefinitionMapper.toDTO(productDefinitionRepository.saveAndFlush(updatedEntity));
    }

    @Async
    private List<AccountDTO> billAccounts(LocalDate today) {
        List<AccountEntity> entitiesToBill = accountRepository.findByNextBillingDate(today);
        for(AccountEntity entity:entitiesToBill){
            if(entity.getProductDefinition().getRate()>1){
                entity.setBalance(entity.getBalance()-entity.getProductDefinition().getRate());
            }else{
                entity.setBalance(entity.getBalance()-entity.getBalance()*entity.getProductDefinition().getRate());
            }
            switch(entity.getProductDefinition().getUnit()){
                case DAY -> {
                    LocalDate nextBill = entity.getNextBillingDate().plusDays(entity.getProductDefinition().getPayRateValue());
                    entity.setNextBillingDate(nextBill);
                }
                case MONTH -> {
                    LocalDate nextBill = entity.getNextBillingDate().plusMonths(entity.getProductDefinition().getPayRateValue());
                    entity.setNextBillingDate(nextBill);
                }
                default -> {
                    return null;
                }
            }
        }
        return accountRepository.saveAllAndFlush(entitiesToBill).stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Async
    private List<LoanDTO> billLoans(LocalDate today) {
        List<LoanEntity> entitiesToBill = loanRepository.findByNextBillingDate(today);
        for(LoanEntity entity:entitiesToBill){
            if(entity.getProductDefinition().getRate()>1){
                entity.setBalance(entity.getBalance()-entity.getProductDefinition().getRate());
            }else{
                float payment = entity.getFixedRate() +
                        ((entity.getProductDefinition().getRate()*entity.getAmountBorrowed())/entity.getTotalNumberOfPayments());
                entity.setBalance(entity.getBalance()-payment);
            }
            if(entity.getNumberOfPaymentsRemaining()-1==0){
                entity.setNextBillingDate(null);
            }else{
                switch(entity.getProductDefinition().getUnit()){
                    case DAY -> {
                        LocalDate nextBill=entity.getNextBillingDate().plusDays(entity.getProductDefinition().getPayRateValue());
                        entity.setNextBillingDate(nextBill);
                    }
                    case MONTH -> {
                        LocalDate nextBill=entity.getNextBillingDate().plusMonths(entity.getProductDefinition().getPayRateValue());
                        entity.setNextBillingDate(nextBill);
                    }
                    default -> {
                        return null;
                    }
                }
            }
        }
        return loanRepository.saveAllAndFlush(entitiesToBill).stream()
                .map(loanMapper::toDto)
                .toList();
    }

    @Override
    @Async
    public List<ProductDefinitionDTO> billProducts() {
        LocalDate today =LocalDate.now();
        try {
            return Stream.concat(billAccounts(today).stream(), billLoans(today).stream()).toList();
        }catch (Exception e){
            System.out.println("Error while billing: "+e);
            return null;
        }

    }
}
