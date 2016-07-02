package com.qm.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qm.Populator.ProjectPopulator;
import com.qm.Repository.ProjectDao;
import com.qm.Service.ProjectService;
import com.qm.dto.ProjectDto;
import com.qm.model.ProjectModel;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectDao projectdao;
	
	@Autowired
	ProjectPopulator projectpopulator;
	
	@Override
	public void addProjects(ProjectDto projectdto) {
		ProjectModel projectmodel=new ProjectModel();
		projectpopulator.populate(projectmodel, projectdto);
		projectdao.addProjects(projectmodel);
	}

	@Override
	public ProjectDto getProject(int projectId) {
		ProjectDto projectDto = new ProjectDto();
		projectpopulator.populate(projectDto,projectdao.getProject(projectId));
		return projectDto;
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		
		List<ProjectDto> projectDtoList = new ArrayList<>();
		List<ProjectModel> projectModelList  = projectdao.getAllProjects();
		
		
		for (ProjectModel projectModel : projectModelList) {
			ProjectDto projectDto = new ProjectDto();
			projectpopulator.populate(projectDto,projectModel);
			projectDtoList.add(projectDto);
		}
		
		return projectDtoList;
	}

	@Override
	public void deleteProject(int projectid) {

		projectdao.deleteProject(projectid);
		
	}

	@Override
	public void updateProject(int projectid,ProjectDto project) {
		
		ProjectModel projectModel = new ProjectModel();
		projectpopulator.populate(projectModel, project);
		System.out.println("In populator :"+projectModel);
		projectdao.updateProject(projectid,projectModel);
		
	}
	
	
	

}
