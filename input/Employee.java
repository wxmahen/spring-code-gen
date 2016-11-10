package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(nullable=false, length=40)
	private String email;

	@Column(name="emp_no", nullable=false)
	private int empNo;

	@Column(name="epf_no")
	private int epfNo;

	@Column(nullable=false)
	private byte gender;

	@Column(length=100)
	private String img;

	@Column(nullable=false)
	private byte level;

	@Column(nullable=false, length=15)
	private String mobile;

	@Column(name="name_first", nullable=false, length=25)
	private String nameFirst;

	@Column(name="name_full", nullable=false, length=60)
	private String nameFull;

	@Column(name="name_last", nullable=false, length=30)
	private String nameLast;

	@Column(name="name_middle", length=25)
	private String nameMiddle;

	@Column(length=15)
	private String nic;

	@Column(nullable=false, length=64)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="registered_on")
	private Date registeredOn;

	@Temporal(TemporalType.DATE)
	@Column(name="resigned_on")
	private Date resignedOn;

	@Column(nullable=false)
	private int state;

	@Column(length=100)
	private String token;

	@Column(length=15)
	private String username;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department_id", nullable=false)
	private Department department;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name="designation_id", nullable=false)
	private Designation designation;

	//bi-directional many-to-one association to EmployeeProject
	@OneToMany(mappedBy="employee")
	private List<EmployeeProject> employeeProjects;

	//bi-directional many-to-one association to Record
	@OneToMany(mappedBy="employee")
	private List<Record> records;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="employee1")
	private List<Request> requests1;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="employee2")
	private List<Request> requests2;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="employee")
	private List<Task> tasks;

	//bi-directional many-to-one association to Userlog
	@OneToMany(mappedBy="employee")
	private List<Userlog> userlogs;

	//bi-directional many-to-one association to Empleave
	@OneToMany(mappedBy="employee")
	private List<Empleave> empleaves;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getEpfNo() {
		return this.epfNo;
	}

	public void setEpfNo(int epfNo) {
		this.epfNo = epfNo;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameFull() {
		return this.nameFull;
	}

	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}

	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameMiddle() {
		return this.nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisteredOn() {
		return this.registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}

	public Date getResignedOn() {
		return this.resignedOn;
	}

	public void setResignedOn(Date resignedOn) {
		this.resignedOn = resignedOn;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public List<EmployeeProject> getEmployeeProjects() {
		return this.employeeProjects;
	}

	public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public EmployeeProject addEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().add(employeeProject);
		employeeProject.setEmployee(this);

		return employeeProject;
	}

	public EmployeeProject removeEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().remove(employeeProject);
		employeeProject.setEmployee(null);

		return employeeProject;
	}

	public List<Record> getRecords() {
		return this.records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Record addRecord(Record record) {
		getRecords().add(record);
		record.setEmployee(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setEmployee(null);

		return record;
	}

	public List<Request> getRequests1() {
		return this.requests1;
	}

	public void setRequests1(List<Request> requests1) {
		this.requests1 = requests1;
	}

	public Request addRequests1(Request requests1) {
		getRequests1().add(requests1);
		requests1.setEmployee1(this);

		return requests1;
	}

	public Request removeRequests1(Request requests1) {
		getRequests1().remove(requests1);
		requests1.setEmployee1(null);

		return requests1;
	}

	public List<Request> getRequests2() {
		return this.requests2;
	}

	public void setRequests2(List<Request> requests2) {
		this.requests2 = requests2;
	}

	public Request addRequests2(Request requests2) {
		getRequests2().add(requests2);
		requests2.setEmployee2(this);

		return requests2;
	}

	public Request removeRequests2(Request requests2) {
		getRequests2().remove(requests2);
		requests2.setEmployee2(null);

		return requests2;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setEmployee(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setEmployee(null);

		return task;
	}

	public List<Userlog> getUserlogs() {
		return this.userlogs;
	}

	public void setUserlogs(List<Userlog> userlogs) {
		this.userlogs = userlogs;
	}

	public Userlog addUserlog(Userlog userlog) {
		getUserlogs().add(userlog);
		userlog.setEmployee(this);

		return userlog;
	}

	public Userlog removeUserlog(Userlog userlog) {
		getUserlogs().remove(userlog);
		userlog.setEmployee(null);

		return userlog;
	}

	public List<Empleave> getEmpleaves() {
		return this.empleaves;
	}

	public void setEmpleaves(List<Empleave> empleaves) {
		this.empleaves = empleaves;
	}

	public Empleave addEmpleave(Empleave empleave) {
		getEmpleaves().add(empleave);
		empleave.setEmployee(this);

		return empleave;
	}

	public Empleave removeEmpleave(Empleave empleave) {
		getEmpleaves().remove(empleave);
		empleave.setEmployee(null);

		return empleave;
	}

}