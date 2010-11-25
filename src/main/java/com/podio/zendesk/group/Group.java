package com.podio.zendesk.group;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class Group {

	private int id;

	private String name;

	private DateTime createdAt;

	private DateTime updatedAt;

	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return active;
	}

	@JsonProperty("is_active")
	public void setActive(boolean active) {
		this.active = active;
	}

}
