package com.podio.integration.zendesk.attachment;

import java.net.URL;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class Attachment {

	private int id;

	private int size;

	private String contentType;

	private String filename;

	private URL url;

	private String token;

	private boolean isPublic;

	private DateTime createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getContentType() {
		return contentType;
	}

	@JsonProperty("content_type")
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isPublic() {
		return isPublic;
	}

	@JsonProperty("is_public")
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

}
