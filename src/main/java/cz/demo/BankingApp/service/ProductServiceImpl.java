package cz.demo.BankingApp.service;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public ProductDefinitionDTO crateNewProductDefinition(ProductDefinitionDTO newDefinition) {
        return null;
    }

    @Override
    public ProductDefinitionDTO updateProductDefinition(ProductDefinitionDTO newDefinition) {
        return null;
    }
}
