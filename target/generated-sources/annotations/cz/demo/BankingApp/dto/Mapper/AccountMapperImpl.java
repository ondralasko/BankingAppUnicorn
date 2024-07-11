package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.AccountDTO;
import cz.demo.BankingApp.entity.AccountEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO toDto(AccountEntity source) {
        if ( source == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setProductDefinition( source.getProductDefinition() );
        accountDTO.setProductId( source.getProductId() );
        accountDTO.setIBan( source.getIBan() );
        accountDTO.setBalance( source.getBalance() );
        accountDTO.setCreated( source.getCreated() );
        accountDTO.setNextBillingDate( source.getNextBillingDate() );
        accountDTO.setOwner( source.getOwner() );

        return accountDTO;
    }

    @Override
    public AccountEntity toEntity(AccountDTO source) {
        if ( source == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setProductId( source.getProductId() );
        accountEntity.setProductDefinition( source.getProductDefinition() );
        accountEntity.setNextBillingDate( source.getNextBillingDate() );
        accountEntity.setOwner( source.getOwner() );
        accountEntity.setBalance( source.getBalance() );
        accountEntity.setIBan( source.getIBan() );
        accountEntity.setCreated( source.getCreated() );

        return accountEntity;
    }
}
