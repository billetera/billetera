package com.billetera.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {
	
	@Id
	@Column(name="CategoryId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private String description;
	private String period;
	private String balance;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="category")
	@JsonManagedReference
	private List<Account> accounts;
	
	public Category()	{
		
		accounts = new ArrayList<Account>();
	}
	
	public String getBalance()	{
		
		if(id == 1) return "2.877,56 €";
		return "3.477,87 €";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPeriod() {
		
		/*period = "2017";
		
		if(id==2) period = "March 2017";*/
		
		return "2017";
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}	
}
