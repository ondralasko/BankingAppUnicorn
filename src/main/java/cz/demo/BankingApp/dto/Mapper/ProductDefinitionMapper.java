package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.ProductDefinitionDTO;
import cz.demo.BankingApp.entity.ProductDefinitionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductDefinitionMapper {

    ProductDefinitionEntity toEntity(ProductDefinitionDTO source);
    ProductDefinitionDTO toDTO(ProductDefinitionEntity source);


    @Mapping(target = "productKey", ignore = true)
    @Mapping(target= "description", ignore = true)
    @Mapping(target = "productType", ignore = true)
    ProductDefinitionEntity dtoToEntityRemap(@MappingTarget ProductDefinitionEntity entity, ProductDefinitionDTO source);
}
