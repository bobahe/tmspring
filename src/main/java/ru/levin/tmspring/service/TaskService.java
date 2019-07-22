package ru.levin.tmspring.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.IdNullOrEmptyException;
import ru.levin.tmspring.exception.NullDeleteException;
import ru.levin.tmspring.exception.NullOrEmptyNameException;
import ru.levin.tmspring.exception.NullSaveException;
import ru.levin.tmspring.repository.ProjectRepository;
import ru.levin.tmspring.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;
    @Autowired
    public void setTaskRepository(@NotNull final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void create(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    public void update(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    public void delete(final @Nullable Task entity) {
        if (entity == null) throw new NullDeleteException();
        taskRepository.delete(entity);
    }

    @Override
    public @NotNull List<Task> findAll() {
        return taskRepository.getAll();
    }

    @Nullable
    @Override
    public Task getById(final @Nullable String id) {
        if (id == null || id.isEmpty()) throw new IdNullOrEmptyException();
        return taskRepository.findById(id);
    }

}
