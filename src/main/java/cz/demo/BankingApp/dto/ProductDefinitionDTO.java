package cz.demo.BankingApp.dto;

import cz.demo.BankingApp.constant.Operation;
import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.constant.ProductType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDefinitionDTO {

    @Getter
    @Setter
    public class payRate {
        String unit;
        String value;
    }
    private String operation;
    private String productKey;
    private String description;
    private String type;
    private float rate;
    private payRate payRate;

    private ProductType productType;
    private PayRateUnit unit;
    private int payRateValue;


}
