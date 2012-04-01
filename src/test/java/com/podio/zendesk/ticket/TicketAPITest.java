package com.podio.zendesk.ticket;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

import com.podio.integration.zendesk.APIFactory;
import com.podio.integration.zendesk.ticket.Ticket;
import com.podio.integration.zendesk.ticket.TicketAPI;
import com.podio.integration.zendesk.ticket.TicketPriority;
import com.podio.integration.zendesk.ticket.TicketStatus;
import com.podio.integration.zendesk.ticket.TicketType;
import com.podio.integration.zendesk.ticket.TicketVia;

public class TicketAPITest {

	private static TicketAPI getAPI() throws IOException {
		return APIFactory.getFromConfig().getTicketAPI();
	}

	@Test
	public void getTicket() throws IOException {
		Ticket ticket = getAPI().getTicket(933);

		System.out.println(ticket.getAssignedAt().getZone());
		Assert.assertEquals(ticket.getAssignedAt(), new DateTime(2010, 11, 24,
				20, 42, 51, 0, DateTimeZone.UTC));
		Assert.assertEquals(ticket.getAssigneeId().intValue(), 16080839);
		Assert.assertEquals(ticket.getCreatedAt(), new DateTime(2010, 11, 24,
				20, 1, 34, 0, DateTimeZone.UTC));
		Assert.assertEquals(ticket.getSubject(), "");
		Assert.assertTrue(ticket.getDescription().contains("Popup:"));
		Assert.assertEquals(ticket.getExternalId(), null);
		Assert.assertEquals(ticket.getGroupId(), 1807);
		Assert.assertEquals(ticket.getId(), 933);
		Assert.assertEquals(ticket.getLinkings().size(), 0);
		Assert.assertEquals(ticket.getPriority(), TicketPriority.NONE);
		Assert.assertEquals(ticket.getSubmitterId(), 21480147);
		Assert.assertEquals(ticket.getStatus(), TicketStatus.CLOSED);
		Assert.assertEquals(ticket.getStatusUpdatedAt(), new DateTime(2010, 12,
				1, 12, 0, 28, 0, DateTimeZone.UTC));
		Assert.assertEquals(ticket.getRequesterId(), 21480147);
		Assert.assertEquals(ticket.getType(), TicketType.INCIDENT);
		Assert.assertEquals(ticket.getUpdatedAt(), new DateTime(2010, 12, 1,
				12, 0, 29, 0, DateTimeZone.UTC));
		Assert.assertEquals(ticket.getVia(), TicketVia.DROPBOX);
		Assert.assertEquals(ticket.getCurrentTags().size(), 2);
		Assert.assertEquals(ticket.getCurrentTags().get(0), "betafeedback");
		Assert.assertEquals(ticket.getCurrentTags().get(1), "question");
		Assert.assertEquals(ticket.getScore(), 0);
		Assert.assertEquals(ticket.getComments().size(), 4);
		Assert.assertTrue(ticket.getComments().get(0).getValue()
				.contains("Popup:"));
		Assert.assertEquals(
				ticket.getComments().get(0).getAttachments().size(), 0);
		Assert.assertEquals(ticket.getComments().get(0).getAuthorId(), 21480147);
		Assert.assertEquals(ticket.getComments().get(0).getCreatedAt(),
				new DateTime(2010, 11, 24, 20, 01, 34, 0, DateTimeZone.UTC));
		Assert.assertEquals(ticket.getComments().get(0).getVia(),
				TicketVia.DROPBOX);
		Assert.assertEquals(
				ticket.getComments().get(1).getAttachments().size(), 1);
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getContentType(), "image/png");
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getFilename(), "image001.png");
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getToken(), "yxzdd3cdcehv6zs");
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getCreatedAt(), new DateTime(2010, 11, 24, 20, 14, 30, 0,
				DateTimeZone.UTC));
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getId(), 12628519);
		Assert.assertEquals(ticket.getComments().get(1).getAttachments().get(0)
				.getSize(), 36057);
		Assert.assertEquals(
				ticket.getComments().get(1).getAttachments().get(0).getUrl()
						.toString(),
				"https://hoist.zendesk.com/attachments/token/yxzdd3cdcehv6zs/?name=image001.png");
		Assert.assertEquals(ticket.getEntries().size(), 1);
		Assert.assertEquals(ticket.getEntries().get(0).getFieldId(), 87154);
		Assert.assertEquals(ticket.getEntries().get(0).getValue(), "question");
	}

	@Test
	public void getTickets() throws IOException {
		List<Ticket> tickets = getAPI().getTickets(47845, 1);

		Assert.assertEquals(tickets.size(), 30);
	}
}
