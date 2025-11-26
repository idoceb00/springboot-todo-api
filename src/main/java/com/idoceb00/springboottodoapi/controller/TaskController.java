package com.idoceb00.springboottodoapi.controller;

import com.idoceb00.springboottodoapi.model.Task;
import com.idoceb00.springboottodoapi.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestParam String title){
        return taskService.createTask(title);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestParam String title, @RequestParam boolean completed){
        return taskService.updateTask(id, title, completed);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
}
