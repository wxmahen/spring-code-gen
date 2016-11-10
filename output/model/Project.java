package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="added_at", nullable=false)
	private Timestamp addedAt;

	@Temporal(TemporalType.DATE)
	private Date deadline;

	@Temporal(TemporalType.DATE)
	@Column(name="finished_on")
	private Date finishedOn;

	@Column(nullable=false, length=60)
	private String name;

	@Column(nullable=false)
	private Byte progress;

	@Temporal(TemporalType.DATE)
	@Column(name="started_on")
	private Date startedOn;

	//bi-directional many-to-one association to EmployeeProject
	@OneToMany(mappedBy="project")
	private List<EmployeeProject> employeeProjects;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to ProjectType
	@ManyToOne
	@JoinColumn(name="project_type_id", nullable=false)
	private ProjectType projectType;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="project")
	private List<Request> requests;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAddedAt() {
		return this.addedAt;
	}

	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getFinishedOn() {
		return this.finishedOn;
	}

	public void setFinishedOn(Date finishedOn) {
		this.finishedOn = finishedOn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getProgress() {
		return this.progress;
	}

	public void setProgress(Byte progress) {
		this.progress = progress;
	}

	public Date getStartedOn() {
		return this.startedOn;
	}

	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}

	public List<EmployeeProject> getEmployeeProjects() {
		return this.employeeProjects;
	}

	public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public EmployeeProject addEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().add(employeeProject);
		employeeProject.setProject(this);

		return employeeProject;
	}

	public EmployeeProject removeEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().remove(employeeProject);
		employeeProject.setProject(null);

		return employeeProject;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ProjectType getProjectType() {
		return this.projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setProject(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setProject(null);

		return request;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}
