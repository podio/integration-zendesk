package com.podio.integration.zendesk.ticket;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

import com.podio.integration.zendesk.attachment.Attachment;

public class TicketComment {

	private int authorId;

	private String value;

	private TicketVia via;

	private boolean isPublic;

	private DateTime createdAt;

	private List<Attachment> attachments;

	public int getAuthorId() {
		return authorId;
	}

	@JsonProperty("author_id")
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isPublic() {
		return isPublic;
	}

	@JsonProperty("is_public")
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TicketVia getVia() {
		return via;
	}

	@JsonProperty("via_id")
	@JsonDeserialize(using = TicketVia.Deserializer.class)
	public void setVia(TicketVia via) {
		this.via = via;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
