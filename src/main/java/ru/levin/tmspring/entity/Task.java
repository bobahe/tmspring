package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

@Getter
@Setter
public class Task extends AbstractEntity {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private LocalDate startDate;

    @Nullable
    private LocalDate endDate;

    @NotNull
    private Status status = Status.PLANNED;

    @Nullable
    private Project project;

}
