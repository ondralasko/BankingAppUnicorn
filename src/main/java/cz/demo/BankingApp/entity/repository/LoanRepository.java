package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
    List<LoanEntity> findByNextBillingDate(LocalDate nextBillingDate);
}
