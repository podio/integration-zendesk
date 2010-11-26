package com.podio.zendesk.user;

import java.net.URL;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

import com.podio.zendesk.group.Group;

public class User {

	private int id;

	private String name;

	private String email;

	private Integer localeId;

	private String openIdURL;

	private String timeZone;

	private UserRole role;

	private URL photoURL;

	private Integer organizationId;

	private boolean uses12HourClock;

	private boolean active;

	private boolean verified;

	private String phone;

	private Integer restrictionId;

	private String externalId;

	private String notes;

	private String details;

	private DateTime createdAt;

	private DateTime updatedAt;

	private DateTime lastLogin;

	private List<Group> groups;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLocaleId() {
		return localeId;
	}

	@JsonProperty("locale_id")
	public void setLocaleId(Integer localeId) {
		this.localeId = localeId;
	}

	public String getOpenIdURL() {
		return openIdURL;
	}

	@JsonProperty("openid_url")
	public void setOpenIdURL(String openIdURL) {
		this.openIdURL = openIdURL;
	}

	public String getTimeZone() {
		return timeZone;
	}

	@JsonProperty("time_zone")
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public UserRole getRole() {
		return role;
	}

	@JsonProperty("roles")
	@JsonDeserialize(using = UserRole.Deserializer.class)
	public void setRole(UserRole role) {
		this.role = role;
	}

	public URL getPhotoURL() {
		return photoURL;
	}

	@JsonProperty("photo_url")
	public void setPhotoURL(URL photoURL) {
		this.photoURL = photoURL;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isUses12HourClock() {
		return uses12HourClock;
	}

	@JsonProperty("uses_12_hour_clock")
	public void setUses12HourClock(boolean uses12HourClock) {
		this.uses12HourClock = uses12HourClock;
	}

	public boolean isActive() {
		return active;
	}

	@JsonProperty("is_active")
	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isVerified() {
		return verified;
	}

	@JsonProperty("is_verified")
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRestrictionId() {
		return restrictionId;
	}

	@JsonProperty("restriction_id")
	public void setRestrictionId(Integer restrictionId) {
		this.restrictionId = restrictionId;
	}

	public String getExternalId() {
		return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public DateTime getLastLogin() {
		return lastLogin;
	}

	@JsonProperty("last_login")
	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
