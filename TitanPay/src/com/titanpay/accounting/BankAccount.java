/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class BankAccount {
	// Constructors
	public BankAccount(String bankName, int routingNumber, int accountId) {
		this.bankName = bankName;
		this.routingNumber = routingNumber;
		this.accountId = accountId;
	}
	
	// Fields
	private String bankName;
	private int routingNumber;
	private int accountId;
	
	// Getters
	public String getBankName() {
		return bankName;
	}
	public int getRoutingNumber() {
		return routingNumber;
	}
	public int getAccountId() {
		return accountId;
	}
	
	// Setters
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	// Methods
	public void deposit(double amt) {
		System.out.printf("Depositing $%.2f" + " in " + bankName + " Account Number: " + accountId + " using Routing Number: " + routingNumber, amt);
	}
	

}
