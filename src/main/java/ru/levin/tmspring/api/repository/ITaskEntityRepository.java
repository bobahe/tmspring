package ru.levin.tmspring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levin.tmspring.entity.Task;

@Repository
public interface ITaskEntityRepository extends JpaRepository<Task, String> {

}