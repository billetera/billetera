package com.billetera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.billetera.business.Account;
import com.billetera.business.AccountRepository;
import com.billetera.business.Category;
import com.billetera.business.CategoryRepository;

@SpringBootApplication
public class BilleteraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BilleteraApplication.class, args);
	}	
}
