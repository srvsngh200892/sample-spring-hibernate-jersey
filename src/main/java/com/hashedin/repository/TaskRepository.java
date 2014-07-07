package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Task;

public interface TaskRepository {

    Task find(Long taskId);
    List<Task> findAll();
    Task save(Task task);
    Task update(Task task, Long taskId);
    Task delete(Long taskId);


}
