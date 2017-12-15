/**
 * File - Friend.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.helpers;
/*
 * This class has methods to retrieve different clients and create friendships into our database.
 */
public class Friend {

	Client client;
	Client friend;

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getFriend() {
		return friend;
	}
	public void setFriend(Client friend) {
		this.friend = friend;
	}
}
