package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.api.repository.IProjectRepository;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public final class ProjectRepository implements IProjectRepository {

    @NotNull
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(final @NotNull ProjectDTO entity) {
        @Nullable final Project project = entityManager.find(Project.class, entity.getId());
        if (project == null) return;
        entityManager.remove(project);
    }

    @Override
    public @NotNull List<ProjectDTO> findAll() {
        return entityManager.createQuery("select p from ProjectDTO p", ProjectDTO.class).getResultList();
    }

    @Nullable
    @Override
    public ProjectDTO findById(final @NotNull String id) {
        return entityManager.find(ProjectDTO.class, id);
    }

    @Override
    public void save(final @NotNull ProjectDTO entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final @NotNull ProjectDTO entity) {
        entityManager.merge(entity);
    }
}