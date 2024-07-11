package cz.demo.BankingApp.dto;

import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import cz.demo.BankingApp.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO extends ProductDefinitionDTO{

    private ProductDefinitionEntity productDefinition;
    private int productId;
    private int amountBorrowed;
    private int fixedRate;
    private float balance;
    private int numberOfPaymentsRemaining;
    private int totalNumberOfPayments;
    private LocalDate created;
    private LocalDate nextBillingDate;
    private UserEntity owner;
}

