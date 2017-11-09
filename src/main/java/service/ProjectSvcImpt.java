package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import dao.ProjectDao;
import entity.Project;
@Service("projectSvc")
public class ProjectSvcImpt implements ProjectSvc{
	
	@Autowired
	ProjectDao projectDao;

	@Override
	public void save(Project project) {
		// TODO Auto-generated method stub
		projectDao.save(project);
	}

	@Override
	public void update(Project project) {
		// TODO Auto-generated method stub
		projectDao.update(project);
	}

	@Override
	public void delete(String noProject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOne(String noProject) {
		// TODO Auto-generated method stub
		return projectDao.findOne(noProject);
	}

	

	

	
	
	

}
