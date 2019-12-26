package ru.levin.tmspring.api.service;

import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Task;

public interface ITaskService extends IEntityService<Task> {

    void create(final @Nullable TaskDTO entity);

    void update(final @Nullable TaskDTO entity);

}
