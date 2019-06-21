package com.ninatompkin.beltreviewer.models;

import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Future;

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
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date eventDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> members;
	
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
	private List <Message> messages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date createdAt;
	private Date updatedAt;
	
	public Event() {
		
	}
	
	
	
	public User getHost() {
		return host;
	}



	public void setHost(User host) {
		this.host = host;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getEventDate() {
		return eventDate;
	}



	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
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


	public String formatEventDate() {
		Date date = this.eventDate;
		SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
		String formattedDate = format.format(date);
		return formattedDate;
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
	
	public void addMessage(Message message) {
		messages.add(message);
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
