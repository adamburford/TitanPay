package com.titanpay.accounting;

public class HourlyEmployee extends Employee {

	// Constructo
	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues,  double hourlyRate) {
		super(employeeId, firstName, lastName, weeklyDues);
		this.hourlyRate = hourlyRate;
	}
	// Fields
	private double hourlyRate;
	
	/* Methods */
	
	// Getters //
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	// Setters //
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
