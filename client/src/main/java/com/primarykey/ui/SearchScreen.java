package com.primarykey.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.primarykey.client.TwitterAPI;
import com.primarykey.constants.UIConstants;

/**
 * Screen for holding the search screen options. this screen will be integration
 * to the main screen which is Twitter screen.
 * 
 * @author ravisha
 *
 */
public class SearchScreen extends JPanel implements ActionListener {

	private JTextField searchTxt = null;
	private JButton searchButton = null;
	private TwitterAPI twitterAPI = null;

	public SearchScreen(TwitterAPI twitterAPI) {
		this.twitterAPI = twitterAPI;
		searchTxt = new JTextField();
		searchButton = new JButton(UIConstants.SHOW_SEARCH_TWEET);
		add(searchTxt);
		add(searchButton);
		setLayout(new GridLayout(2, 1));
		searchButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String operation = e.getActionCommand();
		System.out.println("Entered action performed..");
		if ("Search Tweet".equals(operation)) {
           String text =  searchTxt.getText();
           System.out.println("Entered action performed.."+text.length());
			if (text.length() == 0 ) {
				JOptionPane
						.showMessageDialog(this,
								"Please enter some text above to search the twitter account.");
			} else {
				JOptionPane.showMessageDialog(this,
						twitterAPI.searchTweet(searchTxt.getText()));
			}
		}

	}
}
