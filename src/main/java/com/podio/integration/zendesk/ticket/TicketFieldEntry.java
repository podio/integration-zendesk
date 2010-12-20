package com.podio.integration.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class TicketFieldEntry {

	private int fieldId;

	private DateTime createdAt;

	private DateTime updatedAt;

	private int ticketId;

	private String value;

	public int getFieldId() {
		return fieldId;
	}

	@JsonProperty("ticket_field_id")
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
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

	public int getTicketId() {
		return ticketId;
	}

	@JsonProperty("ticket_id")
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
