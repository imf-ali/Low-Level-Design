package org.lld.database;

import lombok.NonNull;
import org.lld.entity.Rider;
import org.lld.exception.AppException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RiderManager {
  Map<String, Rider> riders = new HashMap<>();

  public void createRider(@NonNull final Rider rider){
    if(riders.containsKey(rider.getId())){
      throw new AppException("Rider already present");
    }
    riders.put(rider.getId(), rider);
  }
  public Rider getRider(@NonNull final String riderId) {
    if (!riders.containsKey(riderId)) {
      throw new AppException("Rider Not found");
    }
    return riders.get(riderId);
  }
}
