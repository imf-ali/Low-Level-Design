package org.lld.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
  private final String id;
  private final String driverName;
  @Setter private Trip currentTrip;
  @Setter private Location currentLocation;
  @Setter private Boolean availability;

  public Cab(String id, String driverName){
    this.id = id;
    this.driverName = driverName;
  }

  @Override
  public String toString() {
    return "Cab{" +
        "id='" + id + '\'' +
        ", driverName='" + driverName + '\'' +
        ", currentLocation=" + currentLocation +
        ", isAvailable=" + availability +
        '}';
  }
}
