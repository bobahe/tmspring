package ru.levin.tmspring.managedbean;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.levin.tmspring.api.feign.IProjectClient;
import ru.levin.tmspring.dto.ProjectDTO;
import ru.levin.tmspring.entity.Status;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "projectApiBean")
@SessionScoped
public class ProjectApiBean extends SpringBeanAutowiringSupport {

    private IProjectClient client;
    private ProjectDTO newProject = new ProjectDTO();

    public String createProject() {
        this.newProject = new ProjectDTO();
        return "pretty:projectApiAdd";
    }

    public String editProject(@NotNull final ProjectDTO project) {
        this.newProject = project;
        return "pretty:projectApiEdit";
    }

    public IProjectClient getClient() {
        return client;
    }

    @Autowired
    public void setClient(final IProjectClient client) {
        this.client = client;
    }

    public ProjectDTO getProject() {
        return newProject;
    }

    public void setProject(final ProjectDTO project) {
        this.newProject = project;
    }

    public Status[] getStatuses() {
        return Status.values();
    }

    public String saveProject() {
        client.createProject(this.newProject.getName());
        return "pretty:projectApiList";
    }

    public String updateProject() {
        client.updateProject(this.newProject);
        return "pretty:projectApiList";
    }

}
