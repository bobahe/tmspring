package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levin.tmspring.api.repository.ITaskRepository;
import ru.levin.tmspring.entity.Task;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class TaskRepository extends AbstractRepository<Task> implements ITaskRepository {

    @Override
    public void save(final @NotNull Task entity) {
        this.storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(final @NotNull Task entity) {
        this.storage.remove(entity.getId(), entity);
    }

    @Override
    public void deleteById(final @NotNull String id) {
        this.storage.remove(id);
    }

    @Nullable
    @Override
    public Task findById(final @NotNull String id) {
        return this.storage.getOrDefault(id, null);
    }

    @Override
    public @NotNull List<Task> getAll() {
        return new ArrayList<>(this.storage.values());
    }

}
