package com.podio.zendesk.ticket;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

public class Ticket {

	private DateTime assignedAt;

	private int assigneeId;

	private DateTime assigneeUpdatedAt;

	private DateTime createdAt;

	private String subject;

	private String description;

	private String externalId;

	private int groupId;

	private int id;

	private Integer linkedId;

	private TicketPriority priority;

	private int submitterId;

	private TicketStatus status;

	private DateTime statusUpdatedAt;

	private int requesterId;

	private DateTime requesterUpdatedAt;

	private TicketType type;

	private DateTime updatedAt;

	private TicketViaType via;

	private List<String> currentTags;

	private int score;

	private List<TicketComment> comments;

	private List<TicketFieldEntry> entries;

	public DateTime getAssignedAt() {
		return assignedAt;
	}

	@JsonProperty("assigned-at")
	public void setAssignedAt(DateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public int getAssigneeId() {
		return assigneeId;
	}

	@JsonProperty("assignee-id")
	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}

	public DateTime getAssigneeUpdatedAt() {
		return assigneeUpdatedAt;
	}

	@JsonProperty("assignee-updated-at")
	public void setAssigneeUpdatedAt(DateTime assigneeUpdatedAt) {
		this.assigneeUpdatedAt = assigneeUpdatedAt;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created-at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external-id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public int getGroupId() {
		return groupId;
	}

	@JsonProperty("group-id")
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLinkedId() {
		return linkedId;
	}

	@JsonProperty("linked-id")
	public void setLinkedId(Integer linkedId) {
		this.linkedId = linkedId;
	}

	public TicketPriority getPriority() {
		return priority;
	}

	@JsonProperty("priority-id")
	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	@JsonProperty("submitter-id")
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}

	public TicketStatus getStatus() {
		return status;
	}

	@JsonProperty("status-id")
	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public DateTime getStatusUpdatedAt() {
		return statusUpdatedAt;
	}

	@JsonProperty("status-updated-at")
	public void setStatusUpdatedAt(DateTime statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
	}

	public int getRequesterId() {
		return requesterId;
	}

	@JsonProperty("requester-id")
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public DateTime getRequesterUpdatedAt() {
		return requesterUpdatedAt;
	}

	@JsonProperty("requester-updated-at")
	public void setRequesterUpdatedAt(DateTime requesterUpdatedAt) {
		this.requesterUpdatedAt = requesterUpdatedAt;
	}

	public TicketType getType() {
		return type;
	}

	@JsonProperty("ticket-type-id")
	public void setType(TicketType type) {
		this.type = type;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated-at")
	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public TicketViaType getVia() {
		return via;
	}

	@JsonProperty("via-id")
	public void setVia(TicketViaType via) {
		this.via = via;
	}

	public List<String> getCurrentTags() {
		return currentTags;
	}

	@JsonProperty("current-tags")
	public void setCurrentTags(List<String> currentTags) {
		this.currentTags = currentTags;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<TicketComment> getComments() {
		return comments;
	}

	public void setComments(List<TicketComment> comments) {
		this.comments = comments;
	}

	public List<TicketFieldEntry> getEntries() {
		return entries;
	}

	@JsonProperty("ticket-field-entries")
	public void setEntries(List<TicketFieldEntry> entries) {
		this.entries = entries;
	}
}
