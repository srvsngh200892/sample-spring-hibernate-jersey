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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query =
"SELECT u FROM User u") })
public class User {
	@Id
    @GeneratedValue
	private Long userId;

    private String userName;
    
    private String email;
    
    private String gender;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="user")
    private List<Task> tasks;
    
    public User() {
        tasks = new ArrayList<Task>();
    }
    
   

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Task> getTasks() {

		return tasks;
	}

	public void setTasks(List<Task> tasks) {

		this.tasks = tasks;
	}
    
    
	
}
