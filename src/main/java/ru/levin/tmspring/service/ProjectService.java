package ru.levin.tmspring.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.IdNullOrEmptyException;
import ru.levin.tmspring.exception.NullDeleteException;
import ru.levin.tmspring.exception.NullOrEmptyNameException;
import ru.levin.tmspring.exception.NullSaveException;
import ru.levin.tmspring.repository.ProjectRepository;
import ru.levin.tmspring.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    @Autowired
    public void setProjectRepository(@NotNull final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setTaskRepository(@NotNull final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void create(final @Nullable Project entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        projectRepository.save(entity);
    }

    @Override
    public void update(final @Nullable Project entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        projectRepository.save(entity);
    }

    @Override
    public void delete(final @Nullable Project entity) {
        if (entity == null) throw new NullDeleteException();
        @NotNull final List<Task> tasks = taskRepository.getAll().stream()
                .filter(task -> task.getProject().getId().equals(entity.getId()))
                .collect(Collectors.toList());
        tasks.forEach(taskRepository::delete);
        projectRepository.delete(entity);
    }

    @Override
    public @NotNull List<Project> findAll() {
        return projectRepository.getAll();
    }

    @Nullable
    @Override
    public Project getById(final @Nullable String id) {
        if (id == null || id.isEmpty()) throw new IdNullOrEmptyException();
        return projectRepository.findById(id);
    }

}
