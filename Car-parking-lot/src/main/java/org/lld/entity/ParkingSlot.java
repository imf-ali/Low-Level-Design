package org.lld.entity;

import org.lld.entity.enums.ParkingSlotType;

public class ParkingSlot {
  private String name;
  private boolean available;

  public ParkingSlot(String name) {
    this.name = name;
    this.available = true;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }
}
