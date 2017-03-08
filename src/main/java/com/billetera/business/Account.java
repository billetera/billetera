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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

	@Id
	@Column(name="AccountId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CategoryId")	
	@JsonBackReference
	private Category category;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="plusAccount")
	@JsonManagedReference
	private List<Transaction> plusTransactions;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="minusAccount")
	@JsonManagedReference
	private List<Transaction> minusTransactions;
	
	public Account()	{
		
		plusTransactions = new ArrayList<Transaction>();
		minusTransactions = new ArrayList<Transaction>();
	}
	
	public void addPlusTransaction(double amount, Account minusAccount, String description)	{
		
		Transaction plusTransaction = new Transaction();
		plusTransaction.setPlusAccount(this);
		plusTransaction.setMinusAccount(minusAccount);
		plusTransaction.setAmount(amount);
		plusTransaction.setDescription(description);
		plusTransactions.add(plusTransaction);
	}
	
	public void addMinusTransaction(double amount, Account plusAccount, String description)	{
		
		Transaction minusTransaction = new Transaction();
		minusTransaction.setMinusAccount(this);
		minusTransaction.setPlusAccount(plusAccount);
		minusTransaction.setAmount(amount);
		minusTransaction.setDescription(description);
		minusTransactions.add(minusTransaction);
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Transaction> getPlusTransactions() {
		return plusTransactions;
	}
	public void setPlusTransactions(List<Transaction> plusTransactions) {
		this.plusTransactions = plusTransactions;
	}
	public List<Transaction> getMinusTransactions() {
		return minusTransactions;
	}
	public void setMinusTransactions(List<Transaction> minusTransactions) {
		this.minusTransactions = minusTransactions;
	}		
}
