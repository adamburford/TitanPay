/* 	Adam Burford SPCID#2128028
 * 	COP2251 -  Java Programming II
 */

package com.titanpay.accounting;

public class Address implements java.io.Serializable {
	// Constructor
	public Address(String streetAddress, String city, String state, int zip) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	// Fields
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	private static final long serialVersionUID = 1337L;
	
	// Getters
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZip() {
		return zip;
	}
	
	// Setters
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	// Methods
	public String getAddress() {
		return streetAddress + ' ' + city + ", " + state + ' ' + zip;
	}
	
	public String toString() {
		return streetAddress + ' ' + city + ", " + state + ' ' + zip;
	}
}
