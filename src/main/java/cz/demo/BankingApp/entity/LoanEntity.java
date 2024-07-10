package cz.demo.BankingApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;


@EqualsAndHashCode(callSuper = true)
@Entity(name="loan")
@Data
public class LoanEntity extends ProductDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    private int amountBorrowed;

    @Column(nullable = false)
    private int amountRemaining;

    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate created;

    

    @ManyToOne
    private UserEntity owner;
}
