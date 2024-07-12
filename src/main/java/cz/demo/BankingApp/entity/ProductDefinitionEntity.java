package cz.demo.BankingApp.entity;

import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.constant.ProductType;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity(name="productDefinition")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column (nullable = false)
    private String productKey;

    @Column(nullable = false)
    private ProductType productType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float rate;

    @Column(nullable = false)
    private PayRateUnit unit; //MONTH or DAY

    @Column(nullable = false)
    private int payRateValue; //how frequently account is billed

    @OneToMany(mappedBy = "productDefinition")
    private List<ProductEntity> products;


}
