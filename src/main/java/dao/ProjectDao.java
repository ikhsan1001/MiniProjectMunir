package dao;

import java.util.List;

import entity.Project;

public interface ProjectDao {
	public void save(Project project);
	public void update(Project project);
	public void delete (String noProject);
	public List<Project> findAll();
	public Project findOne(String noProject);

}
