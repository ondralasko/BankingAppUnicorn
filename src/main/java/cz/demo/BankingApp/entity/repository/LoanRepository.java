package cz.demo.BankingApp.entity.repository;

import cz.demo.BankingApp.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
}
