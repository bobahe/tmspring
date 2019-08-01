package ru.levin.tmspring.managedbean;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.levin.tmspring.api.feign.ITaskClient;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Status;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "taskApiBean")
@SessionScoped
public class TaskApiBean extends SpringBeanAutowiringSupport {

    private ITaskClient client;

    private TaskDTO newTask;

    public String createTask() {
        this.newTask = new TaskDTO();
        return "pretty:taskApiAdd";
    }

    public String editTask(@NotNull final TaskDTO task) {
        this.newTask = task;
        return "pretty:taskApiEdit";
    }

    public ITaskClient getClient() {
        return client;
    }

    @Autowired
    public void setClient(final ITaskClient client) {
        this.client = client;
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

    public String saveTask() {
        client.createTask(this.newTask.getName(), this.newTask.getProjectId());
        return "pretty:taskApiList";
    }

    public String updateTask() {
        client.updateTask(this.newTask);
        return "pretty:taskApiList";
    }

}
