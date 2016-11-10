package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the day database table.
 * 
 */
@Entity
@Table(name="day")
@NamedQuery(name="Day.findAll", query="SELECT d FROM Day d")
public class Day implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	//bi-directional many-to-one association to DayType
	@ManyToOne
	@JoinColumn(name="day_type_id", nullable=false)
	private DayType dayType;

	//bi-directional many-to-one association to Record
	@OneToMany(mappedBy="day")
	private List<Record> records;

	//bi-directional many-to-one association to Empleave
	@OneToMany(mappedBy="day")
	private List<Empleave> empleaves;

	public Day() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DayType getDayType() {
		return this.dayType;
	}

	public void setDayType(DayType dayType) {
		this.dayType = dayType;
	}

	public List<Record> getRecords() {
		return this.records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Record addRecord(Record record) {
		getRecords().add(record);
		record.setDay(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setDay(null);

		return record;
	}

	public List<Empleave> getEmpleaves() {
		return this.empleaves;
	}

	public void setEmpleaves(List<Empleave> empleaves) {
		this.empleaves = empleaves;
	}

	public Empleave addEmpleave(Empleave empleave) {
		getEmpleaves().add(empleave);
		empleave.setDay(this);

		return empleave;
	}

	public Empleave removeEmpleave(Empleave empleave) {
		getEmpleaves().remove(empleave);
		empleave.setDay(null);

		return empleave;
	}

}
