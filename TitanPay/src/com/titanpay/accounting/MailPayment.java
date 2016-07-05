package com.titanpay.accounting;

public class MailPayment extends PaymentMethod {

	// Constructor
	public MailPayment(String fullName, Address address) {
		super(fullName);
		this.address = address;
	}
	
	// Fields
	private Address address;
	private static final long serialVersionUID = 1337L;
	
	public String pay(double amt) {
		return String.format("Mailing a check to " + fullName + " for $%.2f to " + address, amt);
	}

}
