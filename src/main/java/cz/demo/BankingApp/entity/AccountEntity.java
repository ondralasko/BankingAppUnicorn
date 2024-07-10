package cz.demo.BankingApp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name="account")
@Data
public class AccountEntity extends ProductDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int productId;

    @Column(nullable = false)
    private String iBan;

    @Column(nullable = false)
    private int Balance;

    @ManyToOne
    private UserEntity owner;

}
