package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userprivilege database table.
 * 
 */
@Entity
@Table(name="userprivilege")
@NamedQuery(name="Userprivilege.findAll", query="SELECT u FROM Userprivilege u")
public class Userprivilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	public Userprivilege() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}