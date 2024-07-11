package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.AccountDTO;
import cz.demo.BankingApp.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO toDto(AccountEntity source);
    AccountEntity toEntity(AccountDTO source);
}
