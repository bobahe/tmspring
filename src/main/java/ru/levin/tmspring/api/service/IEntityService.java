package ru.levin.tmspring.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.AbstractEntity;

import java.util.List;

public interface IEntityService<T extends AbstractEntity> {

    void create(@Nullable final T entity);

    void delete(@Nullable final T entity);

    @NotNull
    List<T> findAll();

    @Nullable
    T getById(@Nullable final String id);

    void update(@Nullable final T entity);

}
