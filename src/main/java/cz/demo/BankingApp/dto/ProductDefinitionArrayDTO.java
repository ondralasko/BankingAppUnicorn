package cz.demo.BankingApp.dto;

import cz.demo.BankingApp.constant.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDefinitionArrayDTO {
    ProductDefinitionDTO[] definitions;
}
