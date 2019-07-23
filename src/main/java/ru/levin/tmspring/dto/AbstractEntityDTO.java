package ru.levin.tmspring.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntityDTO {

    @NotNull
    protected String id = UUID.randomUUID().toString();

}
