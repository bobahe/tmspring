package ru.levin.tmspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {

    @NotNull
    protected String id = UUID.randomUUID().toString();

}
