package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the leavetype database table.
 * 
 */
@Entity
@Table(name="leavetype")
@NamedQuery(name="Leavetype.findAll", query="SELECT l FROM Leavetype l")
public class Leavetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to Empleave
	@OneToMany(mappedBy="leavetype")
	private List<Empleave> empleaves;

	public Leavetype() {
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

	public List<Empleave> getEmpleaves() {
		return this.empleaves;
	}

	public void setEmpleaves(List<Empleave> empleaves) {
		this.empleaves = empleaves;
	}

	public Empleave addEmpleave(Empleave empleave) {
		getEmpleaves().add(empleave);
		empleave.setLeavetype(this);

		return empleave;
	}

	public Empleave removeEmpleave(Empleave empleave) {
		getEmpleaves().remove(empleave);
		empleave.setLeavetype(null);

		return empleave;
	}

}
