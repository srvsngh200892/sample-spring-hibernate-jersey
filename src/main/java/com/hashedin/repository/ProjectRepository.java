package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

public interface ProjectRepository {
	
    Project find(Long taskId);
    List<Project> findAll();
    Project save(Project proejct);
    Project update(Project project, Long projectId);
    Project delete(Long taskId);
    List<Task> findTasksByProjectId(Long projectId);

}
