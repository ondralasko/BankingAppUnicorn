package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.LoanDTO;
import cz.demo.BankingApp.entity.LoanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDTO toDto(LoanEntity source);
    LoanEntity toEntity(LoanDTO source);
}
