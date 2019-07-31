package ru.levin.tmspring.controller.rest;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Project;

import java.util.List;

@RestController
public class TaskController {

    private ITaskService taskService;

    private IProjectService projectService;

    @PostMapping(value = "/task/create")
    public TaskDTO createTask(
            @RequestParam(value = "name") final String taskName,
            @RequestParam(value = "projectId") final String projectId) {
        if (taskName == null) return null;
        if (projectId == null || projectId.isEmpty()) return null;
        @Nullable final Project project = projectService.getById(projectId);
        if (project == null) return null;
        TaskDTO task = new TaskDTO();
        task.setName(taskName);
        task.setProjectId(projectId);
        taskService.create(task);
        return task;
    }

    @GetMapping(value = "/task/get")
    public List<TaskDTO> getTaskAll() {
        return taskService.findAllDto();
    }

    @DeleteMapping(value = "/task/remove/{id}")
    public void removeTask(@PathVariable(name = "id") final String taskId) {
        if (taskId == null || taskId.isEmpty()) return;
        taskService.delete(taskService.getById(taskId));
    }

    @Autowired
    public void setProjectService(final IProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setTaskService(final ITaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping(value = "/task/update")
    public void updateTask(@RequestBody final TaskDTO task) {
        if (task == null) return;
        taskService.update(task);
    }

}
