package cz.demo.BankingApp.service.interfaces;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;

public interface ProductService {
    public ProductDefinitionDTO crateNewProductDefinition(ProductDefinitionDTO newDefinition);
    public ProductDefinitionDTO updateProductDefinition (ProductDefinitionDTO newDefinition);
}
