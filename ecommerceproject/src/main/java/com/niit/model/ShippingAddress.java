package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ShippingAddress_S191174100121")
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int shippingAddressId;
private String apartmentnumber,streetname,city,state,country,zipcode;
public int getShippingAddressId() {
	return shippingAddressId;
}
public void setShippingAddressId(int shippingAddressId) {
	this.shippingAddressId = shippingAddressId;
}
public String getApartmentnumber() {
	return apartmentnumber;
}
public void setApartmentnumber(String apartmentnumber) {
	this.apartmentnumber = apartmentnumber;
}
public String getStreetname() {
	return streetname;
}
public void setStreetname(String streetname) {
	this.streetname = streetname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

}

