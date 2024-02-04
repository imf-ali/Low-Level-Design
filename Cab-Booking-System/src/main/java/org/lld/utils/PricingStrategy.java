package org.lld.utils;

import org.lld.entity.Location;

public interface PricingStrategy {
  Double findPrice(Location fromLocation, Location toLocation);
}
