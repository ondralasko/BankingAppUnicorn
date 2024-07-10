package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ProductDefinitionRepository extends JpaRepository<ProductDefinitionEntity, String> {
}
