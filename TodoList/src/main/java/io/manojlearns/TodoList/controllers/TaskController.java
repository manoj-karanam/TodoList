package io.manojlearns.TodoList.controllers;

import io.manojlearns.TodoList.models.Task;
import io.manojlearns.TodoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks(){
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllInCompletedTasks(){
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> getAllTasks(@PathVariable Long id){
        return ResponseEntity.ok(taskService.deleteTask(id));

    }



}

