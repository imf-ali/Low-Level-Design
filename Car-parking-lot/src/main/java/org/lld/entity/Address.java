package org.lld.entity;

public class Address {
  private String address;
  private int pinCode;
  private double lat;
  private double lon;
  public Address(String address, int pinCode, double lat, double lon) {
    this.address = address;
    this.pinCode = pinCode;
    this.lat = lat;
    this.lon = lon;
  }
}
