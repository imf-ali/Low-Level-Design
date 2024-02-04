package org.lld.utils;

import org.lld.entity.Cab;
import org.lld.entity.Location;
import org.lld.entity.Rider;

import java.util.List;

public interface CabMatchingStrategy {
  Cab matchCabToRider(Rider rider, List<Cab> cabList, Location fromLocation, Location toLocation);
}
