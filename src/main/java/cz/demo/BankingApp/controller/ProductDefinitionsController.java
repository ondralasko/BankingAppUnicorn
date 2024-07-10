package cz.demo.BankingApp.controller;

import cz.demo.BankingApp.dto.ProductDefinitionArrayDTO;
import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/definitions")
public class ProductDefinitionsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public List<ProductDefinitionDTO> updateDefinitions(@RequestBody ProductDefinitionArrayDTO productDefinitionArrayDTO){
        return null;
    }
}
