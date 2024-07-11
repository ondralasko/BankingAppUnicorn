package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ProductDefinitionMapperImpl implements ProductDefinitionMapper {

    @Override
    public ProductDefinitionEntity toEntity(ProductDefinitionDTO source) {
        if ( source == null ) {
            return null;
        }

        ProductDefinitionEntity productDefinitionEntity = new ProductDefinitionEntity();

        productDefinitionEntity.setProductKey( source.getProductKey() );
        productDefinitionEntity.setProductType( source.getProductType() );
        productDefinitionEntity.setDescription( source.getDescription() );
        productDefinitionEntity.setRate( source.getRate() );
        productDefinitionEntity.setUnit( source.getUnit() );
        productDefinitionEntity.setPayRateValue( source.getPayRateValue() );

        return productDefinitionEntity;
    }

    @Override
    public ProductDefinitionDTO toDTO(ProductDefinitionEntity source) {
        if ( source == null ) {
            return null;
        }

        ProductDefinitionDTO productDefinitionDTO = new ProductDefinitionDTO();

        productDefinitionDTO.setProductKey( source.getProductKey() );
        productDefinitionDTO.setDescription( source.getDescription() );
        productDefinitionDTO.setRate( source.getRate() );
        productDefinitionDTO.setProductType( source.getProductType() );
        productDefinitionDTO.setUnit( source.getUnit() );
        productDefinitionDTO.setPayRateValue( source.getPayRateValue() );

        return productDefinitionDTO;
    }

    @Override
    public ProductDefinitionEntity dtoToEntityRemap(ProductDefinitionEntity entity, ProductDefinitionDTO source) {
        if ( source == null ) {
            return entity;
        }

        entity.setRate( source.getRate() );
        entity.setUnit( source.getUnit() );
        entity.setPayRateValue( source.getPayRateValue() );

        return entity;
    }
}
