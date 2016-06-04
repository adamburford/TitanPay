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
	public abstract int getEmployeeId();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract double getWeeklyDues();
	public abstract PaymentMethod getPaymentMethod();
	
	// Setters
	public abstract void setEmployeeId(int employeeId);
	public abstract void setFirstName(String firstName);
	public abstract void setLastName(String lastName);
	public abstract void setWeeklyDues(double weeklyDues);
	public abstract void setPaymentMethod(PaymentMethod paymentMethod);
	
	// Other Methods
	public abstract String getFullName();
	public abstract void pay(LocalDate startDate, LocalDate endDate);
}
