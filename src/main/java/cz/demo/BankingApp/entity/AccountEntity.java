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

public class AccountEntity extends Product {

    @Column(nullable = false)
    private String iBan;

    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate created;


}
