package com.primarykey.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * This is a utility class, which makes use of Jersey rest API to act as a client and invoke the
 * rest service exposed on karaf container.
 * @author ravisha
 *
 */
public class JerseyRestClient implements TwitterRestInterface{

	private Client client = null;
	private String hostRestURLPrefix = null;

	public JerseyRestClient(String hostName, String port) {
		this.client = Client.create();
		this.hostRestURLPrefix = "http://" + hostName + ":" + port
				+ "/twitter/";
	}

	@Override
	public String searchTweet(String searchString) {
		WebResource webResource = client.resource(hostRestURLPrefix + "search/"
				+ searchString);
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE"
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getTimeLine() {
		WebResource webResource = client.resource(hostRestURLPrefix
				+ "timeline");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE"
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getReTweets() {
		WebResource webResource = client
				.resource(hostRestURLPrefix + "retweet");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getScreenName() {
		WebResource webResource = client.resource(hostRestURLPrefix
				+ "screenname");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getSuggestedUsersCat() {
		WebResource webResource = client.resource(hostRestURLPrefix
				+ "usercategories");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getTrends() {
		WebResource webResource = client.resource(hostRestURLPrefix + "trends");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getFollowers() {
		WebResource webResource = client.resource(hostRestURLPrefix
				+ "followerids");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

	@Override
	public String getSavedSearch() {
		WebResource webResource = client.resource(hostRestURLPrefix
				+ "savedSearch");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("HTTP ERROR RESPONSE CODE : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		return output;
	}

}
