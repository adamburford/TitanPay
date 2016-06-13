/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

import java.util.ArrayList;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {
	
	// Constructor
	public SalariedEmployee(int employeeId, String firstName, String lastName, double weeklyDues, double salary, double commissionRate, PaymentMethod paymentMethod) {
		super(employeeId, firstName, lastName, weeklyDues, paymentMethod);
		this.salary = salary;
		this.commissionRate = commissionRate;
		receipts = new ArrayList<>();
	}
		
	// Fields
	private double salary;
	private double commissionRate;
	private ArrayList<Receipt> receipts;
	
	/* Methods */
	
	// Getters
	public double getSalary() {
		return salary;
	}
	public double getCommissionRate() {
		return commissionRate;
	}

	// Setters
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	// Other Methods
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public void makeSale(double amt) {
		receipts.add(0, new Receipt(LocalDate.now(), amt));
	}
	public void makeSale(LocalDate date, double amt) {
		receipts.add(0, new Receipt(date, amt));
	}
	
	public void pay(LocalDate startDate, LocalDate endDate) {
		double totalPay = salary;
		
		for (Receipt r : receipts) {
			LocalDate d = r.getDate();
			if (d.isEqual(startDate) || d.isEqual(endDate) || (d.isAfter(startDate) && d.isBefore(endDate)) ) {
				totalPay += r.getSaleAmt() * commissionRate;
			}
		}
		
		paymentMethod.pay(totalPay);
	}
}
