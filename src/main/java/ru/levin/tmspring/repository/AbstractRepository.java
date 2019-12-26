package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import ru.levin.tmspring.api.repository.IRepository;
import ru.levin.tmspring.entity.AbstractEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    @NotNull
    protected final Map<String, T> storage = new LinkedHashMap<>();

}
