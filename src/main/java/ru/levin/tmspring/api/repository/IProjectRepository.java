package ru.levin.tmspring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.dto.ProjectDTO;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectDTO, String> {

}