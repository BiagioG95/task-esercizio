package com.example.task_esercizio.service;

import com.example.task_esercizio.entity.Task;
import com.example.task_esercizio.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //metodo per aggiunge task
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    // metodo per visualizzare tutte le task
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //metodo per modificare una task
    public Optional<Task> updateTaskCompletedStatus(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            taskOptional.get().setCompleted(true);
            Task task = taskRepository.save(taskOptional.get());
            return Optional.of(task);
        } else {
            return Optional.empty();
        }
    }

    // metodo per cancellare una task
    public Task deleteTask(Task task){
        taskRepository.delete(task);
        return task;

    }
}
