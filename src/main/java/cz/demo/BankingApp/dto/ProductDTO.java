package cz.demo.BankingApp.dto;

import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import cz.demo.BankingApp.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer Id;
    private ProductDefinitionEntity productDefinition;
    private LocalDate nextBillingDate;
    private UserEntity owner;
    private Float balance;
    private Integer amountBorrowed;
    private Integer fixedRate;
    private String iBan;
    private Integer numberOfPaymentsRemaining;
    private Integer totalNumberOfPayments;
    private LocalDate created;


}
