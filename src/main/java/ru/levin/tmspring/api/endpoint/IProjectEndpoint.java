package ru.levin.tmspring.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.dto.TaskDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProjectEndpoint extends IEndpoint {

    @Nullable
    @WebMethod
    ProjectDTO createProject(@WebParam(name = "projectName") @Nullable final String projectName);

    @NotNull
    @WebMethod
    List<ProjectDTO> getProjectAll();

    @NotNull
    @WebMethod
    List<TaskDTO> getProjectTasks(@WebParam(name = "project") @Nullable final ProjectDTO project);

    @WebMethod
    void removeProject(@WebParam(name = "project") @Nullable final ProjectDTO project);

    @WebMethod
    void updateProject(@WebParam(name = "project") @Nullable final ProjectDTO project);

}
