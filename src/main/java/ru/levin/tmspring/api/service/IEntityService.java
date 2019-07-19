package ru.levin.tmspring.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.AbstractEntity;

import java.util.List;

public interface IEntityService<T extends AbstractEntity> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    @NotNull
    List<T> findAll();

    @NotNull
    T getById(@Nullable final String id);

}
