package com.billetera.business;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	public List<Transaction> findById(Long transactionId);
}
