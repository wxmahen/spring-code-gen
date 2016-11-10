package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the record database table.
 * 
 */
@Entity
@Table(name="record")
@NamedQuery(name="Record.findAll", query="SELECT r FROM Record r")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Byte attendance;

	@Column(name="time_in")
	private Timestamp timeIn;

	@Column(name="time_out")
	private Timestamp timeOut;

	//bi-directional many-to-one association to Day
	@ManyToOne
	@JoinColumn(name="day_id", nullable=false)
	private Day day;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;

	public Record() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getAttendance() {
		return this.attendance;
	}

	public void setAttendance(Byte attendance) {
		this.attendance = attendance;
	}

	public Timestamp getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Timestamp timeIn) {
		this.timeIn = timeIn;
	}

	public Timestamp getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Timestamp timeOut) {
		this.timeOut = timeOut;
	}

	public Day getDay() {
		return this.day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
