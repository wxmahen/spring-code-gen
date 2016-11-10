package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project_type database table.
 * 
 */
@Entity
@Table(name="project_type")
@NamedQuery(name="ProjectType.findAll", query="SELECT p FROM ProjectType p")
public class ProjectType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to DefTask
	@OneToMany(mappedBy="projectType")
	private List<DefTask> defTasks;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectType")
	private List<Project> projects;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department_id", nullable=false)
	private Department department;

	public ProjectType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DefTask> getDefTasks() {
		return this.defTasks;
	}

	public void setDefTasks(List<DefTask> defTasks) {
		this.defTasks = defTasks;
	}

	public DefTask addDefTask(DefTask defTask) {
		getDefTasks().add(defTask);
		defTask.setProjectType(this);

		return defTask;
	}

	public DefTask removeDefTask(DefTask defTask) {
		getDefTasks().remove(defTask);
		defTask.setProjectType(null);

		return defTask;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectType(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectType(null);

		return project;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
