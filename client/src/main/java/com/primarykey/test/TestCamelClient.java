package com.primarykey.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.primarykey.client.TwitterAPI;
public class TestCamelClient {
	
   TwitterAPI twitterAPI = TwitterAPI.getTwitterAPIInstance("localhost", "8080");
	
   /**
    * Used for testing retweet.
    */
   @Test
   public void testRetweet() {
   String reTweetMessage =   twitterAPI.getRetweet();
        assertNotNull(reTweetMessage);
   }
   
   /**
	 * Used for testing  the search  tweets with the given string.
	 * @param searchString
	 * @return
	 */
   @Test
	public void  testSearchTweet() {
		String searchTweet =  twitterAPI.searchTweet("primrykey");
		 assertNotNull(searchTweet);
	}

	/**
	 * Used for testing the timeline of the logged in user.
	 * @return
	 */
   @Test
	public void testGetTimeLine() {
	   String timeLine =  twitterAPI.getTimeLine();
		assertNotNull(timeLine);
	}

	/**
	 * Used for testing the screen name of the logged in user.
	 * @return
	 */
   @Test
	public void  testGetScreenName() {
	   String screenName = "primarykeysjsu";
	   String screenNameFromAPI =  twitterAPI.getScreenName();
		assertEquals(screenNameFromAPI, screenName);
	}

	/**
	 * Used for testing the retweets of the logged in user.
	 * @return
	 */
   @Test
	public void  testGetRetweet() {
		String retweet =  twitterAPI.getRetweet();
		assertNotNull(retweet);
	}
  
	/**
	 * Used for testing the user category.
	 * @return
	 */
   @Test
	public void testUserCate() {
		String userCate =  twitterAPI.getUserCate();
		assertNotNull(userCate);
	}

	/**
	 * Used for testing the trends.
	 * @return
	 */
   @Test
	public void  testGetTrends() {
		String trends = twitterAPI.getTrends();
		assertNotNull(trends);
	}

	/**
	 * Used for testing the list of follower ids.
	 * @return
	 */
   @Test
	public void  testGetFollowerIds() {
	   String followersId =  twitterAPI.getFollowerIds();
		assertNotNull(followersId);
	}

	/**
	 * Used for testing save search.
	 * @return
	 */
   @Test
	public void  testGetSavedSearch() {
		String savedSearch =  twitterAPI.getSavedSearch();
		assertNotNull(savedSearch);
	}
}