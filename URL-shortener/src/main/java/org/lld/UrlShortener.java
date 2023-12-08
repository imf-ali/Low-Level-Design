package org.lld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShortener {
  public static void main(String[] args) {
    System.out.println("Application is up");
    SpringApplication.run(UrlShortener.class);
  }
}