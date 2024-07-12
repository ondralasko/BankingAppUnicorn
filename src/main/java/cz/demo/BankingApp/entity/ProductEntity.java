package cz.demo.BankingApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @ManyToOne
    ProductDefinitionEntity productDefinition;

    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate nextBillingDate;

    @ManyToOne
    private UserEntity owner;

    @Column(nullable = false)
    private Float balance;

    @Column
    private Integer amountBorrowed;

    @Column
    private Integer fixedRate;

    @Column
    private String iBan;

    @Column
    private Integer numberOfPaymentsRemaining;

    @Column
    private Integer totalNumberOfPayments;

    @Column
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate created;
}
