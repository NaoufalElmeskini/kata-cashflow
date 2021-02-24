package com.talan.banking.cashflow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="payerid")
	private int payerid; // The one who pays
	
	@Column(name="payeeid")
	private int payeeid; // The one who's payed
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="date")
	private Date date;
	
	
	public Transaction() {}
	
	public Transaction(int id, int payerid, int payeeid, float amount, Date date) {
		super();
		this.id = id;
		this.payerid = payerid;
		this.payeeid = payeeid;
		this.amount = amount;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayerid() {
		return payerid;
	}

	public void setPayerid(int payerid) {
		this.payerid = payerid;
	}

	public int getPayeeid() {
		return payeeid;
	}

	public void setPayeeid(int payeeid) {
		this.payeeid = payeeid;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", payerid=" + payerid + ", payeeid=" + payeeid + ", amount=" + amount
				+ ", date=" + date + "]";
	}
}
