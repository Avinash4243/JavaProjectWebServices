package org.citiustech.RESTfulAPI.messenger.model;

import java.util.Date;

public class Comment {
	private Long id;
	private String comment;
	private Date created,edited;
	private String author;
	
	public Comment() {
		super();
	}
	public Comment(Long id, String comment, Date created, String author) {
		super();
		this.id = id;
		this.comment = comment;
		this.created = created;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return comment;
	}
	public void setMessage(String message) {
		this.comment = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
