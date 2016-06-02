/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class Employee {

	// Fields
	private int employeeId;
	private String firstName;
	private String lastName;
	private double hourlyRate;
	private double weeklyDues;
	
	// Methods
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	// Constructor
	
	public Employee(int employeeId, String firstName, String lastName, double hourlyRate, double weeklyDues) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
		this.weeklyDues = weeklyDues;
	}
}
