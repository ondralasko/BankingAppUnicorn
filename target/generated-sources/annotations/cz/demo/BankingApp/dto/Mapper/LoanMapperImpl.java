package cz.demo.BankingApp.dto.Mapper;

import cz.demo.BankingApp.dto.LoanDTO;
import cz.demo.BankingApp.entity.LoanEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanDTO toDto(LoanEntity source) {
        if ( source == null ) {
            return null;
        }

        LoanDTO loanDTO = new LoanDTO();

        loanDTO.setProductDefinition( source.getProductDefinition() );
        loanDTO.setProductId( source.getProductId() );
        loanDTO.setAmountBorrowed( source.getAmountBorrowed() );
        loanDTO.setFixedRate( source.getFixedRate() );
        loanDTO.setBalance( source.getBalance() );
        loanDTO.setNumberOfPaymentsRemaining( source.getNumberOfPaymentsRemaining() );
        loanDTO.setTotalNumberOfPayments( source.getTotalNumberOfPayments() );
        loanDTO.setCreated( source.getCreated() );
        loanDTO.setNextBillingDate( source.getNextBillingDate() );
        loanDTO.setOwner( source.getOwner() );

        return loanDTO;
    }

    @Override
    public LoanEntity toEntity(LoanDTO source) {
        if ( source == null ) {
            return null;
        }

        LoanEntity loanEntity = new LoanEntity();

        loanEntity.setProductId( source.getProductId() );
        loanEntity.setProductDefinition( source.getProductDefinition() );
        loanEntity.setNextBillingDate( source.getNextBillingDate() );
        loanEntity.setOwner( source.getOwner() );
        loanEntity.setBalance( source.getBalance() );
        loanEntity.setAmountBorrowed( source.getAmountBorrowed() );
        loanEntity.setFixedRate( source.getFixedRate() );
        loanEntity.setNumberOfPaymentsRemaining( source.getNumberOfPaymentsRemaining() );
        loanEntity.setTotalNumberOfPayments( source.getTotalNumberOfPayments() );
        loanEntity.setCreated( source.getCreated() );

        return loanEntity;
    }
}
