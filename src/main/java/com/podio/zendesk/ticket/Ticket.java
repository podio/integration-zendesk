package com.podio.zendesk.ticket;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

import com.podio.zendesk.serialize.TagListDeserializer;

public class Ticket {

	/**
	 * "original_recipient_address":null, "channel":null, "recipient":null,
	 * "latest_recipients":null, "current_collaborators":null,
	 */

	private DateTime initiallyAssignedAt;

	private DateTime assignedAt;

	private Integer assigneeId;

	private Integer entryId;

	private DateTime createdAt;

	private String subject;

	private String description;

	private String externalId;

	private int groupId;

	private Integer organizationId;

	private int id;

	private List<Integer> linkings;

	private TicketPriority priority;

	private int submitterId;

	private TicketStatus status;

	private DateTime statusUpdatedAt;

	private int requesterId;

	private TicketType type;

	private DateTime updatedAt;

	private TicketVia updatedViaType;

	private TicketVia via;

	private DateTime dueDate;

	private DateTime resolutionTime;

	private DateTime solvedAt;

	private List<String> currentTags;

	private int score;

	private int baseScore;

	private Integer problemId;

	private List<TicketComment> comments;

	private List<TicketFieldEntry> entries;

	public DateTime getInitiallyAssignedAt() {
		return initiallyAssignedAt;
	}

	@JsonProperty("initially_assigned_at")
	public void setInitiallyAssignedAt(DateTime initiallyAssignedAt) {
		this.initiallyAssignedAt = initiallyAssignedAt;
	}

	public Integer getEntryId() {
		return entryId;
	}

	@JsonProperty("entry_id")
	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public TicketVia getUpdatedViaType() {
		return updatedViaType;
	}

	@JsonProperty("updated_by_type_id")
	public void setUpdatedViaType(TicketVia updatedViaType) {
		this.updatedViaType = updatedViaType;
	}

	public DateTime getDueDate() {
		return dueDate;
	}

	@JsonProperty("due_date")
	public void setDueDate(DateTime dueDate) {
		this.dueDate = dueDate;
	}

	public DateTime getResolutionTime() {
		return resolutionTime;
	}

	@JsonProperty("resolution_time")
	public void setResolutionTime(DateTime resolutionTime) {
		this.resolutionTime = resolutionTime;
	}

	public DateTime getSolvedAt() {
		return solvedAt;
	}

	@JsonProperty("solved_at")
	public void setSolvedAt(DateTime solvedAt) {
		this.solvedAt = solvedAt;
	}

	public Integer getProblemId() {
		return problemId;
	}

	@JsonProperty("problem_id")
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public DateTime getAssignedAt() {
		return assignedAt;
	}

	@JsonProperty("assigned_at")
	public void setAssignedAt(DateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public Integer getAssigneeId() {
		return assigneeId;
	}

	@JsonProperty("assignee_id")
	public void setAssigneeId(Integer assigneeId) {
		this.assigneeId = assigneeId;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
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

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public int getGroupId() {
		return groupId;
	}

	@JsonProperty("group_id")
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getId() {
		return id;
	}

	@JsonProperty("nice_id")
	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getLinkings() {
		return linkings;
	}

	@JsonProperty("linkings")
	public void setLinkings(List<Integer> linkings) {
		this.linkings = linkings;
	}

	public TicketPriority getPriority() {
		return priority;
	}

	@JsonProperty("priority_id")
	@JsonDeserialize(using = TicketPriority.Deserializer.class)
	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	@JsonProperty("submitter_id")
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}

	public TicketStatus getStatus() {
		return status;
	}

	@JsonProperty("status_id")
	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public DateTime getStatusUpdatedAt() {
		return statusUpdatedAt;
	}

	@JsonProperty("status_updated_at")
	public void setStatusUpdatedAt(DateTime statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
	}

	public int getRequesterId() {
		return requesterId;
	}

	@JsonProperty("requester_id")
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public TicketType getType() {
		return type;
	}

	@JsonProperty("ticket_type_id")
	@JsonDeserialize(using = TicketType.Deserializer.class)
	public void setType(TicketType type) {
		this.type = type;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public TicketVia getVia() {
		return via;
	}

	@JsonProperty("via_id")
	@JsonDeserialize(using = TicketVia.Deserializer.class)
	public void setVia(TicketVia via) {
		this.via = via;
	}

	public List<String> getCurrentTags() {
		return currentTags;
	}

	@JsonProperty("current_tags")
	@JsonDeserialize(using = TagListDeserializer.class)
	public void setCurrentTags(List<String> currentTags) {
		this.currentTags = currentTags;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBaseScore() {
		return baseScore;
	}

	@JsonProperty("base_score")
	public void setBaseScore(int baseScore) {
		this.baseScore = baseScore;
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

	@JsonProperty("ticket_field_entries")
	public void setEntries(List<TicketFieldEntry> entries) {
		this.entries = entries;
	}
}
