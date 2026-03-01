package com.example.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
@Service
public class TaskService {
	
	 @Autowired
	    private TaskRepository repository;

	    // Create Task
	    public Task createTask(Task task) {
	        task.setStatus("PENDING");   // default status
	        return repository.save(task);
	    }

	    // Get All Tasks
	    public List<Task> getAllTasks() {
	        return repository.findAll();
	    }

	    // Get Tasks By Status
	    public List<Task> getTasksByStatus(String status) {
	        return repository.findByStatus(status);
	    }

	    // Update Task
	    public Task updateTask(Long id, Task updatedTask) {
	        Task task = repository.findById(id).orElseThrow();

	        task.setTitle(updatedTask.getTitle());
	        task.setDescription(updatedTask.getDescription());
	        task.setDueDate(updatedTask.getDueDate());
	        task.setStatus(updatedTask.getStatus());

	        return repository.save(task);
	    }

	    // Delete Task
	    public void deleteTask(Long id) {
	        repository.deleteById(id);
	    }
	}


