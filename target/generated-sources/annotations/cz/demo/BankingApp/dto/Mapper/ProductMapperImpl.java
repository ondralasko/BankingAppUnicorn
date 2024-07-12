package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.ProductDTO;
import cz.demo.BankingApp.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(ProductEntity source) {
        if ( source == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( source.getId() );
        productDTO.setProductDefinition( source.getProductDefinition() );
        productDTO.setNextBillingDate( source.getNextBillingDate() );
        productDTO.setOwner( source.getOwner() );
        productDTO.setBalance( source.getBalance() );
        productDTO.setAmountBorrowed( source.getAmountBorrowed() );
        productDTO.setFixedRate( source.getFixedRate() );
        productDTO.setIBan( source.getIBan() );
        productDTO.setNumberOfPaymentsRemaining( source.getNumberOfPaymentsRemaining() );
        productDTO.setTotalNumberOfPayments( source.getTotalNumberOfPayments() );
        productDTO.setCreated( source.getCreated() );

        return productDTO;
    }

    @Override
    public ProductEntity toEntity(ProductDTO source) {
        if ( source == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( source.getId() );
        productEntity.setProductDefinition( source.getProductDefinition() );
        productEntity.setNextBillingDate( source.getNextBillingDate() );
        productEntity.setOwner( source.getOwner() );
        productEntity.setBalance( source.getBalance() );
        productEntity.setAmountBorrowed( source.getAmountBorrowed() );
        productEntity.setFixedRate( source.getFixedRate() );
        productEntity.setIBan( source.getIBan() );
        productEntity.setNumberOfPaymentsRemaining( source.getNumberOfPaymentsRemaining() );
        productEntity.setTotalNumberOfPayments( source.getTotalNumberOfPayments() );
        productEntity.setCreated( source.getCreated() );

        return productEntity;
    }
}
