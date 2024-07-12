package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import cz.demo.BankingApp.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByNextBillingDate(LocalDate nextBillingDate);
    List<ProductEntity> findByProductDefinition(ProductDefinitionEntity productDefinition);
}
