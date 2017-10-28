package com.primarykey.util;

/**
 * This interface has to be implemented by any rest client that comes into the system.
 * @author ravisha
 *
 */
public interface TwitterRestInterface {

	String searchTweet(String searchString);

	String getTimeLine();

	String getReTweets();

	String getScreenName();

	String getSuggestedUsersCat();

	String getTrends();

	String getFollowers();

	String getSavedSearch();

}
