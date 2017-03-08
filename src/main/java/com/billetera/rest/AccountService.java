package com.billetera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billetera.business.Account;
import com.billetera.business.AccountRepository;

@RestController
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public void createAccount(@RequestBody Account account)	{
		
		accountRepository.save(account);
	}
	
	@RequestMapping(value = "/get-accounts", method = RequestMethod.GET)
	public Iterable<Account> getAccounts()	{
		
		return accountRepository.findAll();
	}	
	
	@RequestMapping(value = "/get-accounts-by-name", method = RequestMethod.GET)
	public List<Account> getAccounts(@RequestBody String accountName)	{
		
		return accountRepository.findByName(accountName);
	}		
	
	@RequestMapping(value="/add-plus-transaction", method = RequestMethod.POST)
	public void addPlusTransaction(double amount)	{		
		
	}
}
