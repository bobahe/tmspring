package ru.levin.tmspring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.dto.ProjectDTO;

import java.util.List;

@RestController("/project")
public class ProjectController {

    private IProjectService projectService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ProjectDTO createProject(@RequestParam(value = "name") final String projectName) {
        ProjectDTO project = new ProjectDTO();
        project.setName(projectName);
        projectService.create(project);
        return project;
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<ProjectDTO> getProjectAll() {
        return projectService.findAllDto();
    }

    @Autowired
    public void setProjectService(final IProjectService projectService) {
        this.projectService = projectService;
    }

}
