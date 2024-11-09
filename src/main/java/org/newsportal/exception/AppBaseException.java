package org.newsportal.exception;

//Базовое исключение, для всех дальнейших кастомных исключений
public class AppBaseException extends RuntimeException {
    public AppBaseException(String message) {
        super(message);
    }

    public AppBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}