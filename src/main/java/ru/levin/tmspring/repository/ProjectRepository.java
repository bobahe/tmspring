package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levin.tmspring.api.repository.IProjectRepository;
import ru.levin.tmspring.entity.Project;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository {

    @Override
    public void delete(final @NotNull Project entity) {
        this.storage.remove(entity.getId(), entity);
    }

    @Override
    public void deleteById(final @NotNull String id) {
        this.storage.remove(id);
    }

    @Nullable
    @Override
    public Project findById(final @NotNull String id) {
        return this.storage.getOrDefault(id, null);
    }

    @Override
    public @NotNull List<Project> getAll() {
        return new ArrayList<>(this.storage.values());
    }

    @Override
    public void save(final @NotNull Project entity) {
        this.storage.put(entity.getId(), entity);
    }

}
