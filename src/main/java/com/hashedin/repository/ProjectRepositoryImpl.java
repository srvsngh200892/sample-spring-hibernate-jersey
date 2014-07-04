package com.hashedin.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Project;

@Repository("projectRepository")

public class ProjectRepositoryImpl implements ProjectRepository {
	
	
	
	

	    @PersistenceContext
	    private EntityManager em;
	    
	    public Project find(Long proId) {
	        // Returns the Task for given taskId.
	        return em.find(Project.class, proId);
	    }

	    public Project save(Project project) {
	        // Saves the given task object and returns the same.
	        em.persist(project);
	        em.flush();
	        return project;
	    }

	   //@Override
	    public List<Project> findAll() {
	        //Returns all the tasks in our system.
	       TypedQuery<Project> query = em.createNamedQuery("Project.findAll", Project.class);
	       List<Project> results = query.getResultList();
	        return results;
	   }

	    @Override
	    public Project update(Project pro, Long proId)
	    {
	        // TODO Auto-generated method stub
	        return null;
	    }

	    @Override
	    public Project delete(Long proId)
	    {
	    	Project taskToBeDeleted = em.find(Project.class, proId); 
	        em.remove(taskToBeDeleted);
	        return taskToBeDeleted;
	    }

	}



