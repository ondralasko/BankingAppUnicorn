package cz.demo.BankingApp;


import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import cz.demo.BankingApp.entity.ProductEntity;
import cz.demo.BankingApp.entity.repository.ProductDefinitionRepository;
import cz.demo.BankingApp.entity.repository.ProductRepository;
import cz.demo.BankingApp.service.interfaces.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
class BankingAppApplicationTests {

	@Autowired
	ProductDefinitionRepository productDefinitionRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;

	ProductDefinitionEntity oldLoanDefinition;
	ProductDefinitionEntity oldAccountDefinition;

	@BeforeEach
	public void setUp(){
		ProductDefinitionEntity loanDefinition = productDefinitionRepository.findByProductKey("TEST01");
		oldLoanDefinition= productDefinitionRepository.findByProductKey("TEST01");
		ProductDefinitionEntity accountDefinition = productDefinitionRepository.findByProductKey("TEST02");
		oldAccountDefinition = productDefinitionRepository.findByProductKey("TEST02");

		loanDefinition.setRate(0.12f);
		loanDefinition.setPayRateValue(3);
		loanDefinition.setUnit(PayRateUnit.MONTH);
		accountDefinition.setRate(150f);
		accountDefinition.setPayRateValue(14);
		accountDefinition.setUnit(PayRateUnit.DAY);
		productDefinitionRepository.saveAndFlush(loanDefinition);
		productDefinitionRepository.saveAndFlush(accountDefinition);


		ProductEntity loan = productRepository.findByProductDefinition(loanDefinition).get(0);
		ProductEntity account = productRepository.findByProductDefinition(accountDefinition).get(0);
		loan.setNextBillingDate(LocalDate.of(1980,1,1));
		loan.setBalance(100000000.0f);
		loan.setNumberOfPaymentsRemaining(50);
		account.setNextBillingDate(LocalDate.of(1980,1,1));
		account.setBalance(100000000.0f);
		productRepository.saveAndFlush(loan);
		productRepository.saveAndFlush(account);
	}

	@AfterEach
	public void reset(){
		productDefinitionRepository.saveAndFlush(oldAccountDefinition);
		productDefinitionRepository.saveAndFlush(oldLoanDefinition);
	}

	@Test
	public void testBilling(){
		LocalDate date = LocalDate.of(1980,1,1);
		Future<List<ProductEntity>> future = productService.billProducts(date);
		List<ProductEntity> billedEntities = new ArrayList<>();
		try{
			billedEntities = future.get();
		}catch(Exception e) {
			System.out.println(e);
		}

		assert billedEntities.get(0).getBalance()==9.9759904E7; //value accounts for floating point error
		assert billedEntities.get(0).getNextBillingDate().equals(LocalDate.of(1980,4,1));
		assert billedEntities.get(1).getBalance()==9.9999848E7; //value accounts for floating point error
		assert billedEntities.get(1).getNextBillingDate().equals(LocalDate.of(1980,1,15));

	}







}
