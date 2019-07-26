package ru.levin.tmspring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.dto.TaskDTO;

@Repository
public interface ITaskRepository extends JpaRepository<TaskDTO, String> {

}