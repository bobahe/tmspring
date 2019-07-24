package ru.levin.tmspring.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IRepository<E> {

    void delete(@NotNull final E entity);

    @NotNull List<E> findAll();

    @Nullable E findById(@NotNull final String id);

    void save(@NotNull final E entity);

    void update(@NotNull final E entity);

}