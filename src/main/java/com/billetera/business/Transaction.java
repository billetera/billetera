package com.billetera.business;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PlusAccountId")	
	@JsonBackReference
	private Account plusAccount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MinusAccountId")	
	@JsonBackReference
	private Account minusAccount;
	
	private double amount;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getPlusAccount() {
		return plusAccount;
	}

	public void setPlusAccount(Account plusAccount) {
		this.plusAccount = plusAccount;
	}

	public Account getMinusAccount() {
		return minusAccount;
	}

	public void setMinusAccount(Account minusAccount) {
		this.minusAccount = minusAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
