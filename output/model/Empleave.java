package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleave database table.
 * 
 */
@Entity
@Table(name="empleave")
@NamedQuery(name="Empleave.findAll", query="SELECT e FROM Empleave e")
public class Empleave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Byte approved;

	@Column(length=60)
	private String reason;

	@Column(nullable=false)
	private Byte taken;

	//bi-directional many-to-one association to Day
	@ManyToOne
	@JoinColumn(name="day_id", nullable=false)
	private Day day;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;

	//bi-directional many-to-one association to Leavetype
	@ManyToOne
	@JoinColumn(name="leavetype_id", nullable=false)
	private Leavetype leavetype;

	public Empleave() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getApproved() {
		return this.approved;
	}

	public void setApproved(Byte approved) {
		this.approved = approved;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Byte getTaken() {
		return this.taken;
	}

	public void setTaken(Byte taken) {
		this.taken = taken;
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

	public Leavetype getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(Leavetype leavetype) {
		this.leavetype = leavetype;
	}

}
