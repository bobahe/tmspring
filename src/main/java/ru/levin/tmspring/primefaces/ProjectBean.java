package ru.levin.tmspring.primefaces;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Status;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean extends SpringBeanAutowiringSupport {

    private IProjectService projectService;

    private Project newProject = new Project();

    public String createProject() {
        this.newProject = new Project();
        return "pretty:projectAdd";
    }

    public String editProject(@NotNull final Project project) {
        this.newProject = project;
        return "pretty:projectEdit";
    }

    public Project getProject() {
        return newProject;
    }

    public void setProject(final Project project) {
        this.newProject = project;
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    @Autowired
    public void setProjectService(final IProjectService projectService) {
        this.projectService = projectService;
    }

    public Status[] getStatuses() {
        return Status.values();
    }

    public String saveProject() {
        projectService.create(this.newProject);
        return "pretty:projectList";
    }

}
