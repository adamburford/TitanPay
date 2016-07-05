package com.titanpay.accounting.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.titanpay.accounting.*;

public class SalariedEmployeeTest {

	@Test
	public void testGetFullName() {
		
		// Arrange //
		String firstName = "Adam";
		String lastName = "Burford";
		String fullName = lastName + ", " + firstName;
		SalariedEmployee testEmployee = new SalariedEmployee(4244590, "Adam", "Burford", 0.0, 100000.00, 0.10);
		
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
    	Receipt testReceipt = new Receipt(startDate, 1000.00);
    	
    	PaymentMethod pickUpPaymentTest = new PickUpPayment(fullName);
    	PaymentMethod directDepositTest = new DirectDepositPayment(fullName, "TestBank", 1, 1);
    	PaymentMethod mailPaymentTest = new MailPayment(fullName, testAddress);
    	
    	assertNotNull("Null Pointer pickuppayment", pickUpPaymentTest);
    	assertNotNull("Null Pointer direct deposit", directDepositTest);
    	assertNotNull("Null Pointer mail payment", mailPaymentTest);
    	
		SalariedEmployee testEmployee1 = new SalariedEmployee(4244590, "Test", "1", 0.0, 100000.00, 0.10, pickUpPaymentTest);
		SalariedEmployee testEmployee2 = new SalariedEmployee(4244590, "Test", "2", 0.0, 100000.00, 0.10, directDepositTest);
		SalariedEmployee testEmployee3 = new SalariedEmployee(4244590, "Test", "3", 0.0, 100000.00, 0.10, mailPaymentTest);
		
		assertNotNull("Null Pointer 1", testEmployee1);
    	assertNotNull("Null Pointer 2", testEmployee2);
    	assertNotNull("Null Pointer 3", testEmployee3);
		
		testEmployee1.addReceipt(testReceipt);
		testEmployee2.addReceipt(testReceipt);
		testEmployee3.addReceipt(testReceipt);
		
		// Act //
		String payResult1 = testEmployee1.pay(startDate, endDate);
		String payResult2 = testEmployee2.pay(startDate, endDate);
		String payResult3 = testEmployee3.pay(startDate, endDate);
		
		// Assert //
		
		String expectedResult1 = "A check for $100100.00 is waiting for Burford, Adam at the PostMaster.";
		String expectedResult2 = "Depositing $100100.00 in TestBank Account Number: 1 using Routing Number: 1";
		String expectedResult3 = "Mailing a check to Burford, Adam for $100100.00 to 6605 5TH AVE N SAINT PETERSBURG, FL 33710";
		
		assertEquals("pay 1 incorrect", payResult1, expectedResult1);
		assertEquals("pay 2 incorrect", payResult2, expectedResult2);
		assertEquals("pay 3 incorrect", payResult3, expectedResult3);
	}

	@Test
	public void testMakeSaleDouble() {
		String firstName = "Adam";
		String lastName = "Burford";
		
		double testAmount = 1.0;
		
		SalariedEmployee testEmployee = new SalariedEmployee(4244590, firstName, lastName, 0.0, 100000.00, 0.10);
		
		testEmployee.makeSale(testAmount);
		
		List<Receipt> receiptList = testEmployee.getReceipts();

		assertEquals("list size wrong", receiptList.size(), 1);
		
		assertEquals("amount wrong" , (Double)receiptList.get(0).getSaleAmt(),  (Double)testAmount);
		assertEquals("date wrong" , receiptList.get(0).getDate(), LocalDate.now());
	}

	@Test
	public void testMakeSaleLocalDateDouble() {
		String firstName = "Adam";
		String lastName = "Burford";
		
		double testAmount = 1.0;
		
		SalariedEmployee testEmployee = new SalariedEmployee(4244590, firstName, lastName, 0.0, 100000.00, 0.10);
		
		testEmployee.makeSale(LocalDate.now(), testAmount);
		
		List<Receipt> receiptList = testEmployee.getReceipts();

		assertEquals("list size wrong", receiptList.size(), 1);
		
		assertEquals("amount wrong" , (Double)receiptList.get(0).getSaleAmt(),  (Double)testAmount);
		assertEquals("date wrong" , receiptList.get(0).getDate(), LocalDate.now());
	}

	@Test
	public void testAddReceipt() {
		String firstName = "Adam";
		String lastName = "Burford";
		
		double testAmount = 1.0;
		
		SalariedEmployee testEmployee = new SalariedEmployee(4244590, firstName, lastName, 0.0, 100000.00, 0.10);
		
		Receipt testReceipt = new Receipt(LocalDate.now(), testAmount);
		
		testEmployee.addReceipt(testReceipt);
		
		List<Receipt> receiptList = testEmployee.getReceipts();

		assertEquals("list size wrong", receiptList.size(), 1);
		
		assertEquals("amount wrong" , (Double)receiptList.get(0).getSaleAmt(),  (Double)testAmount);
		assertEquals("date wrong" , receiptList.get(0).getDate(), LocalDate.now());
	}

}
