package com.example.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
Integer houseno;
String streetname;
String city;
public Address() {}

public Address(Integer houseno, String streetname, String city) {
	super();
	this.houseno = houseno;
	this.streetname = streetname;
	this.city = city;
}
public Integer getHouseno() {
	return houseno;
}
public void setHouseno(Integer houseno) {
	this.houseno = houseno;
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
@Override
public String toString() {
	return "Address [houseno=" + houseno + ", streetname=" + streetname + ", city=" + city + "]";
}

}
