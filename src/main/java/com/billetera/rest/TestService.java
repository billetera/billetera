package com.billetera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billetera.business.Account;
import com.billetera.business.AccountRepository;
import com.billetera.business.Category;
import com.billetera.business.CategoryRepository;
import com.billetera.business.Transaction;
import com.billetera.business.TransactionRepository;

@RestController
public class TestService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	@RequestMapping(value = "/create-testdata", method = RequestMethod.POST)	
	public void loadTestData()	{
		
		Category bankAccounts = new Category();
		bankAccounts.setName("Bank Accounts");
		bankAccounts.setDescription("All Bank Accounts");		
		categoryRepository.save(bankAccounts);
		
		Category expenses = new Category();
		expenses.setName("Expenses");
		expenses.setDescription("All Expenses");		
		categoryRepository.save(expenses);		
		
		Account commerzBank = new Account();
		commerzBank.setName("Commerzbank");
		commerzBank.setDescription("Commerzbank Girokonto");
		commerzBank.setCategory(bankAccounts);	
		accountRepository.save(commerzBank);
		
		Account comdirect = new Account();
		comdirect.setName("Comdirect");
		comdirect.setDescription("Comdirect Konto");
		comdirect.setCategory(bankAccounts);	
		accountRepository.save(comdirect);
		
		Account psd = new Account();
		psd.setName("PSD");
		psd.setDescription("PSD Loan Account");
		psd.setCategory(bankAccounts);	
		accountRepository.save(psd);
		
		Account building = new Account();
		building.setName("Building");
		building.setDescription("Building Expenses");
		building.setCategory(expenses);
		accountRepository.save(building);
		
		commerzBank.addPlusTransaction(1000, psd, "Take Loan");
		commerzBank.addMinusTransaction(100, building, "Build Keller");
		
		accountRepository.save(commerzBank);
	}
}
