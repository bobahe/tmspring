package ru.levin.tmspring.entity;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum Status {

    PLANNED ("Запланировано"),
    IN_PROCESS ("Выполняется"),
    READY ("Выполнено");

    @NotNull
    private final String displayName;

    Status(@NotNull final String displayName) {
        this.displayName = displayName;
    }

}
