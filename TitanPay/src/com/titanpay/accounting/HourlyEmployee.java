package com.titanpay.accounting;

import java.util.ArrayList;
import java.time.LocalDate;

public class HourlyEmployee extends Employee implements Payable{

	// Constructor
	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues,  double hourlyRate, PaymentMethod paymentMethod) {
		super(employeeId, firstName, lastName, weeklyDues, paymentMethod);
		this.hourlyRate = hourlyRate;
		timeCards = new ArrayList<>();
	}
	
	// Fields
	private double hourlyRate;
	private ArrayList<TimeCard> timeCards;
	
	/* Methods */
	
	// Getters //
	public double getHourlyRate() {
		return hourlyRate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getWeeklyDues() {
		return weeklyDues;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
	
	// Setters //
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

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
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public void clockIn() {
		timeCards.add(0, new TimeCard());
	}
	public boolean clockOut() {
		for (TimeCard t : timeCards) {
			if ( t.getDate().isEqual(LocalDate.now()) ) {
				t.clockOut();
				return true;
			}
		}
		return false;
	}
	
	public void pay(LocalDate startDate, LocalDate endDate) {
		double totalPay = 0.0;
		
		// Sum daily pay using TimeCard.calculateDailyPay() for every day from startDate to endDate inclusive
		for (TimeCard t : timeCards) {
			LocalDate d = t.getDate();
			if (d.isEqual(startDate) || d.isEqual(endDate) || (d.isAfter(startDate) && d.isBefore(endDate)) ) {
				totalPay += t.calculateDailyPay(hourlyRate);
			}
		}
		
		paymentMethod.pay(totalPay);
	}
}
