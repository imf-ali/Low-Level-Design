package org.lld.utils;

import org.lld.entity.Location;
import org.springframework.stereotype.Service;

@Service
public class DefaultPricingStrategy implements PricingStrategy{
  public static final Double PER_KM_RATE = 10.0;
  @Override
  public Double findPrice(Location fromLocation, Location toLocation) {
    return fromLocation.distance(toLocation) * PER_KM_RATE;
  }
}
