package ru.levin.tmspring.exception;

public class NullOrEmptyNameException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Невозможно сохранить сущность без имени.";
    }

}
