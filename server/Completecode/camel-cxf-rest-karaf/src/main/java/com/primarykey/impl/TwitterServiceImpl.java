package com.primarykey.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.primarykey.api.TwitterService;
import com.primarykey.util.TwitterUtil;

/**
 * Service impl which will have the actual implemetaiton. 
 * @author ravisha
 *
 */

@Path("/twitter/")
@Consumes(value = "application/xml,application/json,text/plain")
@Produces(value = "application/xml,application/json")
public class TwitterServiceImpl implements TwitterService {

	TwitterUtil twitterUtil = new TwitterUtil();

	@Override
	public String getTweet(int temp) {
		String tweet = twitterUtil.getTimeLine();
		return tweet;

	}

	@Override
	public String searchTweet(String searchTweet) {
		return twitterUtil.searchTweet(searchTweet);

	}

	@Override
	public String getTimeLine() {
		return twitterUtil.getTimeLine();
	}

	@Override
	public String getScreenName() {
		return twitterUtil.getScreenName();
	}

	@Override
	public String getReTweet() {
		return twitterUtil.getReTweet();
	}

	@Override
	public String getSuggestedUserCategories() {
		return twitterUtil.getSuggestedUserCategories();
	}

	@Override
	public String getAvaialbleTrends() {
		return twitterUtil.getAvaialbleTrends();
	}

	@Override
	public String getFollowersIds() {
		return twitterUtil.getFollowersIds();
	}

	@Override
	public String getSavedSearches() {
		return twitterUtil.getSavedSearches();
	}

}
