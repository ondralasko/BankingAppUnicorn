package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.ProductDTO;
import cz.demo.BankingApp.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(ProductEntity source);
    ProductEntity toEntity(ProductDTO source);
}
