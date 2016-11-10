package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the day_type database table.
 * 
 */
@Entity
@Table(name="day_type")
@NamedQuery(name="DayType.findAll", query="SELECT d FROM DayType d")
public class DayType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=6)
	private String color;

	@Column(nullable=false, length=25)
	private String name;

	//bi-directional many-to-one association to Day
	@OneToMany(mappedBy="dayType")
	private List<Day> days;

	public DayType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Day> getDays() {
		return this.days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public Day addDay(Day day) {
		getDays().add(day);
		day.setDayType(this);

		return day;
	}

	public Day removeDay(Day day) {
		getDays().remove(day);
		day.setDayType(null);

		return day;
	}

}
