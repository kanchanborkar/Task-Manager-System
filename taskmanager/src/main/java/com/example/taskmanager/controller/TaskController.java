package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	 @Autowired
	    private TaskService service;

	    // Create Task
	    @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return service.createTask(task);
	    }

	    // Get All Tasks
	    @GetMapping
	    public List<Task> getAllTasks() {
	        return service.getAllTasks();
	    }

	    // Get Tasks By Status
	    @GetMapping("/status/{status}")
	    public List<Task> getTasksByStatus(@PathVariable String status) {
	        return service.getTasksByStatus(status);
	    }

	    // Update Task
	    @PutMapping("/{id}")
	    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
	        return service.updateTask(id, task);
	    }

	    // Delete Task
	    @DeleteMapping("/{id}")
	    public String deleteTask(@PathVariable Long id) {
	        service.deleteTask(id);
	        return "Task deleted successfully";
	    }
}
