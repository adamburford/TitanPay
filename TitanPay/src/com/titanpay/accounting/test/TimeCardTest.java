package com.titanpay.accounting.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.titanpay.accounting.*;

public class TimeCardTest {

	@Test
	public void testCalculateDailyPay() {
		LocalDate now = LocalDate.now();
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = startTime.plus(8, ChronoUnit.HOURS);
		TimeCard testTimeCard = new TimeCard(now, startTime, endTime);
		double rate = 50.0;
		
		double pay = testTimeCard.calculateDailyPay(rate);
		
		assertEquals("Pay amount not equal", (Double)(rate * 8.0), (Double)pay);
	}

	@Test
	public void testClockIn() {
		TimeCard t = new TimeCard();
		t.clockIn();
		LocalDateTime startTime = t.getStartTime();
		
		LocalDateTime now = LocalDateTime.now();
		
		assertTrue("start time too late", startTime.isBefore(now.plus(3, ChronoUnit.SECONDS)));
		assertTrue("start time too early", startTime.isAfter(now.minus(5, ChronoUnit.SECONDS)));
	}

	@Test
	public void testClockOut() {
		TimeCard t = new TimeCard();
		
		t.clockIn();
		t.clockOut();
		
		LocalDateTime endTime = t.getEndTime();
		
		LocalDateTime now = LocalDateTime.now();
		
		assertTrue("start time too late", endTime.isBefore(now.plus(3, ChronoUnit.SECONDS)));
		assertTrue("start time too early", endTime.isAfter(now.minus(5, ChronoUnit.SECONDS)));
	}

}
