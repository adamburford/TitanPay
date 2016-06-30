package com.titanpay.accounting;

public class MailPayment extends PaymentMethod {

	// Constructor
	public MailPayment(String fullName, String address) {
		super(fullName);
		this.address = address;
	}
	
	// Fields
	private String address;
	
	public String pay(double amt) {
		return String.format("Mailing a check to " + fullName + " for $%.2f to " + address, amt);
	}

}
