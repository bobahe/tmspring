package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.api.repository.ITaskEntityRepository;
import ru.levin.tmspring.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public final class TaskEntityRepository implements ITaskEntityRepository {

    @NotNull
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(final @NotNull Task entity) {
        @Nullable final Task task = entityManager.find(Task.class, entity.getId());
        if (task == null) return;
        entityManager.remove(task);
    }

    @Override
    public @NotNull List<Task> findAll() {
        return entityManager.createQuery("select p from Task p", Task.class).getResultList();
    }

    @Nullable
    @Override
    public Task findById(final @NotNull String id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void save(final @NotNull Task entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final @NotNull Task entity) {
        entityManager.merge(entity);
    }
}