package cz.demo.BankingApp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoanEntity extends Product {

    @Column(nullable = false)
    private int amountBorrowed;

    @Column
    private int fixedRate;

    @Column(nullable = false)
    private int numberOfPaymentsRemaining;

    @Column(nullable = false)
    private int totalNumberOfPayments;

    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate created;

}
