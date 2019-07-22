package ru.levin.tmspring.exception;

public class NullSaveException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Невозможно сохранить null.";
    }

}
