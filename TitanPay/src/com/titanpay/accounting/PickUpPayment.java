package com.titanpay.accounting;

public class PickUpPayment extends PaymentMethod {

	// Constructor 
	public PickUpPayment(String fullName) {
		super(fullName);
	}
	
	public String pay(double amt) {
		return String.format("A check for $%.2f is waiting for " + fullName + " at the PostMaster.", amt);
	}

}
