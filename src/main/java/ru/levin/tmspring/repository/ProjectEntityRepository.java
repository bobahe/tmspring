package ru.levin.tmspring.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.api.repository.IProjectEntityRepository;
import ru.levin.tmspring.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public final class ProjectEntityRepository implements IProjectEntityRepository {

    @NotNull
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(final @NotNull Project entity) {
        @Nullable final Project project = entityManager.find(Project.class, entity.getId());
        if (project == null) return;
        entityManager.remove(project);
    }

    @Override
    public @NotNull List<Project> findAll() {
        return entityManager.createQuery("select p from Project p", Project.class).getResultList();
    }

    @Nullable
    @Override
    public Project findById(final @NotNull String id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void save(final @NotNull Project entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final @NotNull Project entity) {
        entityManager.merge(entity);
    }
}