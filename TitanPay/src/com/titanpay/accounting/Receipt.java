/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.util.Date;

public class Receipt {

	// Fields
	private Date date;
	private double saleAmt;
	
	// Methods
	
	// Constructor
	public Receipt(Date date, double saleAmt) {
		this.date = date;
		this.saleAmt = saleAmt;
	}
}
