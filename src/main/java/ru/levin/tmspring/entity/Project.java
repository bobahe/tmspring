package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Project extends AbstractEntity {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private LocalDateTime startDate;

    @Nullable
    private LocalDateTime endDate;

    @NotNull
    private Status status = Status.PLANNED;

}
