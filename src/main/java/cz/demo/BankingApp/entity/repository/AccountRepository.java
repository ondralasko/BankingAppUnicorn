package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    List<AccountEntity> findByNextBillingDate(LocalDate nextBillingDate);

}
