/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class SalariedEmployee extends Employee {
	
	// Constructor
	public SalariedEmployee(int employeeId, String firstName, String lastName, double weeklyDues, double salary, double commissionRate) {
		super(employeeId, firstName, lastName, weeklyDues);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
		
	// Fields
	private double salary;
	private double commissionRate;
	
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
	
}
