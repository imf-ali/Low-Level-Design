package org.lld.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException {
  private String message;
}
