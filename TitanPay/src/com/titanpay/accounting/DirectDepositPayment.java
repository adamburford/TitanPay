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
	private static final long serialVersionUID = 1337L;

	
	public String pay(double amt) {
		return String.format("Depositing $%.2f" + " in " + bankName + " Account Number: " + accountId + " using Routing Number: " + routingNumber, amt);
	}

}
