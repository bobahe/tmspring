package ru.levin.tmspring.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levin.tmspring.api.repository.IProjectRepository;
import ru.levin.tmspring.api.repository.ITaskRepository;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.*;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private ITaskRepository taskRepository;

    private IProjectRepository projectRepository;

    @Autowired
    public void setTaskRepository(@NotNull final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    public void setProjectRepository(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void create(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    public void create(final @Nullable TaskDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        @NotNull final Task task = new Task();
        task.setId(entity.getId());
        task.setName(entity.getName());
        task.setProject(projectRepository.findById(entity.getProjectId()));
        taskRepository.save(task);
    }

    @Override
    public void update(final @Nullable Task entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        taskRepository.save(entity);
    }

    @Override
    public void update(final @Nullable TaskDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        @Nullable final Task task = taskRepository.findById(entity.getId());
        if (task == null) throw new NoSuchProjectException();
        task.setName(entity.getName());
        task.setDescription(entity.getDescription());
        task.setStartDate(entity.getStartDate());
        task.setEndDate(entity.getEndDate());
        task.setStatus(entity.getStatus());
        task.setProject(projectRepository.findById(entity.getProjectId()));
        taskRepository.save(task);
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
