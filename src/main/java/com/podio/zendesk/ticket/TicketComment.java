package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class TicketComment {

	private int authorId;

	private DateTime createdAt;

	private boolean isPublic;

	private String value;

	private TicketViaType via;

	private Integer viaReference;

	public int getAuthorId() {
		return authorId;
	}

	@JsonProperty("author-id")
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created-at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isPublic() {
		return isPublic;
	}

	@JsonProperty("is-public")
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TicketViaType getVia() {
		return via;
	}

	@JsonProperty("via-id")
	public void setVia(TicketViaType via) {
		this.via = via;
	}

	public Integer getViaReference() {
		return viaReference;
	}

	@JsonProperty("via-reference")
	public void setViaReference(Integer viaReference) {
		this.viaReference = viaReference;
	}
}
