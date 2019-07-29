package ru.levin.tmspring.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.entity.Project;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface IProjectEntityRepository extends JpaRepository<Project, String> {

    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @NotNull List<Project> findAll();

}