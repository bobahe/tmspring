package ru.levin.tmspring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.exception.NoSuchProjectException;

import java.util.List;

@RestController
public class ProjectController {

    private IProjectService projectService;

    private ITaskService taskService;

    @PostMapping(value = "/project/create")
    public ProjectDTO createProject(@RequestParam(name = "name") final String projectName) {
        ProjectDTO project = new ProjectDTO();
        project.setName(projectName);
        projectService.create(project);
        return project;
    }

    @GetMapping(value = "/project/get")
    public List<ProjectDTO> getProjectAll() {
        return projectService.findAllDto();
    }

    @GetMapping(value = "/project/tasks/{id}")
    public List<TaskDTO> getProjectTasks(@PathVariable(name = "id") final String projectId) {
        if (projectId == null || projectId.isEmpty()) throw new NoSuchProjectException();
        return taskService.findByProjectId(projectId);
    }

    @DeleteMapping(value = "/project/remove/{id}")
    public void removeProject(@PathVariable(name = "id") final String projectId) {
        if (projectId == null || projectId.isEmpty()) return;
        final Project project = projectService.getById(projectId);
        projectService.delete(project);
    }

    @Autowired
    public void setTaskService(final ITaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping(value = "/project/update")
    public void updateProject(@RequestBody final ProjectDTO project) {
        if (project == null) return;
        projectService.update(project);
    }

    @Autowired
    public void setProjectService(final IProjectService projectService) {
        this.projectService = projectService;
    }

}
