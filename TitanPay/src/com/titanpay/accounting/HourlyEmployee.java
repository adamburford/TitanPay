package com.titanpay.accounting;

import java.util.ArrayList;
import java.time.LocalDate;

public class HourlyEmployee extends Employee {

	// Constructor
	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues,  double hourlyRate, PaymentMethod paymentMethod) {
		super(employeeId, firstName, lastName, weeklyDues, paymentMethod);
		this.hourlyRate = hourlyRate;
		timeCards = new ArrayList<>();
	}
	
	public HourlyEmployee() {
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

	// Setters //
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
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
	public String pay(LocalDate startDate, LocalDate endDate) {
		double totalPay = 0.0;
		
		// Sum daily pay using TimeCard.calculateDailyPay() for every day from startDate to endDate inclusive
		for (TimeCard t : timeCards) {
			LocalDate d = t.getDate();
			if (d.isEqual(startDate) || d.isEqual(endDate) || (d.isAfter(startDate) && d.isBefore(endDate)) ) {
				totalPay += t.calculateDailyPay(hourlyRate);
			}
		}
		
		return paymentMethod.pay(totalPay);
	}
	
	public void addTimeCard(TimeCard t) {
		timeCards.add(t);
	}
}
