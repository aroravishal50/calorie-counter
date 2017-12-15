/**
 * File - FoodItems.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.helpers;

/* 
 * This class has a bundle of getters and setters to store food items into the database. 
 */
public class FoodItems {

	private String food;
	private String totalCalories;

	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(String totalCalories) {
		this.totalCalories = totalCalories;
	}
}