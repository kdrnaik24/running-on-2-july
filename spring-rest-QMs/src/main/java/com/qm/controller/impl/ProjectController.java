package com.qm.controller.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.qm.Populator.ProjectPopulator;
import com.qm.Service.ProjectService;
import com.qm.controller.ProjectInterface;
import com.qm.dto.ProjectDto;

@Path("/projectServ")
public class ProjectController implements ProjectInterface{

	@Autowired 
	ProjectService projectService;

	
	@Autowired
	ProjectPopulator projectPopulator;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/{projectId}")
	@Override
	public ProjectDto getProject(@javax.ws.rs.PathParam(value = "projectId") int projectId) {
		System.out.println("Inside Controller");
		ProjectDto projectDto = projectService.getProject(projectId);
		System.out.println(projectDto);
		return projectDto;
	}
	
	
	@GET
	@Path("/getAllProject")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<ProjectDto> getAllProjects() {
		System.out.println("Inside getEmployee Controller");
		List<ProjectDto> projectDtoList = projectService.getAllProjects();
		return projectDtoList;
	}

	@Override
	@DELETE
	@Path("/deleteproject/{projectid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteProject(@PathParam("projectid") int projectid) {
		projectService.deleteProject(projectid);
		
	}
	@PUT
	@Path("/updateProject/{projectid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void updateProject(@PathParam("projectid") int projectid,ProjectDto project) {
		projectService.updateProject(projectid,project);
	
	}
	
	@POST
    @Path("/addProject")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Override
	public ProjectDto addProjects(ProjectDto project) 
	{
    	projectService.addProjects(project);
    	return project;
	}

}
