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
	
	// Constructor
	public Address(String streetAddress, String city, String state, int zip) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
