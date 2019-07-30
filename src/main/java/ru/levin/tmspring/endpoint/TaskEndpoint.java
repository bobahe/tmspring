package ru.levin.tmspring.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.levin.tmspring.api.endpoint.ITaskEndpoint;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.NullOrEmptyNameException;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(endpointInterface = "ru.levin.tmspring.api.endpoint.ITaskEndpoint")
public class TaskEndpoint implements ITaskEndpoint {

    private ITaskService taskService;

    private IProjectService projectService;

    @Override
    public void addTaskToProject(final @Nullable String taskId, final @Nullable String projectId) {
        if (taskId == null || taskId.isEmpty()) return;
        if (projectId == null || projectId.isEmpty()) return;
        @Nullable final Task task = taskService.getById(taskId);
        @Nullable final Project project = projectService.getById(projectId);
        if (task == null || project == null) return;
        task.setProject(project);
        taskService.update(task);
    }

    @Override
    public @Nullable TaskDTO createTask(final @Nullable String taskName) {
        if (taskName == null || taskName.isEmpty()) throw new NullOrEmptyNameException();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName(taskName);
        taskService.create(taskDTO);
        return taskDTO;
    }

    @Override
    public @NotNull List<TaskDTO> getTaskAll() {
        return taskService.findAllDto();
    }

    @Override
    public void removeTask(final @Nullable TaskDTO task) {
        if (task == null || task.getId() == null) return;
        taskService.delete(taskService.getById(task.getId()));
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
    public void updateTask(final @Nullable TaskDTO task) {
        if (task == null) return;
        taskService.update(task);
    }

}
