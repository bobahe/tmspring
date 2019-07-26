package ru.levin.tmspring.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levin.tmspring.api.repository.ITaskEntityRepository;
import ru.levin.tmspring.api.repository.ITaskRepository;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.IdNullOrEmptyException;
import ru.levin.tmspring.exception.NullDeleteException;
import ru.levin.tmspring.exception.NullOrEmptyNameException;
import ru.levin.tmspring.exception.NullSaveException;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private ITaskEntityRepository taskEntityRepository;

    private ITaskRepository taskRepository;

    @Override
    @Transactional
    public void create(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskEntityRepository.save(entity);
    }

    @Override
    @Transactional
    public void create(final @Nullable TaskDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(final @Nullable Task entity) {
        if (entity == null) throw new NullDeleteException();
        taskEntityRepository.delete(entity);
    }

    @Override
    public @NotNull List<Task> findAll() {
        return taskEntityRepository.findAll();
    }

    @Nullable
    @Override
    public Task getById(final @Nullable String id) {
        if (id == null || id.isEmpty()) throw new IdNullOrEmptyException();
        return taskEntityRepository.findById(id).orElse(null);
    }

    @Nullable
    @Override
    public TaskDTO getDtoById(final @Nullable String id) {
        if (id == null || id.isEmpty()) throw new IdNullOrEmptyException();
        return taskRepository.findById(id).orElse(null);
    }

    @Autowired
    public void setTaskEntityRepository(final ITaskEntityRepository taskEntityRepository) {
        this.taskEntityRepository = taskEntityRepository;
    }

    @Autowired
    public void setTaskRepository(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public void update(final @Nullable TaskDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskEntityRepository.save(entity);
    }
}
