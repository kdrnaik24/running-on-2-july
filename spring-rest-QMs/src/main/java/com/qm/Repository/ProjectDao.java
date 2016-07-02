package com.qm.Repository;

import java.util.List;

import com.qm.model.ProjectModel;

public interface ProjectDao 
{
	public void addProjects(ProjectModel project);
	
	public ProjectModel getProject(int projectId);
	
	public List<ProjectModel> getAllProjects();

	public void updateProject(int projectid,ProjectModel project);

	public void deleteProject(int projectid);
}
