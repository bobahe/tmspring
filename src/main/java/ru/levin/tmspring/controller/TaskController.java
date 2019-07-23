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
import ru.levin.tmspring.api.service.ITaskService;
import ru.levin.tmspring.dto.TaskDTO;
import ru.levin.tmspring.entity.Project;
import ru.levin.tmspring.entity.Status;
import ru.levin.tmspring.entity.Task;
import ru.levin.tmspring.exception.NoSuchProjectException;

import java.util.List;

@Controller
public class TaskController {

    @NotNull
    private ITaskService taskService;

    @NotNull
    private IProjectService projectService;

    @RequestMapping("/task-create")
    public String createTask(final Model model, final RedirectAttributes redirectAttributes) {
        @NotNull final List<Project> projects = projectService.findAll();
        if (projects.size() == 0) {
            redirectAttributes.addFlashAttribute("error", "Сначала необходимо создать хотя бы один проект.");
            return "redirect:/project-list";
        }
        @NotNull final TaskDTO task = new TaskDTO();
        model.addAttribute("task", task);
        model.addAttribute("projects", projects);
        return "task-create";
    }

    @RequestMapping(value = "/task-delete/{id}")
    public String deleteTask(final RedirectAttributes redirectAttributes, final @PathVariable("id") String id) {
        redirectAttributes.addFlashAttribute("error", "");
        try {
            @Nullable final Task task = taskService.getById(id);
            if (task == null) throw new NoSuchProjectException();
            taskService.delete(task);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/task-list";
    }

    @RequestMapping("/task-edit/{id}")
    public String editTask(final Model model, @PathVariable("id") String id) {
        @Nullable final Task task = taskService.getById(id);
        if (task == null) throw new NoSuchProjectException();
        @NotNull final TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setEndDate(task.getEndDate());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setProjectId(task.getProject().getId());
        model.addAttribute("task", taskDTO);
        model.addAttribute("statuses", Status.values());
        model.addAttribute("projects", projectService.findAll());
        return "task-edit";
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.POST)
    public String getTaskList(final Model model, final RedirectAttributes redirectAttributes) {
        @NotNull final List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.GET)
    public String getTaskList(final Model model) {
        @NotNull final List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @RequestMapping(value = "/task-save", method = RequestMethod.POST)
    public String saveTask(final RedirectAttributes redirectAttributes, final @ModelAttribute("task") TaskDTO task) {
        redirectAttributes.addFlashAttribute("error", "");
        try {
            if (taskService.getById(task.getId()) == null) {
                taskService.create(task);
            } else {
                taskService.update(task);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:task-list";
    }

    @Autowired
    public void setProjectService(@NotNull final IProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setTaskService(@NotNull final ITaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/task-detail/{id}")
    public String showTask(final Model model, @PathVariable String id) {
        model.addAttribute("task", taskService.getById(id));
        return "task-detail";
    }
}
