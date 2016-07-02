package com.qm.controller;

import java.util.List;

import com.qm.dto.ProjectDto;
import com.qm.model.ProjectModel;

public interface ProjectInterface {
public ProjectDto getProject(int projectId);
	
	public List<ProjectDto> getAllProjects();

	public ProjectDto addProjects(ProjectDto project);

	public void deleteProject(int projectid);

	public void updateProject(int projectid,ProjectDto project);

	
}
