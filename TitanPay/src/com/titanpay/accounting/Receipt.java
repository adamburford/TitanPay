/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.time.LocalDate;

public class Receipt {
	// Constructor
	public Receipt(double saleAmt) {
		date = LocalDate.now();
		this.saleAmt = saleAmt;
	}
	
	public Receipt(LocalDate date, double saleAmt) {
		this.date = date;
		this.saleAmt = saleAmt;
	}
	
	// Fields
	private LocalDate date;
	private double saleAmt;
	
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
