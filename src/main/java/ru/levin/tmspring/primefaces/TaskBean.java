package ru.levin.tmspring.primefaces;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Status;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "taskBean")
@SessionScoped
public class TaskBean extends SpringBeanAutowiringSupport {

    private ITaskService taskService;

    private TaskDTO newTask;

    public String createTask() {
        this.newTask = new TaskDTO();
        return "pretty:taskAdd";
    }

    public String editTask(@NotNull final TaskDTO task) {
        this.newTask = task;
        return "pretty:taskEdit";
    }

    public Status[] getStatuses() {
        return Status.values();
    }

    public TaskDTO getTask() {
        return newTask;
    }

    public void setTask(final TaskDTO newTask) {
        this.newTask = newTask;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    @Autowired
    public void setTaskService(final ITaskService taskService) {
        this.taskService = taskService;
    }

    public String saveTask() {
        taskService.create(this.newTask);
        return "pretty:taskList";
    }

}
