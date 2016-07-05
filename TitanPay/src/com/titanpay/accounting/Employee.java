/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Employee implements Payable {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int employeeId;
	protected String firstName;
	protected String lastName;
	protected double weeklyDues;
	protected PaymentMethod paymentMethod;
	protected Address address;

	// Constructor
	public Employee(int employeeId, String firstName, String lastName, double weeklyDues) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
		this.paymentMethod = new PickUpPayment(this.getFullName());
	}
	
	public Employee(int employeeId, String firstName, String lastName, double weeklyDues, PaymentMethod paymentMethod) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
		this.paymentMethod = paymentMethod;
	}
	
	public Employee(int employeeId, String firstName, String lastName, double weeklyDues, PaymentMethod paymentMethod, Address address) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
		this.paymentMethod = paymentMethod;
		this.address = address;
	}
	
	public Employee() {	}
	
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
	public abstract String pay(LocalDate startDate, LocalDate endDate);
}
