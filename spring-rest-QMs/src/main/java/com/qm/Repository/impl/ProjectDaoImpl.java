package com.qm.Repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qm.Repository.ProjectDao;
import com.qm.model.ProjectModel;
@Repository
public class ProjectDaoImpl implements ProjectDao 
{
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void addProjects(ProjectModel project) {
		try{
            entityManager.persist(project);
            entityManager.flush();
      }catch(Exception ex){
            System.out.println("Exception occured while saving project"+ex.getMessage());
            ex.printStackTrace();
      }
	}
	
	@Override
	public ProjectModel getProject(int projectId) {
		System.out.println("In Dao" +projectId);
	
		ProjectModel project = entityManager.find(ProjectModel.class, projectId);
		return project;
	}
	
	
	@Override
	public List<ProjectModel> getAllProjects() {
		TypedQuery<ProjectModel> qt = entityManager.createQuery("SELECT e FROM ProjectModel e", ProjectModel.class);
		List<ProjectModel> projectlist = (List<ProjectModel>)qt.getResultList();
		System.out.println("project "+projectlist);
		return projectlist;
	}

	@Override
	@Transactional
	public void deleteProject(int projectid) {
		ProjectModel project = entityManager.find(ProjectModel.class, projectid);
		entityManager.remove(project);
		System.out.println("In dao after delete");
	}

	@Override
	@Transactional
	public void updateProject(int projectid,ProjectModel project) {
		ProjectModel projectmodel=entityManager.find(ProjectModel.class, projectid);
		System.out.println("Project :"+project);
		projectmodel.setProjectName(project.getProjectName());
		projectmodel.setDescription(project.getDescription());
		entityManager.persist(projectmodel);
	}


}
