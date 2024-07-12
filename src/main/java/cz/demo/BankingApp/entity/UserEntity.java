package cz.demo.BankingApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity (name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userId;// rodné číslo

    @Column(nullable = false)
    private String phoneNumber;//tel číslo +420...
    /*
    @OneToMany(mappedBy = "owner")
    private ArrayList<ProductEntity> products;
    */


}
