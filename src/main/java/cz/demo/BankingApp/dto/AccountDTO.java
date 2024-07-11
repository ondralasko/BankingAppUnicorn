package cz.demo.BankingApp.dto;


import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import cz.demo.BankingApp.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO extends ProductDefinitionDTO{

    private ProductDefinitionEntity productDefinition;
    private  int productId;
    private String iBan;
    private float balance;
    private LocalDate created;
    private LocalDate nextBillingDate;
    private UserEntity owner;

}
