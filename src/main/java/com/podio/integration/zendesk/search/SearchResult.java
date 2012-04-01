package com.podio.integration.zendesk.search;

import java.util.List;

import com.podio.integration.zendesk.ticket.Ticket;

public class SearchResult {

	private int count;
	
	private List<Ticket> tickets;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
}
