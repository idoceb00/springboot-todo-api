package com.idoceb00.springboottodoapi.services;

import com.idoceb00.springboottodoapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();
    private long currentId = 1;

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public Task createTask(String title){
        Task task = new Task(currentId, title, false);
        tasks.put(currentId, task);
        currentId++;
        return task;
    }

    public Optional<Task> getTaskById(Long id){
        return Optional.ofNullable(tasks.get(id));
    }

    public Task updateTask(Long id, String title, boolean completed){
        Task task = tasks.get(id);
        if (task == null){
            return null;
        }
        task.setTitle(title);
        task.setCompleted(completed);
        return task;
    }

    public boolean deleteTask(Long id){
        return tasks.remove(id) != null;
    }
}
