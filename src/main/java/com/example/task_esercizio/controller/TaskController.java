package com.example.task_esercizio.controller;

import com.example.task_esercizio.entity.Task;
import com.example.task_esercizio.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task createTask = taskService.addTask(task);
        return ResponseEntity.ok(createTask);
    }

    @GetMapping("/get-all-task")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> updateTaskCompleted(@PathVariable Long id, @RequestParam boolean completed){
        Optional<Task> updateTask = taskService.updateTask(id, completed);
        if(updateTask.isPresent()){
            return ResponseEntity.ok(updateTask.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
