package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;

public interface ProjectRepository {
	
    Project find(Long taskId);
    List<Project> findAll();
    Project save(Project proejct);
    Project update(Project project, Long projectId);
    Project delete(Long taskId);

}
