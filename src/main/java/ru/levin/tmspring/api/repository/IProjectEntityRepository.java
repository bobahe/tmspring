package ru.levin.tmspring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.entity.Project;

@Repository
public interface IProjectEntityRepository extends JpaRepository<Project, String> {

}