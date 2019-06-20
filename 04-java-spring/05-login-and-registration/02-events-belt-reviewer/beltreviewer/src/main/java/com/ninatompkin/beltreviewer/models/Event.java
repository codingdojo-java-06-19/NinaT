package com.ninatompkin.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="events")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private String state;
	
//	@OneToOne(mappedBy="event", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> members;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date createdAt;
	private Date updatedAt;
	
	public Event() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public List<User> getMembers() {
		return members;
	}



	public void setMembers(List<User> members) {
		this.members = members;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void addMember(User user) {
		members.add(user);
	}
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		updatedAt = new Date();
	}
	

}
