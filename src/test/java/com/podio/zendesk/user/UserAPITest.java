package com.podio.zendesk.user;

import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.podio.zendesk.APIFactory;

public class UserAPITest {

	private static UserAPI getAPI() throws IOException {
		return APIFactory.getFromConfig().getUserAPI();
	}

	@Test
	public void getCurrentUser() throws IOException {
		User user = getAPI().getCurrentUser();

		Assert.assertEquals(user.getId(), 16080839);
	}

	@Test
	public void getUser() throws IOException {
		User user = getAPI().getUser(16080839);

		Assert.assertEquals(user.getGroups().size(), 1);
		Assert.assertEquals(user.getGroups().get(0).getName(), "Support");
		Assert.assertEquals(user.getGroups().get(0).getCreatedAt(), null);
		Assert.assertEquals(user.getGroups().get(0).getId(), 1807);
		Assert.assertEquals(user.getGroups().get(0).getUpdatedAt(), null);

		Assert.assertEquals(user.getDetails(), "");
		Assert.assertEquals(user.getEmail(), "holm@hoisthq.com");
		Assert.assertEquals(user.getExternalId(), null);
		Assert.assertEquals(user.getName(), "Christian Holm");
		Assert.assertEquals(user.getNotes(), "");
		Assert.assertEquals(user.getOpenIdURL(), null);
		Assert.assertEquals(user.getPhone(), "");
		Assert.assertEquals(user.getCreatedAt(), new DateTime(2010, 8, 26, 11,
				50, 12, 0));
		Assert.assertEquals(user.getId(), 16080839);
		Assert.assertNotNull(user.getLastLogin());
		Assert.assertEquals(user.getLocaleId(), null);
		Assert.assertEquals(user.getOrganizationId(), null);
		Assert.assertEquals(
				user.getPhotoURL().toString(),
				"http://hoist.zendesk.com/system/photos/0015/9483/picture-5343-1275426057_thumb.jpg");
		Assert.assertEquals(user.getRestrictionId().intValue(), 0);
		Assert.assertEquals(user.getRole(), UserRole.AGENT);
		Assert.assertEquals(user.getTimeZone(), "Copenhagen");
		Assert.assertEquals(user.isVerified(), true);
		Assert.assertEquals(user.isActive(), true);
		Assert.assertEquals(user.getUpdatedAt(), new DateTime(2010, 10, 21, 16,
				9, 23, 0));
	}
}