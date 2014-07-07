package com.hashedin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Project;
import com.hashedin.model.Task;
import com.hashedin.service.ProjectService;

@Component
@Path("/projects")
public class ProjectResource {

	@Autowired
	private ProjectService projectService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> list() {
		// Handles GET on /Projects. Lists all the Projects we have in our
		// system.
		return projectService.findAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}")
	public Project get(@PathParam("projectId") Long projectId) {
		// Handles GET on /Projects/{ProjectId}. Returns a single Project for
		// the given ProjectId.
		return projectService.find(projectId);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(Project project,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /Projects. Creates a new Project and adds it into an
		// repository.
		projectService.save(project);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/projects/" + project.getProjectId()))
				.build();
	}

	@PUT
	@Path("/{projectId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Project update(Project project,
			@PathParam("projectId") Long projectId) {
		// Handles PUT on /Projects/ProjectId. Updates the existing Project with
		// the new values.
		return projectService.update(project, projectId);
	}

	@DELETE
	@Path("/{projectId}")
	public Project delete(@PathParam("projectId") Long projectId) {
		// Handles DELETE on /Projects/ProjectId. Deletes the existing Project
		// and returns the same.
		return projectService.delete(projectId);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}/tasks")
	public List<Task> getTasks(@PathParam("projectId") Long projectId) {

		return projectService.findTasksByProjectId(projectId);
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{projectId}/tasks/?status={status}")
	public List<Task> getTasksByStatus(@PathParam("projectId") Long projectId,
			@PathParam("status") String status) {

		return projectService.findTasksOfProjectByStatus(projectId, status);
	}
}
