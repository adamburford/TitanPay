package com.titanpay.accounting;

public class DirectDepositPayment extends PaymentMethod {

	// Constructor
	public DirectDepositPayment(String fullName, String bankName, int accountId, int routingNumber) {
		super(fullName);
		this.bankName = bankName;
		this.accountId = accountId;
		this.routingNumber = routingNumber;
	}

	// Fields
	private String bankName;
	private int accountId;
	private int routingNumber;

	
	public void pay(double amt) {
		System.out.printf("Depositing $%.2f" + " in " + bankName + " Account Number: " + accountId + " using Routing Number: " + routingNumber, amt);
	}

}
