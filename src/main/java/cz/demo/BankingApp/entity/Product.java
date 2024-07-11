package cz.demo.BankingApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity (name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    ProductDefinitionEntity productDefinition;

    @Column
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate nextBillingDate;

    @ManyToOne
    private UserEntity owner;

    @Column(nullable = false)
    private float balance;

}
