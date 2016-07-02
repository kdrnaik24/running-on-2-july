package com.qm.dto;
import org.springframework.stereotype.Component;

@Component
public class ProjectDto 
{

	private int projectId;
	private String projectName ; 
	private String description ;
	
	public ProjectDto() 
	{
		// TODO Auto-generated constructor stub
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ "]";
	}
	
	
	

}
