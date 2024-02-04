package org.lld.utils;

import org.lld.entity.Cab;
import org.lld.entity.Location;
import org.lld.entity.Rider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCabMatchingStrategy implements CabMatchingStrategy{
  @Override
  public Cab matchCabToRider(Rider rider, List<Cab> cabList, Location fromLocation, Location toLocation) {
    if(cabList.isEmpty()){
      return null;
    }
    return cabList.get(0);
  }
}
