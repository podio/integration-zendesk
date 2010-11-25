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

		Assert.assertEquals(ticket.getAssignedAt(), new DateTime(2010, 11, 24,
				21, 42, 51, 0));
		Assert.assertEquals(ticket.getAssigneeId(), 16080839);
		Assert.assertEquals(ticket.getCreatedAt(), new DateTime(2010, 11, 24,
				21, 1, 34, 0));
		Assert.assertEquals(ticket.getSubject(), "");
		Assert.assertTrue(ticket.getDescription().contains("Popup:"));
		Assert.assertEquals(ticket.getExternalId(), null);
		Assert.assertEquals(ticket.getGroupId(), 1807);
		Assert.assertEquals(ticket.getId(), 933);
		Assert.assertEquals(ticket.getLinkings().size(), 0);
		Assert.assertEquals(ticket.getPriority(), TicketPriority.NONE);
		Assert.assertEquals(ticket.getSubmitterId(), 21480147);
		Assert.assertEquals(ticket.getStatus(), TicketStatus.PENDING);
		Assert.assertEquals(ticket.getStatusUpdatedAt(), new DateTime(2010, 11,
				24, 21, 42, 51, 0));
		Assert.assertEquals(ticket.getRequesterId(), 21480147);
		Assert.assertEquals(ticket.getType(), TicketType.INCIDENT);
		Assert.assertEquals(ticket.getUpdatedAt(), new DateTime(2010, 11, 24,
				21, 42, 51, 0));
		Assert.assertEquals(ticket.getVia(), TicketVia.DROPBOX);
		Assert.assertEquals(ticket.getCurrentTags().size(), 2);
		Assert.assertEquals(ticket.getCurrentTags().get(0), "betafeedback");
		Assert.assertEquals(ticket.getCurrentTags().get(1), "question");
		Assert.assertEquals(ticket.getScore(), 32);
		Assert.assertEquals(ticket.getComments().size(), 3);
		Assert.assertEquals(ticket.getEntries().size(), 1);
		Assert.assertEquals(ticket.getEntries().get(0).getFieldId(), 87154);
		Assert.assertEquals(ticket.getEntries().get(0).getValue(), "question");
	}
}
