package com.titanpay.accounting;

import javax.persistence.Entity;

@Entity
public abstract class PaymentMethod implements java.io.Serializable {

	// Constructor
	public PaymentMethod(String fullName) {
		this.fullName = fullName;
		
	}
	
	protected String fullName;
	private static final long serialVersionUID = 1337L;
	public abstract String pay(double amt);
	
}
