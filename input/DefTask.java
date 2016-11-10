package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the def_task database table.
 * 
 */
@Entity
@Table(name="def_task")
@NamedQuery(name="DefTask.findAll", query="SELECT d FROM DefTask d")
public class DefTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="allocated_minutes")
	private short allocatedMinutes;

	@Column(length=200)
	private String description;

	@Column(nullable=false, length=60)
	private String name;

	@Column(nullable=false)
	private byte number;

	//bi-directional many-to-one association to ProjectType
	@ManyToOne
	@JoinColumn(name="project_type_id", nullable=false)
	private ProjectType projectType;

	public DefTask() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getAllocatedMinutes() {
		return this.allocatedMinutes;
	}

	public void setAllocatedMinutes(short allocatedMinutes) {
		this.allocatedMinutes = allocatedMinutes;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getNumber() {
		return this.number;
	}

	public void setNumber(byte number) {
		this.number = number;
	}

	public ProjectType getProjectType() {
		return this.projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

}