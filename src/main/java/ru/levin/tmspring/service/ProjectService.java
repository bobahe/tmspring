package ru.levin.tmspring.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levin.tmspring.api.repository.IProjectEntityRepository;
import ru.levin.tmspring.api.repository.IProjectRepository;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.exception.IdNullOrEmptyException;
import ru.levin.tmspring.exception.NullDeleteException;
import ru.levin.tmspring.exception.NullOrEmptyNameException;
import ru.levin.tmspring.exception.NullSaveException;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    private IProjectEntityRepository projectEntityRepository;

    private IProjectRepository projectRepository;

    @Override
    public void create(final @Nullable ProjectDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        projectRepository.save(entity);
    }

    @Override
    @Transactional
    public void create(final @Nullable Project entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        projectEntityRepository.save(entity);
    }

    @Override
    public List<ProjectDTO> findAllDto() {
        return projectRepository.findAll();
    }

    @Autowired
    public void setProjectEntityRepository(@NotNull final IProjectEntityRepository projectRepository) {
        this.projectEntityRepository = projectRepository;
    }

    @Override
    @Transactional
    public void delete(final @Nullable Project entity) {
        if (entity == null) throw new NullDeleteException();
        projectEntityRepository.delete(entity);
    }

    @Autowired
    public void setProjectRepository(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public @NotNull List<Project> findAll() {
        return projectEntityRepository.findAll();
    }

    @Nullable
    @Override
    public Project getById(final @Nullable String id) {
        if (id == null || id.isEmpty()) throw new IdNullOrEmptyException();
        return projectEntityRepository.findById(id).orElse(null);
    }

    @Override
    public void update(final @Nullable ProjectDTO entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getId() == null || entity.getId().isEmpty()) throw new IdNullOrEmptyException();
        projectRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(final @Nullable Project entity) {
        if (entity == null) throw new NullSaveException();
        if (entity.getName() == null || entity.getName().isEmpty()) throw new NullOrEmptyNameException();
        projectEntityRepository.save(entity);
    }

}
