package cz.demo.BankingApp.service.interfaces;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    List<ProductDefinitionDTO> getAllDefinitions();
    ProductDefinitionDTO getDefinitionByProductKey(String key);
    ProductDefinitionDTO crateNewProductDefinition(ProductDefinitionDTO newDefinition);
    ProductDefinitionDTO updateProductDefinition (ProductDefinitionDTO newDefinition);
    List<ProductDefinitionDTO> billProducts();
}
