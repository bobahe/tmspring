package ru.levin.tmspring.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.dto.TaskDTO;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<TaskDTO, String> {

    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @NotNull List<TaskDTO> findAll();

    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @NotNull List<TaskDTO> findByProjectId(final String projectId);

}