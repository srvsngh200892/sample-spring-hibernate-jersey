package com.hashedin.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tasks")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
@NamedQuery(name = "Task.findByStatus", query = "SELECT t FROM Task t WHERE t.status = :status")})
public class Task {

	@ManyToOne
	private User user;

	@Id
	@GeneratedValue
	private Long id;

	private String taskDesc;

	private String createDate;

	private String endDate;

	private String assignTo;

	private String closeDate;
	
	private String status;

	@ManyToOne
	private Project project;

	

	public String getAssignTo() {
		return assignTo;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public Long getId() {
		return id;
	}

	public Project getProject() {
		return project;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public User getUser() {
		return user;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
