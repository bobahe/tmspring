package ru.levin.tmspring.exception;

public class IdNullOrEmptyException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Id не может быть null.";
    }

}
