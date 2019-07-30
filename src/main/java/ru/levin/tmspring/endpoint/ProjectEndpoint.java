package ru.levin.tmspring.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.levin.tmspring.api.endpoint.IProjectEndpoint;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.exception.IdNullOrEmptyException;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(endpointInterface = "ru.levin.tmspring.api.endpoint.IProjectEndpoint")
public class ProjectEndpoint implements IProjectEndpoint {

    private IProjectService projectService;

    private ITaskService taskService;

    @Override
    public @Nullable ProjectDTO createProject(final @Nullable String projectName) {
        if (projectName == null) return null;
        ProjectDTO project = new ProjectDTO();
        project.setName(projectName);
        projectService.create(project);
        return project;
    }

    @Override
    public @NotNull List<ProjectDTO> getProjectAll() {
        return projectService.findAllDto();
    }

    @Override
    public @NotNull List<TaskDTO> getProjectTasks(final @Nullable ProjectDTO project) {
        if (project == null || project.getId() == null) throw new IdNullOrEmptyException();
        return taskService.findByProjectId(project.getId());
    }

    @Override
    public void removeProject(final @Nullable ProjectDTO project) {
        if (project == null) return;
        projectService.delete(projectService.getById(project.getId()));
    }

    @Autowired
    public void setProjectService(final IProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setTaskService(final ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void updateProject(final @Nullable ProjectDTO project) {
        if (project == null) return;
        projectService.update(project);
    }

}
