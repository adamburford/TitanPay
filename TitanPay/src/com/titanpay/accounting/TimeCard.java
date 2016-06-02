/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */
package com.titanpay.accounting;

import java.util.Date;

public class TimeCard {
	// Constructor
	public TimeCard(Date date, Date startTime, Date endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	// Fields
	private Date date;
	private Date startTime;
	private Date endTime;
	
	
	// Getters
	public Date getDate() {
		return date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	// Setters
	public void setDate(Date date) {
		this.date = date;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	// Methods
	public double calculateDailyPay(double rate) {
		double hours = (endTime.getTime() - startTime.getTime()) / 1000 / 60 / 60;			// Covert milliseconds to hours
	
		if (hours > 8)
			return 8 * rate + ((hours - 8) * (rate * 1.5));
		else
			return hours * rate;
	}
	
	

}
