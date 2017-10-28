package com.primarykey.util;

import java.util.List;

import twitter4j.Category;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Twitter 4j API completely responsible for interacting with twitter 4j.
 * @author ravisha
 *
 */
public class TwitterUtil {

	private Twitter twitter = null;
	//private String retweet = null;
	String screenName = "primarykeysjsu";

	public TwitterUtil() {

		String consumerKeyStr = "v4JGV4NdGVjzl1yBARJQpNU9V";
		String consumerSecretStr = "PoT5hGzs7xABwoYW2ck2faiDaq7SG6gv9ctrOESYRmKPWQzYnG";
		String accessTokenStr = "916783602129543168-L8qcEHbBYEdD1czFqMznLCXz0l2qdha";
		String accessTokenSecretStr = "toS0piP5FfwyNZCh62zcUZJgUJqinxuyXkVwJvBKiWd6Z";
		System.setProperty("http.useSSL", "true");

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKeyStr)
				.setOAuthConsumerSecret(consumerSecretStr)
				.setOAuthAccessToken(accessTokenStr)
				.setOAuthAccessTokenSecret(accessTokenSecretStr);
		TwitterFactory factory = new TwitterFactory(cb.build());
		twitter = factory.getInstance();

	}

	public String getReTweet() {
		String retweet = null;
		System.out.println("Calling retweets..");
		try {
			ResponseList<Status> retweets = twitter.getRetweetsOfMe();
			for (Status b : retweets) {
				retweet = b.getText();
				System.out.println(b.getText());
				break;
			}
			System.out.println(retweets.size());
		} catch (TwitterException te) {
			te.printStackTrace();
			System.exit(-1);
		}

		return retweet;
	}

	public String searchTweet(String searchTweet) {
		Query query = new Query(searchTweet);
		boolean present = false;
		String searchTwitter = null;
		QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Status status : result.getTweets()) {
			searchTwitter = status.getText();
			if (searchTwitter.contains(searchTweet)) {
				present = true;
				break;
			}

		}
		if (present) {
			return searchTwitter;
		} else {
			return "No String  present";

		}

	}

	public String getTimeLine() {
		String timeLine = null;

		List<Status> statuses = null;

		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Status status : statuses) {
			System.out.println(status.getUser().getName() + ":"
					+ status.getText());
			timeLine = status.getText();
			break;

		}
		return timeLine;
	}

	public String getScreenName() {
		String screenName = null;

		try {
			screenName = twitter.getScreenName();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return screenName;
	}

	public String getFriendsIds() {
		String friendId = null;
		IDs ids = null;

		try {
			ids = twitter.getFriendsIDs(screenName, -1);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (long id : ids.getIDs()) {
			friendId = id + "";
			break;
		}

		return friendId;
	}

	public String getFollowersIds() {
		String followerId = null;
		IDs ids = null;

		try {
			ids = twitter.getFollowersIDs(screenName, -1);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (long id : ids.getIDs()) {
			followerId = id + "";
			break;
		}

		return followerId;
	}

	public String getSuggestedUserCategories() {
		ResponseList<Category> categories = null;
		String categoryName = null;

		try {
			categories = twitter.getSuggestedUserCategories();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Category category : categories) {
			System.out.println(category.getName() + ":" + category.getSlug());
			categoryName = category.getName();
			break;
		}
		return categoryName;
	}

	public String getAvaialbleTrends() {

		String trend = null;
		ResponseList<Location> locations = null;
		try {
			locations = twitter.getAvailableTrends();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Location location : locations) {
			trend = location.getName() + " (woeid:" + location.getWoeid() + ")";
			break;
		}
		return trend;

	}

	public String getSavedSearches() {

		String savedSear = null;
		List<SavedSearch> savedSearches = null;
		try {
			savedSearches = twitter.getSavedSearches();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (SavedSearch savedSearch : savedSearches) {
			savedSear = savedSearch.getName();
			break;
		}
		return savedSear;

	}

}
