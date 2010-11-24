package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonProperty;

public class TicketFieldEntry {

	private int fieldId;

	private String value;

	public int getFieldId() {
		return fieldId;
	}

	@JsonProperty("ticket-field-id")
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
