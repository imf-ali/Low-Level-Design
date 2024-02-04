package org.lld.entity.enums;

public enum ParkingSlotType {
  TWO_WHEELER(10),
  COMPACT(15),
  MEDIUM(20),
  LARGE(30);
  private final int ratePerHour;
  ParkingSlotType(int ratePerHour) {
    this.ratePerHour = ratePerHour;
  }
}
