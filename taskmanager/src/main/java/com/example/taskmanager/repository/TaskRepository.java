package com.example.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
	
	List<Task> findByStatus(String status);

}
