package org.lld.entity;

import org.lld.entity.enums.ParkingSlotType;
import org.lld.entity.enums.VehicleType;

import java.util.List;
import java.util.Map;

public class ParkingFloors {
  private int floorNumber;
  Map<ParkingSlotType, List<ParkingSlot>> parkingSlots;
  public ParkingFloors(int floorNumber, Map<ParkingSlotType, List<ParkingSlot>> parkingSlots) {
    this.floorNumber = floorNumber;
    this.parkingSlots = parkingSlots;
  }

  private ParkingSlotType getRelevantSlotType(Vehicle vehicle) {
    if(vehicle.getVehicleType().equals(VehicleType.BIKE))
      return ParkingSlotType.TWO_WHEELER;
    else if(vehicle.getVehicleType().equals(VehicleType.ALTO))
      return ParkingSlotType.COMPACT;
    else if(vehicle.getVehicleType().equals(VehicleType.SEDAN))
      return ParkingSlotType.MEDIUM;
    else if(vehicle.getVehicleType().equals(VehicleType.SUV))
      return ParkingSlotType.LARGE;
    return null;
  }

  public ParkingSlot getParkingSlotSpace(Vehicle vehicle) {
    ParkingSlotType parkingSlotType = getRelevantSlotType(vehicle);
    if(parkingSlotType == null)
      return null;
    List<ParkingSlot> parkingSlotList = parkingSlots.get(parkingSlotType);
    for(ParkingSlot parkingSlot : parkingSlotList){
      if(parkingSlot.isAvailable()){
        parkingSlot.setAvailable(false);
        return parkingSlot;
      }
    }
    return null;
  }
}
