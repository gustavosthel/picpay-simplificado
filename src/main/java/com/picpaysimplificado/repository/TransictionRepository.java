package com.picpaysimplificado.repository;

import com.picpaysimplificado.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransictionRepository extends JpaRepository<Transaction, Long> {
}
