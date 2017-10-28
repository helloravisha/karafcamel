package com.primarykey.client;

import com.primarykey.util.JerseyRestClient;
import com.primarykey.util.TwitterClientFactory;
import com.primarykey.util.TwitterRestInterface;




/**
 * This is a singleton class which is used to invoke the twitter rest API  , exposed on karaf container.
 * This class can decide to use which rest client API  by passing the required constant to the Twitter client
 * factory. 
 * @author ravisha
 *
 */
public class TwitterAPI {
	
	
	private static TwitterRestInterface restClient = null;
	private static  TwitterAPI  twitterAPI = null;
	
	/**
	 * Just changing this parameter , can switch the complete API from rest to some thing else.
	 * Factory design pattern is used to achieve this.
	 */
	private static String REST_CLIENT_API = "JERSEY_REST_CLIENT";
	
	/**
	 * Private constructor to make use use of singleton design pattern.
	 */
	private TwitterAPI(){
		
	}
	
	public static TwitterAPI  getTwitterAPIInstance(String hostName, String portNumber){
		if (twitterAPI == null ){
		    restClient = TwitterClientFactory.getTwitterRestInterface(REST_CLIENT_API, hostName, portNumber);
		    twitterAPI = new TwitterAPI();
		}
		return twitterAPI;
		
	}

	
	/**
	 * Used for searching the tweets with the given string.
	 * @param searchString
	 * @return
	 */
	public String searchTweet(String searchString) {
		return restClient.searchTweet(searchString);
	}

	/**
	 * Used for getting the timeline of the logged in user.
	 * @return
	 */
	public String getTimeLine() {
		return restClient.getTimeLine();
	}

	/**
	 * Used for getting the screen name of the logged in user.
	 * @return
	 */
	public String getScreenName() {
		return restClient.getScreenName();
	}

	/**
	 * Used for getting the retweets of the logged in user.
	 * @return
	 */
	public String getRetweet() {
		return restClient.getReTweets();
	}
   
	/**
	 * Used for getting the user category.
	 * @return
	 */
	public String getUserCate() {
		return restClient.getSuggestedUsersCat();
	}

	/**
	 * Used for getting the trends.
	 * @return
	 */
	public String getTrends() {
		return restClient.getTrends();
	}

	/**
	 * Used for getting the list of follower ids.
	 * @return
	 */
	public String getFollowerIds() {
		return restClient.getFollowers();
	}

	/**
	 * Used for getting save search.
	 * @return
	 */
	public String getSavedSearch() {
		return restClient.getSavedSearch();
	}

}
