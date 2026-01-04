package br.com.dio.exception;

public class UserNotFoudException extends RuntimeException {
    public UserNotFoudException(final String message) {
        super(message);
    }
}
