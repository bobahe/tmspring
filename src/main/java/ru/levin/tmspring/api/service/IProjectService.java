package ru.levin.tmspring.api.service;

import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.entity.Project;

import java.util.List;

public interface IProjectService extends IEntityService<Project> {

    void create(final @Nullable ProjectDTO entity);

    List<ProjectDTO> findAllDto();

    void update(final @Nullable ProjectDTO entity);

    ProjectDTO findById(@Nullable final String id);

}
