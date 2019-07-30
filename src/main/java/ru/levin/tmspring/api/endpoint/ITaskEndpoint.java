package ru.levin.tmspring.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.dto.TaskDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITaskEndpoint extends IEndpoint {

    @WebMethod
    void addTaskToProject(
            @WebParam(name = "taskId") @Nullable final String taskId,
            @WebParam(name = "projectId") @Nullable final String projectId
    );

    @Nullable
    @WebMethod
    TaskDTO createTask(@WebParam(name = "task") @Nullable final String taskName);

    @NotNull
    @WebMethod
    List<TaskDTO> getTaskAll();

    @WebMethod
    void removeTask(@WebParam(name = "task") @Nullable final TaskDTO task);

    @WebMethod
    void updateTask(@WebParam(name = "task") @Nullable final TaskDTO task);

}
