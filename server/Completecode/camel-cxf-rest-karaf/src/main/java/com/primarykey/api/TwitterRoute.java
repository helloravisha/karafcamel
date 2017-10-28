package com.primarykey.api;

import org.apache.camel.builder.RouteBuilder;

/**
 * All the required routes are configured here.
 * @author ravisha
 *
 */
public class TwitterRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(
				"cxfrs:http://localhost:8080?resourceClasses=com.primarykey.api.TwitterRestService&bindingStyle=SimpleConsumer")
		// call the route based on the operation invoked on the REST web service
				.toD("direct:${header.operationName}");

		// routes that implement the REST services
		from("direct:getTwitter").bean("twitterService",
				"getTwitter(${header.id})");

		// routes that implement the REST services
		from("direct:searchTwitter").bean("twitterService",
				"searchTwitter(${header.id})");

		// routes that implement the REST time line services
		from("direct:getTimeLine").bean("twitterService", "getTimeLine()");

		from("direct:getScreenName").bean("twitterService", "getScreenName()");

		from("direct:getReTweet").bean("twitterService", "getReTweet()");

		from("direct:getSuggestedUserCategories").bean("twitterService",
				"getSuggestedUserCategories()");

		from("direct:getAvaialbleTrends").bean("twitterService",
				"getAvaialbleTrends()");

		from("direct:getAvaialbleTrends").bean("twitterService",
				"getAvaialbleTrends()");

		from("direct:getFollowersIds").bean("twitterService",
				"getFollowersIds()");

		from("direct:getSavedSearches").bean("twitterService",
				"getSavedSearches()");

	}
}
