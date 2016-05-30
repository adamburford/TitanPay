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
}
