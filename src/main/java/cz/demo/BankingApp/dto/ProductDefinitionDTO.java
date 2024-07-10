package cz.demo.BankingApp.dto;

import cz.demo.BankingApp.constant.Operation;
import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.constant.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDefinitionDTO {

    private Operation operation;
    private String productKey;
    private String description;
    private ProductType type;
    private float rate;
    private PayRateUnit unit;
    private int value;


}
