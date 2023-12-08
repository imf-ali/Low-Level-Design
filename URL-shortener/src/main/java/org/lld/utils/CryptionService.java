package org.lld.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptionService {
  public static String hashString(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      byte[] hashedBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

      StringBuilder hexStringBuilder = new StringBuilder();
      for (byte b : hashedBytes) {
        hexStringBuilder.append(String.format("%02x", b));
      }
      return hexStringBuilder.substring(0,6);
    } catch (NoSuchAlgorithmException e) {
      e.getMessage();
      return null;
    }
  }
}
