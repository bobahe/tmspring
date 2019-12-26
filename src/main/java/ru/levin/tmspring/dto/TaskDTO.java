package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.Status;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO extends AbstractEntityDTO {

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
    private String projectId;

}
