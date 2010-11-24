package com.podio.zendesk.ticket;

import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.podio.zendesk.TestUtil;

public class TicketAPITest {

	private static TicketAPI getAPI() throws IOException {
		return TestUtil.getAPIFactory().getTicketAPI();
	}

	@Test
	public void getTicket() throws IOException {
		Ticket ticket = getAPI().getTicket(933);

		Assert.assertEquals(ticket.getAssignedAt(), null);
		Assert.assertEquals(ticket.getAssigneeId(), 1);
		Assert.assertEquals(ticket.getAssigneeUpdatedAt(), new DateTime(2010,
				11, 24, 21, 59, 0, 0));
		Assert.assertEquals(ticket.getCreatedAt(), new DateTime(2010, 11, 24,
				21, 59, 0, 0));
		Assert.assertEquals(ticket.getSubject(), "");
		Assert.assertTrue(ticket.getDescription().contains("Popup:"));
		Assert.assertEquals(ticket.getExternalId(), "");
		Assert.assertEquals(ticket.getGroupId(), 1);
		Assert.assertEquals(ticket.getId(), 1);
		Assert.assertEquals(ticket.getLinkedId(), null);
		Assert.assertEquals(ticket.getPriority(), TicketPriority.NONE);
		Assert.assertEquals(ticket.getSubmitterId(), 1);
		Assert.assertEquals(ticket.getStatus(), TicketStatus.PENDING);
		Assert.assertEquals(ticket.getStatusUpdatedAt(), new DateTime(2010, 11,
				24, 21, 59, 0, 0));
		Assert.assertEquals(ticket.getRequesterId(), 1);
		Assert.assertEquals(ticket.getRequesterUpdatedAt(), new DateTime(2010,
				11, 24, 21, 59, 0, 0));
		Assert.assertEquals(ticket.getType(), TicketType.INCIDENT);
		Assert.assertEquals(ticket.getUpdatedAt(), new DateTime(2010, 11, 24,
				21, 59, 0, 0));
		Assert.assertEquals(ticket.getVia(), TicketViaType.WEB_FORM);
		Assert.assertEquals(ticket.getCurrentTags().size(), 0);
		Assert.assertEquals(ticket.getScore(), 1);
		Assert.assertEquals(ticket.getComments().size(), 1);
		Assert.assertEquals(ticket.getEntries().size(), 0);
	}
}
