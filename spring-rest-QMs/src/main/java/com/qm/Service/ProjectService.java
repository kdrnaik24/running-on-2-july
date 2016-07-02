package com.qm.Service;

import java.util.List;

import com.qm.dto.ProjectDto;
import com.qm.model.ProjectModel;

public interface ProjectService 
{
	public ProjectDto getProject(int projectId);
	
	public List<ProjectDto> getAllProjects();

	public void deleteProject(int projectid);

	public void addProjects(ProjectDto project);

	public void updateProject(int projectid, ProjectDto project);
}
