package org.lld.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AppErrorCodes {
  URL_ALREADY_PRESENT("Url is already present", HttpStatus.BAD_REQUEST),
  URL_NOT_FOUND("Its not a valid url", HttpStatus.NOT_FOUND),
  URL_HAS_EXPIRED("Url is expired", HttpStatus.BAD_REQUEST);

  private final String message;
  private final HttpStatus httpStatus;
}
