package com.titanpay.accounting;

public class PickUpPayment extends PaymentMethod {

	// Constructor 
	public PickUpPayment(String fullName) {
		super(fullName);
	}
	
	public void pay(double amt) {
		System.out.printf("A check for $%.2f is waiting for " + fullName + " at the PostMaster.", amt);
	}

}
