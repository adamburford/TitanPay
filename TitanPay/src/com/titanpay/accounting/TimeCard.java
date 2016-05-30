/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class TimeCard {

	// Fields
	private String date;
	private double startTime;
	private double endTime;
	
	// Methods
	public double calculateDailyPay(double rate) {
		double hours = endTime - startTime;
	
		if (hours > 8)
			return 8 * rate + ((hours - 8) * (rate * 1.5));
		else
			return hours * rate;
	}
}
