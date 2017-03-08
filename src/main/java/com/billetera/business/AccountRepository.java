package com.billetera.business;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
	
	public List<Account> findById(Long accountId);
	public List<Account> findByName(String accountName);
}
