/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receipt {
	
	static final AtomicLong NEXT_ID = new AtomicLong(0);
	
	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	final private long id = NEXT_ID.getAndIncrement();
	private LocalDate date;
	private double saleAmt;
	
	// Constructor
	public Receipt(double saleAmt) {
		date = LocalDate.now();
		this.saleAmt = saleAmt;
	}
	
	public Receipt(LocalDate date, double saleAmt) {
		this.date = date;
		this.saleAmt = saleAmt;
	}
	
	public Receipt() {
	}
	
	// Getters
	public LocalDate getDate() {
		return date;
	}
	public double getSaleAmt() {
		return saleAmt;
	}
	
	// Setters
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setSaleAmt(double saleAmt) {
		this.saleAmt = saleAmt;
	}
	
	// Methods
	
}
