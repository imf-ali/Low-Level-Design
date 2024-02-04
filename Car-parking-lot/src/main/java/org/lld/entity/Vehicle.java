package org.lld.entity;

import org.lld.entity.enums.VehicleType;

public class Vehicle {
  private String vehicleNumber;
  private VehicleType vehicleType;

  public Vehicle(String vehicleNumber, VehicleType vehicleType) {
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = vehicleType;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }
}
