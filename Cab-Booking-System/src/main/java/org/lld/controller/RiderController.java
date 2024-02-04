package org.lld.controller;


import lombok.AllArgsConstructor;
import org.lld.database.RiderManager;
import org.lld.database.TripManager;
import org.lld.entity.Location;
import org.lld.entity.Rider;
import org.lld.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiderController {
  @Autowired
  private RiderManager riderManager;
  @Autowired
  private TripManager tripManager;

  @PostMapping(value = "/register/rider", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> registerRider(String riderId, String riderName){
    riderManager.createRider(new Rider(riderId, riderName));
    return ResponseEntity.ok("Rider registered successfully");
  }

  @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> book(String riderId, Location from, Location to){
    tripManager.createTrip(riderManager.getRider(riderId), from, to);
    return ResponseEntity.ok("Rider booked");
  }

  @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Trip>> getHistory(String riderId){
    return ResponseEntity.ok(tripManager.tripHistory(riderManager.getRider(riderId)));
  }
}
