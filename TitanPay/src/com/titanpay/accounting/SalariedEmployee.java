/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class SalariedEmployee {

	// Fields
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private double commissionRate;
	private double weeklyDues;
	
	// Methods
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	// Constructor
	public SalariedEmployee(int employeeId, String firstName, String lastName, double salary, double commissionRate, double weeklyDues) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.weeklyDues = weeklyDues;
	}
}
