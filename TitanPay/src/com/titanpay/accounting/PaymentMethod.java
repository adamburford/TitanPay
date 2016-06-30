package com.titanpay.accounting;

public abstract class PaymentMethod {

	// Constructor
	public PaymentMethod(String fullName) {
		this.fullName = fullName;
	}
	
	protected String fullName;
	
	public abstract String pay(double amt);
	
}
