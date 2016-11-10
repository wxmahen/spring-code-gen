package com.radicalz.persistence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the log_type database table.
 * 
 */
@Entity
@Table(name="log_type")
@NamedQuery(name="LogType.findAll", query="SELECT l FROM LogType l")
public class LogType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=40)
	private String name;

	//bi-directional many-to-one association to Userlog
	@OneToMany(mappedBy="logType")
	private List<Userlog> userlogs;

	public LogType() {
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

	public List<Userlog> getUserlogs() {
		return this.userlogs;
	}

	public void setUserlogs(List<Userlog> userlogs) {
		this.userlogs = userlogs;
	}

	public Userlog addUserlog(Userlog userlog) {
		getUserlogs().add(userlog);
		userlog.setLogType(this);

		return userlog;
	}

	public Userlog removeUserlog(Userlog userlog) {
		getUserlogs().remove(userlog);
		userlog.setLogType(null);

		return userlog;
	}

}