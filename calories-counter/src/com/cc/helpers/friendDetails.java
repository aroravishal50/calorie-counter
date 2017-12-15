/**
 * File - friendDetails.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.helpers;
/*
 * This class's functionality is to set the details of a friend of our clients.
 */
public class friendDetails {

	private String friendsFirstName;
	private String friendsLastName;
	private String friendsEntryDate;
	private String friendsTotalCalories;
	private String friendsFoodItems;

	public String getfriendsFirstName() {
		return friendsFirstName;
	}

	public void setfriendsFirstName(String friendsFirstName) {
		this.friendsFirstName = friendsFirstName;
	}

	public String getfriendsLastName() {
		return friendsLastName;
	}

	public void setfriendsLastName(String friendsLastName) {
		this.friendsLastName = friendsLastName;
	}

	public String getfriendsEntryDate() {
		return friendsEntryDate;
	}

	public void setfriendsEntryDate(String friendsEntryDate) {
		this.friendsEntryDate = friendsEntryDate;
	}

	public String getfriendsTotalCalories() {
		return friendsTotalCalories;
	}

	public void setfriendsTotalCalories(String friendsTotalCalories) {
		this.friendsTotalCalories = friendsTotalCalories;
	}

	public String getfriendsFoodItems() {
		return friendsFoodItems;
	}

	public void setfriendsFoodItems(String friendsFoodItems) {
		this.friendsFoodItems = friendsFoodItems;
	}
}