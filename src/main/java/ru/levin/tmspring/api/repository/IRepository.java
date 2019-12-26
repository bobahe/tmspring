package ru.levin.tmspring.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.entity.AbstractEntity;

import java.util.List;

public interface IRepository<T extends AbstractEntity> {

    void delete(@NotNull final T entity);

    void deleteById(@NotNull final String id);

    @Nullable
    T findById(@NotNull final String id);

    @NotNull
    List<T> getAll();

    void save(@NotNull final T entity);

}
