package com.titanpay.accounting.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Test;

import com.titanpay.accounting.*;


public class HourlyEmployeeTest {

	@Test
	public void testGetFullName() {
		
		// Arrange //
		String firstName = "Adam";
		String lastName = "Burford";
		String fullName = lastName + ", " + firstName;
		HourlyEmployee testEmployee = new HourlyEmployee(4244590, "Adam", "Burford", 0.0, 50.0);
		
		// Act //
		String fullNameTest = testEmployee.getFullName();
		
		// Assert //
		assertEquals("Full name is incorrect", fullNameTest, fullName);
	}

	@Test
	public void testPay() {
		// Arrange //
		String firstName = "Adam";
		String lastName = "Burford";
		String fullName = lastName + ", " + firstName;
		Address testAddress = new Address("6605 5TH AVE N", "SAINT PETERSBURG", "FL", 33710);
		
		LocalDate startDate = LocalDate.parse("2016-06-20");
    	LocalDate endDate = LocalDate.parse("2016-06-26");
    	TimeCard testTimeCard = new TimeCard(startDate, startDate.atStartOfDay(), startDate.atStartOfDay().plus(8, ChronoUnit.HOURS));
    	
    	PaymentMethod pickUpPaymentTest = new PickUpPayment(fullName);
    	PaymentMethod directDepositTest = new DirectDepositPayment(fullName, "TestBank", 1, 1);
    	PaymentMethod mailPaymentTest = new MailPayment(fullName, testAddress);
    	
    	assertNotNull("Null Pointer pickuppayment", pickUpPaymentTest);
    	assertNotNull("Null Pointer direct deposit", directDepositTest);
    	assertNotNull("Null Pointer mail payment", mailPaymentTest);
    	
		HourlyEmployee testEmployee1 = new HourlyEmployee(4244590, "Test", "1", 0.0, 50.0, pickUpPaymentTest);
		HourlyEmployee testEmployee2 = new HourlyEmployee(4244590, "Test", "2", 0.0, 50.0, directDepositTest);
		HourlyEmployee testEmployee3 = new HourlyEmployee(4244590, "Test", "3", 0.0, 50.0, mailPaymentTest);
		
		assertNotNull("Null Pointer 1", testEmployee1);
    	assertNotNull("Null Pointer 2", testEmployee2);
    	assertNotNull("Null Pointer 3", testEmployee3);
		
		testEmployee1.addTimeCard(testTimeCard);
		testEmployee2.addTimeCard(testTimeCard);
		testEmployee3.addTimeCard(testTimeCard);
		
		// Act //
		String payResult1 = testEmployee1.pay(startDate, endDate);
		String payResult2 = testEmployee2.pay(startDate, endDate);
		String payResult3 = testEmployee3.pay(startDate, endDate);

		// Assert //
		
		String expectedResult1 = "A check for $400.00 is waiting for Burford, Adam at the PostMaster.";
		String expectedResult2 = "Depositing $400.00 in TestBank Account Number: 1 using Routing Number: 1";
		String expectedResult3 = "Mailing a check to Burford, Adam for $400.00 to 6605 5TH AVE N SAINT PETERSBURG, FL 33710";
		
		assertEquals("pay 1 incorrect", payResult1, expectedResult1);
		assertEquals("pay 2 incorrect", payResult2, expectedResult2);
		assertEquals("pay 3 incorrect", payResult3, expectedResult3);
	}

	@Test
	public void testClockIn() {
		// Arrange //
		int employeeId = 4244590;
		String firstName = "Adam";
		String lastName = "Burford";
		double weeklyDues = 0.0;
		double hourlyRate = 50.0;
		HourlyEmployee testEmployee = new HourlyEmployee(employeeId, firstName, lastName, weeklyDues, hourlyRate);
		
		// Act //
		testEmployee.clockIn();
		
		List<TimeCard> timeCardListTest = testEmployee.getTimeCards();
		
		assertEquals("list size wrong", timeCardListTest.size(), 1);
		LocalDateTime now = LocalDateTime.now().plus(1, ChronoUnit.SECONDS);
		LocalDateTime startTime = timeCardListTest.get(0).getStartTime();
		
		boolean test = (startTime.isBefore(now)) && (startTime.isAfter(now.minus(10, ChronoUnit.SECONDS)));
		assertTrue("start time wrong, but this test real bad it may fail if computer real slow", test);
	}

	@Test
	public void testClockOut() {
		// Arrange //
		int employeeId = 4244590;
		String firstName = "Adam";
		String lastName = "Burford";
		double weeklyDues = 0.0;
		double hourlyRate = 50.0;
		HourlyEmployee testEmployee = new HourlyEmployee(employeeId, firstName, lastName, weeklyDues, hourlyRate);
		
		// Act //
		testEmployee.clockIn();
		testEmployee.clockOut();
		
		List<TimeCard> timeCardListTest = testEmployee.getTimeCards();
		
		assertEquals("list size wrong", timeCardListTest.size(), 1);
		
		LocalDateTime now = LocalDateTime.now().plus(5,ChronoUnit.SECONDS);
		LocalDateTime endTime = timeCardListTest.get(0).getEndTime();
		boolean test = (endTime.isBefore(now)) && (endTime.isAfter(now.minus(10, ChronoUnit.SECONDS)));
		
		assertTrue("end time wrong, but this test real bad it may fail if computer real slow", test);
	}

	@Test
	public void testAddTimeCard() {
		int employeeId = 4244590;
		String firstName = "Adam";
		String lastName = "Burford";
		double weeklyDues = 0.0;
		double hourlyRate = 50.0;
		HourlyEmployee testEmployee = new HourlyEmployee(employeeId, firstName, lastName, weeklyDues, hourlyRate);
		LocalDate date = LocalDate.now();
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = startTime.plus(8, ChronoUnit.HOURS);
		TimeCard testTimeCard = new TimeCard(date, startTime, endTime);
		
		// Act //
		testEmployee.addTimeCard(testTimeCard);
		
		List<TimeCard> timeCardListTest = testEmployee.getTimeCards();
		
		assertEquals("list size wrong", timeCardListTest.size(), 1);
		assertSame("start date wrong", timeCardListTest.get(0), testTimeCard);
	}
	
	@Test
	public void testGetTimeCards() {
		int employeeId = 4244590;
		String firstName = "Adam";
		String lastName = "Burford";
		double weeklyDues = 0.0;
		double hourlyRate = 50.0;
		HourlyEmployee testEmployee = new HourlyEmployee(employeeId, firstName, lastName, weeklyDues, hourlyRate);
		LocalDate date = LocalDate.now();
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = startTime.plus(8, ChronoUnit.HOURS);
		TimeCard testTimeCard1 = new TimeCard(date, startTime, endTime);
		TimeCard testTimeCard2 = new TimeCard(date.minus(1, ChronoUnit.DAYS), startTime.minus(1, ChronoUnit.DAYS), endTime.minus(1, ChronoUnit.DAYS));
		TimeCard testTimeCard3 = new TimeCard(date.minus(2, ChronoUnit.DAYS), startTime.minus(2, ChronoUnit.DAYS), endTime.minus(2, ChronoUnit.DAYS));
		
		// Act //
		testEmployee.addTimeCard(testTimeCard1);
		testEmployee.addTimeCard(testTimeCard2);
		testEmployee.addTimeCard(testTimeCard3);
		
		List<TimeCard> timeCardListTest = testEmployee.getTimeCards();
		
		assertEquals("list size wrong", timeCardListTest.size(), 3);
		assertSame("time card 3 wrong", timeCardListTest.get(0), testTimeCard3);
		assertSame("time card 2 wrong", timeCardListTest.get(1), testTimeCard2);
		assertSame("time card 1 wrong", timeCardListTest.get(2), testTimeCard1);
	}

}
