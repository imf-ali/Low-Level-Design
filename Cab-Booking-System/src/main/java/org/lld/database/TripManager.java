package org.lld.database;

import org.lld.entity.Cab;
import org.lld.entity.Location;
import org.lld.entity.Rider;
import org.lld.entity.Trip;
import org.lld.exception.AppException;
import org.lld.utils.CabMatchingStrategy;
import org.lld.utils.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripManager {
  public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
  private Map<String, List<Trip>> trips = new HashMap<>();
  @Autowired
  private RiderManager riderManager;
  @Autowired
  private CabManager cabManager;
  @Autowired
  private CabMatchingStrategy cabMatchingStrategy;
  @Autowired
  private PricingStrategy pricingStrategy;

  public TripManager(RiderManager riderManager, CabManager cabManager, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
    this.riderManager = riderManager;
    this.cabManager = cabManager;
    this.cabMatchingStrategy = cabMatchingStrategy;
    this.pricingStrategy = pricingStrategy;
  }

  public void createTrip(Rider rider, Location from, Location to){
    List<Cab> closeByCabs = cabManager.getCabs(from, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
    Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, closeByCabs, from, to);
    if(selectedCab == null){
      throw new AppException("No nearby cabs found");
    }
    Double tripPrice = pricingStrategy.findPrice(from, to);
    Trip newTrip = new Trip(rider, selectedCab, tripPrice, from, to);
    if(!trips.containsKey(rider.getId())){
      trips.put(rider.getId(), new ArrayList<>());
    }
    trips.get(rider.getId()).add(newTrip);
    selectedCab.setCurrentTrip(newTrip);
  }

  public List<Trip> tripHistory(final Rider rider) {
    return trips.get(rider.getId());
  }
  public void endTrip(Cab cab){
    if(cab.getCurrentTrip() == null){
      throw new AppException("There is no current trip");
    }
    cab.getCurrentTrip().endTrip();
    cab.setCurrentTrip(null);
  }
}
