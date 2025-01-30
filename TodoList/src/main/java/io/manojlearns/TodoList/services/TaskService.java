package io.manojlearns.TodoList.services;


import io.manojlearns.TodoList.models.Task;
import io.manojlearns.TodoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task findTaskById(long id){
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedTask(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllInCompleteTask(){
        return taskRepository.findByCompletedFalse();
    }

    public Task deleteTask(long id){
        return taskRepository.deleteById(id);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

}
