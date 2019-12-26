package ru.levin.tmspring.exception;

public class NullDeleteException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Невозможно удалить null.";
    }

}
