package ru.levin.tmspring.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.levin.tmspring.api.service.IProjectService;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Status;
import ru.levin.tmspring.exception.NoSuchProjectException;

import java.util.List;

@Controller
public class ProjectController {

    @NotNull
    private IProjectService projectService;

    @RequestMapping(value = "/project-list", method = RequestMethod.GET)
    public String getProjectList(final Model model) {
        @NotNull final List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project-list";
    }

    @RequestMapping(value = "/project-list", method = RequestMethod.POST)
    public String getProjectList(final Model model, final RedirectAttributes redirectAttributes) {
        @NotNull final List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project-list";
    }

    @RequestMapping("/project-create")
    public String createProject(final Model model) {
        @NotNull final Project project = new Project();
        model.addAttribute("project", project);
        return "project-create";
    }

    @RequestMapping("/project-edit/{id}")
    public String editProject(final Model model, @PathVariable("id") String projectId) {
        model.addAttribute("project", projectService.getById(projectId));
        model.addAttribute("statuses", Status.values());
        return "project-edit";
    }

    @RequestMapping("/project-detail/{id}")
    public String showProject(final Model model, @PathVariable String id) {
        model.addAttribute("project", projectService.getById(id));
        return "project-detail";
    }

    @RequestMapping(value = "/project-save", method = RequestMethod.POST)
    public String saveProject(final RedirectAttributes redirectAttributes, final @ModelAttribute("project") Project project) {
        redirectAttributes.addFlashAttribute("error", "");
        try {
            projectService.create(project);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:project-list";
    }

    @RequestMapping(value = "/project-delete/{id}")
    public String deleteProject(final RedirectAttributes redirectAttributes, final @PathVariable("id") String id) {
        redirectAttributes.addFlashAttribute("error", "");
        try {
            @Nullable final Project project = projectService.getById(id);
            if (project == null) throw new NoSuchProjectException();
            projectService.delete(project);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/project-list";
    }

    @Autowired
    public void setProjectService(@NotNull final IProjectService projectService) {
        this.projectService = projectService;
    }

}
