package com.ecomeerce.rest_api.exception;

public class InvalidJsonFormatException extends RuntimeException {
  public InvalidJsonFormatException(String message) {
    super(message);
  }
}
