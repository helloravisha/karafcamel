package com.primarykey.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.primarykey.client.TwitterAPI;
import com.primarykey.constants.UIConstants;

/**
 * This the main screen where we are showing all the required buttons which maps to each rest API  that we 
 * are exposing as part of this project.
 * @author ravisha
 *
 */
public class TwitterScreen extends JFrame implements ActionListener {

	private JButton showRetweet;
	private JButton showScreenName;
	private JButton showTimeLine;
	private JButton suggestedUserCate;
	private JButton showTrends;
	private JButton followerIds;
	private JButton savedSearch;
	private SearchScreen searchScreen;

	/**
	 * Invoking the single instance of my custom Twitter API.
	 */
	TwitterAPI twitterAPI = TwitterAPI.getTwitterAPIInstance("localhost", "8080");

	public TwitterScreen() {

		showRetweet = new JButton(UIConstants.SHOW_RETWEET);
		showScreenName = new JButton(UIConstants.SHOW_SCREEN_NAME);
		showTimeLine = new JButton(UIConstants.SHOW_TIME_LINE);
		suggestedUserCate = new JButton(UIConstants.SHOW_USER_CATE);
		showTrends = new JButton(UIConstants.SHOW_TRENDS);
		followerIds = new JButton(UIConstants.SHOW_FOLLOWER_IDS);
		savedSearch = new JButton(UIConstants.SHOW_SAVED_SEARCH);
		searchScreen = new SearchScreen(twitterAPI);
		
		add(showRetweet);
		add(showScreenName);
		add(showTimeLine);
		add(searchScreen);
		add(suggestedUserCate);
		add(showTrends);
		add(followerIds);
		add(savedSearch);

		setLayout(new GridLayout(2, 4));

		showRetweet.addActionListener(this);
		showScreenName.addActionListener(this);
		showTimeLine.addActionListener(this);
		suggestedUserCate.addActionListener(this);
		showTrends.addActionListener(this);
		followerIds.addActionListener(this);
		savedSearch.addActionListener(this);

		setSize(800, 300);
		setVisible(true);
		setTitle("Twitter-Camel-Karaf Integration");
	}

	/**
	 * Main method which invokes the  client.
	 * @param args
	 */
	public static void main(String[] args) {

		new TwitterScreen();
	}

	/**
	 * This method based on the button click will trigger the required api and show
	 * the result on the dialog box.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String operation = e.getActionCommand();
		if (UIConstants.SHOW_RETWEET.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getRetweet());
		} else if (UIConstants.SHOW_SCREEN_NAME.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getScreenName());
		} else if (UIConstants.SHOW_TIME_LINE.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getTimeLine());
		} else if (UIConstants.SHOW_USER_CATE.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getUserCate());
		} else if (UIConstants.SHOW_TRENDS.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getTrends());
		} else if (UIConstants.SHOW_FOLLOWER_IDS.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getFollowerIds());
		} else if (UIConstants.SHOW_SAVED_SEARCH.equals(operation)) {
			JOptionPane.showMessageDialog(this, twitterAPI.getSavedSearch());
		}
	}

}
