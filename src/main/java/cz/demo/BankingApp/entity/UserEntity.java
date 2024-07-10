package cz.demo.BankingApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstNAme;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userId;// rodné číslo

    @Column(nullable = false)
    private String phoneNumber;//tel číslo +420...

    @OneToMany(mappedBy = "owner")
    private ArrayList<LoanEntity> loans;

    @OneToMany(mappedBy = "owner")
    private ArrayList<AccountEntity> accounts;
}
