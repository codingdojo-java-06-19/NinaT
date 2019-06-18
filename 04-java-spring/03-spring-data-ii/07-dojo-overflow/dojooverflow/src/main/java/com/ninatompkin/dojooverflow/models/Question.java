package com.ninatompkin.dojooverflow.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String content;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="question",fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			name="questions_tags",
			joinColumns = @JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn(name="tag_id")
	)
	@Size(max=3)
	private List<Tag> tags;
	
	public Question() {
		tags = new ArrayList<Tag>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public String printTagsForQuestion() {
		String tagStr = "";
		for (Tag tag : tags) {
			tagStr += tag.getContent()+", ";
		}
		return tagStr;
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}
	
	public void addTag(Tag tag) {
		System.out.println("Tags is null"+tags==null);
		System.out.println("tags is"+tags);
		tags.add(tag);
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
