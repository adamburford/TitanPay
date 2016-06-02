/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.util.Date;

public class Receipt {
	// Constructor
	public Receipt(Date date, double saleAmt) {
		this.date = date;
		this.saleAmt = saleAmt;
	}
	
	// Fields
	private Date date;
	private double saleAmt;
	
	// Getters
	public Date getDate() {
		return date;
	}
	public double getSaleAmt() {
		return saleAmt;
	}
	
	// Setters
	public void setDate(Date date) {
		this.date = date;
	}
	public void setSaleAmt(double saleAmt) {
		this.saleAmt = saleAmt;
	}
	
	
	
	// Methods
	
}
