package com.ninatompkin.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Language {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    private String creator;
    @Min(1)
    private String version;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Language() {
    	
    }
    
    public Language(String name, String creator, String version) {
    	this.name = name;
    	this.creator = creator;
    	this.version = version;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
    
	  //Right before the object is created, save the date that the object is created at
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    //Right before the object is updated, save the date before the object is updated at
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

