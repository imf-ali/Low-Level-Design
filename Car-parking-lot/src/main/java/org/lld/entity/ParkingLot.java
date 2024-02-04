package org.lld.entity;

import java.util.List;

public class ParkingLot {
  String name;
  Address address;
  List<ParkingFloors> parkingFloorsList;
  public ParkingLot(String name, Address address, List<ParkingFloors> parkingFloorsList) {
    this.name = name;
    this.address = address;
    this.parkingFloorsList = parkingFloorsList;
  }

  public Ticket createTicket(Vehicle vehicle){
    for(ParkingFloors parkingFloors : parkingFloorsList){
      ParkingSlot parkingSlot = parkingFloors.getParkingSlotSpace(vehicle);
    }
    return new Ticket();
  }
}
