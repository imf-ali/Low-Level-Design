package org.lld.exception;

import org.springframework.http.HttpStatus;

public class AppException extends Throwable {
  AppErrorCodes code;
  private String[] args;

  public AppException(AppErrorCodes errorCodes) {
    super(errorCodes.getMessage());
    this.code = errorCodes;
  }

  public AppException(AppErrorCodes errorCodes, String... args) {
    super(errorCodes.getMessage());
    this.code = errorCodes;
    this.args = args;
  }

  public HttpStatus getHttpStatus() {
    return code.getHttpStatus();
  }
}
