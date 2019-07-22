package ru.levin.tmspring.exception;

public class NoSuchProjectException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Пороекта с таким Id не существует.";
    }

}
