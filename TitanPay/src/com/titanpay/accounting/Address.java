/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class Address {
	
	// Fields
	
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	
	// Methods
	public String getAddress() {
		return streetAddress + ' ' + city + ", " + state + ' ' + zip;
	}
}
