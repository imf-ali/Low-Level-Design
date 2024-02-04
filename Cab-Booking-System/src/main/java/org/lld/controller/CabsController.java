package org.lld.controller;

import lombok.AllArgsConstructor;
import org.lld.database.CabManager;
import org.lld.database.TripManager;
import org.lld.entity.Cab;
import org.lld.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
  @Autowired
  private CabManager cabsManager;
  @Autowired
  private TripManager tripManager;

  @PostMapping(value = "/register/cab", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> registerCab(final String cabId, final String driverName) {
    cabsManager.createCab(new Cab(cabId, driverName));
    return ResponseEntity.ok("Cab registered successfully");
  }

  @PostMapping(value = "/update/cab/location", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> updateCabLocation(final String cabId, Location location) {
    cabsManager.updateCabLocation(cabId, location);
    return ResponseEntity.ok("Location updated");
  }

  @PostMapping(value = "/update/cab/availability", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> updateCabAvailability(final String cabId, final Boolean newAvailability) {
    cabsManager.updateCabAvailability(cabId, newAvailability);
    return ResponseEntity.ok("Availability updated");
  }

  @PostMapping(value = "/update/cab/end/trip", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> endTrip(final String cabId) {
    tripManager.endTrip(cabsManager.getCab(cabId));
    return ResponseEntity.ok("Trip ended successfully");
  }
}
