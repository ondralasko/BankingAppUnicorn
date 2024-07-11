package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductDefinitionRepository extends JpaRepository<ProductDefinitionEntity, String> {
    ProductDefinitionEntity findByProductKey(String productKey);
}
