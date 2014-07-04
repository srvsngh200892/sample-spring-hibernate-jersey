


package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;
import com.hashedin.repository.ProjectRepository;


@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectRepository ProjectRepository;


    public Project find(Long projectId)
    {
        // Returns the Project for given ProjectId.
        return ProjectRepository.find(projectId);
    }


    @Transactional
    public Project save(Project project)
    {
        // Saves the given Project object and returns the same.
        ProjectRepository.save(project);
        return project;
    }


    @Override
    public List<Project> findAll()
    {
        // Returns all the Projects in our system.
        return ProjectRepository.findAll();
    }


    @Override
    public Project update(Project project, Long projectId)
    {
        // Updates the Project with the given ProjectId;
        return null;
    }


    @Transactional
    public Project delete(Long projectId)
    {
        // Deletes the Project with the give ProjectId and returns the same.
        return ProjectRepository.delete(projectId);
    }

}
