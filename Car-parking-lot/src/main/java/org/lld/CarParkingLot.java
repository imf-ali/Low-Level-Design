package org.lld;

import org.lld.entity.*;
import org.lld.entity.enums.ParkingSlotType;
import org.lld.entity.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarParkingLot {
  public static void main(String[] args) {
    // new Parking Lot
    Address address = new Address("Patna", 823001, 20, 20);
    // initializing objects
    List<ParkingFloors> parkingFloors = new ArrayList<>();
    Map<ParkingSlotType, List<ParkingSlot>> parkingSlots = new HashMap<>();
    List<ParkingSlot> parkingSlotList1 = new ArrayList<>();
    List<ParkingSlot> parkingSlotList2 = new ArrayList<>();
    List<ParkingSlot> parkingSlotList3 = new ArrayList<>();
    List<ParkingSlot> parkingSlotList4 = new ArrayList<>();
    // assigning objects
    parkingSlotList1.add(new ParkingSlot("T1"));
    parkingSlotList1.add(new ParkingSlot("T2"));
    parkingSlotList1.add(new ParkingSlot("T3"));
    parkingSlots.put(ParkingSlotType.TWO_WHEELER, parkingSlotList1);

    parkingSlotList2.add(new ParkingSlot("C1"));
    parkingSlotList2.add(new ParkingSlot("C2"));
    parkingSlots.put(ParkingSlotType.COMPACT, parkingSlotList2);

    parkingSlotList3.add(new ParkingSlot("M1"));
    parkingSlots.put(ParkingSlotType.MEDIUM, parkingSlotList3);

    parkingSlotList4.add(new ParkingSlot("L1"));
    parkingSlots.put(ParkingSlotType.MEDIUM, parkingSlotList4);

    ParkingFloors parkingFloors1 = new ParkingFloors(1, parkingSlots);
    parkingFloors.add(parkingFloors1);
    // construct parking lot
    ParkingLot parkingLot = new ParkingLot("New Parking station", address, parkingFloors);

    // vehicles coming
    Vehicle vehicle1 = new Vehicle("BR-2015-8521", VehicleType.ALTO);
  }
}