package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.api.repository.ITaskRepository;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public final class TaskRepository implements ITaskRepository {

    @NotNull
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(final @NotNull TaskDTO entity) {
        @Nullable final Task task = entityManager.find(Task.class, entity.getId());
        if (task == null) return;
        entityManager.remove(task);
    }

    @Override
    public @NotNull List<TaskDTO> findAll() {
        return entityManager.createQuery("from TaskDTO", TaskDTO.class).getResultList();
    }

    @Nullable
    @Override
    public TaskDTO findById(final @NotNull String id) {
        return entityManager.find(TaskDTO.class, id);
    }

    @Override
    public void save(final @NotNull TaskDTO entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final @NotNull TaskDTO entity) {
        entityManager.merge(entity);
    }

}