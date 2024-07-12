package cz.demo.BankingApp.service.interfaces;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.ProductEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Future;

public interface ProductService {
    List<ProductDefinitionDTO> getAllDefinitions();
    ProductDefinitionDTO getDefinitionByProductKey(String key);
    ProductDefinitionDTO crateNewProductDefinition(ProductDefinitionDTO newDefinition);
    ProductDefinitionDTO updateProductDefinition (ProductDefinitionDTO newDefinition);
    Future<List<ProductEntity>> billProducts(LocalDate today);
    void setBillingDate();
    void generateTestData();
}
