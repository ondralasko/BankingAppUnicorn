package cz.demo.BankingApp.controller;

import cz.demo.BankingApp.constant.Operation;
import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.constant.ProductType;
import cz.demo.BankingApp.dto.ProductDefinitionArrayDTO;
import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/definitions")
public class ProductDefinitionsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public List<ProductDefinitionDTO> updateDefinitions(@RequestBody ProductDefinitionArrayDTO productDefinitionArrayDTO){
        List<ProductDefinitionDTO> dtoList = Arrays.stream(productDefinitionArrayDTO.getDefinitions()).toList();
        for(ProductDefinitionDTO dto:dtoList){
            dto.setProductType(ProductType.valueOf(dto.getType()));
            dto.setUnit(PayRateUnit.valueOf(dto.getPayRate().getUnit()));
            dto.setPayRateValue(Integer.parseInt(dto.getPayRate().getValue()));
            switch (Operation.valueOf(dto.getOperation())){
                case U -> productService.updateProductDefinition(dto);
                case N -> productService.crateNewProductDefinition(dto);
                default -> {
                    return null;
                }
            }
        }
        return dtoList;
    }

    @GetMapping("/")
    public List<ProductDefinitionDTO> getAllDefinitions(){
        return productService.getAllDefinitions();
    }

}
