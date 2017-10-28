package com.primarykey.api;

/**
 * Defines the list of interfaces.
 * @author ravisha
 *
 */
public interface TwitterService {

	String getTweet(int orderId);

	String searchTweet(String searchTweet);

	String getTimeLine();

	String getScreenName();

	String getReTweet();

	String getSuggestedUserCategories();

	String getAvaialbleTrends();

	String getFollowersIds();

	String getSavedSearches();

}