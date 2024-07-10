package cz.demo.BankingApp.entity;

import cz.demo.BankingApp.constant.PayRateUnit;
import cz.demo.BankingApp.constant.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="product_definition")
@Data
public class ProductDefinitionEntity {

    @Id
    private String productKey;

    @Column(nullable = false)
    private ProductType productType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float rate;

    @Column(nullable = false)
    private PayRateUnit unit;

    @Column(nullable = false)
    private int payRateValue;
}
