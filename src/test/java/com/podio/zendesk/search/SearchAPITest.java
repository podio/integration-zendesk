package com.podio.zendesk.search;

import java.io.IOException;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import com.podio.integration.zendesk.APIFactory;
import com.podio.integration.zendesk.search.SearchAPI;
import com.podio.integration.zendesk.search.SearchResult;

public class SearchAPITest {

	private static SearchAPI getAPI() throws IOException {
		return APIFactory.getFromConfig().getSearchAPI();
	}

	@Test
	public void search() throws IOException {
		SearchResult result = getAPI().search(
				Collections.singletonMap("query", "status:sovled"));
		Assert.assertTrue(result.getCount() > 1);
	}
}
