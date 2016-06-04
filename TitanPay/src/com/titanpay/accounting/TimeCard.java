/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */
package com.titanpay.accounting;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeCard {
	// Constructors
	
	// Makes a new time card with the current time as startTime and the current day as date
	public TimeCard() {
		this.startTime = LocalDateTime.now();
		this.date = startTime.toLocalDate();
	}
	public TimeCard(LocalDate date) {
		this.date = date;
	}
	public TimeCard(LocalDate date, LocalDateTime startTime) {
		this.date = date;
		this.startTime = startTime;
	}	
	public TimeCard(LocalDate date, LocalDateTime startTime, LocalDateTime endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	// Fields
	private LocalDate date;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	
	// Getters
	public LocalDate getDate() {
		return date;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}

	// Setters
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	// Methods
	public double calculateDailyPay(double rate) {
		double hours = ChronoUnit.SECONDS.between(startTime,  endTime) / (60 * 60);
		
		if (hours > 8)
			return 8 * rate + ((hours - 8) * (rate * 1.5));
		else
			return hours * rate;
	}
	
	public void clockIn() {
		this.startTime = LocalDateTime.now();
	}
	public void clockOut() {
		this.endTime = LocalDateTime.now();
	}
}
