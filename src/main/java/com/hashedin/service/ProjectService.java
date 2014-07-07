package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

public interface ProjectService {
	
	Project find(Long ProjectId);
	    List<Project> findAll();
	    Project save(Project project);
	    Project update(Project project, Long projectId);
	    Project delete(Long projectId);
	    public List<Task> findTasksByProjectId(Long projectId);
}
