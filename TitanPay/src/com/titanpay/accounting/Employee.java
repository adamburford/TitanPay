/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.time.LocalDate;

public abstract class Employee implements Payable {

	// Constructor
	public Employee(int employeeId, String firstName, String lastName, double weeklyDues, PaymentMethod paymentMethod) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
	}
	
	// Fields
	protected int employeeId;
	protected String firstName;
	protected String lastName;
	protected double weeklyDues;
	protected PaymentMethod paymentMethod;
	
	/* Methods */
	
	// Getters
	public int 				getEmployeeId() {
		return employeeId;
	}
	public String 			getFirstName() {
		return firstName;
	}
	public String 			getLastName() {
		return lastName;
	}
	public double 			getWeeklyDues() {
		return weeklyDues;
	}
	public PaymentMethod 	getPaymentMethod() {
		return paymentMethod;
	}
	
	// Setters
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setWeeklyDues(double weeklyDues) {
		this.weeklyDues = weeklyDues;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	// Other Methods
	public abstract String getFullName();
	public abstract void pay(LocalDate startDate, LocalDate endDate);
}
