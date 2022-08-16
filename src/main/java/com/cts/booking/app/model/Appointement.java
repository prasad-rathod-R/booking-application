package com.cts.booking.app.model;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Document(collection = "Appointements")
public class Appointement {
	@Id
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String contact;
	@DateTimeFormat
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Appointement [id=" + id + ", name=" + name + ", contact=" + contact + ", date=" + date + "]";
	}

	public Appointement() {
		this.id = new ObjectId().toString();
	}
}
