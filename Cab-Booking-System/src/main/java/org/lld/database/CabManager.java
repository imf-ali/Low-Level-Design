package org.lld.database;

import lombok.NonNull;
import org.lld.entity.Cab;
import org.lld.entity.Location;
import org.lld.exception.AppException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabManager {
  Map<String, Cab> cabs = new HashMap<>();

  public void createCab(@NonNull final Cab newCab) {
    if (cabs.containsKey(newCab.getId())) {
      throw new AppException("Cab already present");
    }

    cabs.put(newCab.getId(), newCab);
  }

  public Cab getCab(@NonNull final String cabId) {
    if (!cabs.containsKey(cabId)) {
      throw new AppException("Cab does not exist");
    }
    return cabs.get(cabId);
  }

  public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
    if (!cabs.containsKey(cabId)) {
      throw new AppException("Cab does not exist");
    }
    cabs.get(cabId).setCurrentLocation(newLocation);
  }

  public void updateCabAvailability(
      @NonNull final String cabId, @NonNull final Boolean newAvailability) {
    if (!cabs.containsKey(cabId)) {
      throw new AppException("Cab does not exist");
    }
    cabs.get(cabId).setAvailability(newAvailability);
  }

  public List<Cab> getCabs(Location from, Double distance){
    List<Cab> res = new ArrayList<>();
    for(Cab cab: cabs.values()){
      if(cab.getAvailability() && cab.getCurrentTrip() == null && cab.getCurrentLocation().distance(from) <= distance){
        res.add(cab);
      }
    }
    return res;
  }
}
