package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
