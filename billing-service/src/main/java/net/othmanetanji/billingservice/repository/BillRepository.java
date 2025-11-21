package net.othmanetanji.billingservice.repository;

import net.othmanetanji.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<Bill, Long> {
}
