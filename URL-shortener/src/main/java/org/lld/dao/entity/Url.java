package org.lld.dao.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class Url {
  @Id
  private String id;
  private String longUrl;
  private String shortUrl;
  private Date expiryDate;

  public Url(String longUrl, String shortUrl, Date expiryDate){
    this.longUrl = longUrl;
    this.shortUrl = shortUrl;
    this.expiryDate = expiryDate;
  }

  public boolean hasExpired() {
    if(expiryDate == null)
      return false;
    return expiryDate.compareTo(new Date()) > 0;
  }
}
