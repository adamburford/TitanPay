/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class BankAccount {

	// Fields
	private String bankName;
	private int routingNumber;
	private long accountId;
	
	// Methods
	public void deposit(double amt) {
		System.out.printf("Depositing $%.2f" + " in " + bankName + " Account Number: " + accountId + " using Routing Number: " + routingNumber, amt);
	}
}
