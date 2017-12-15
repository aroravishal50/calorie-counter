/**
 * File - foodServlet.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * **/
package com.cc.servlets;

import java.io.IOException; 
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cc.dao.*;
import com.cc.helpers.FoodItems;


public class foodServlet extends HttpServlet {
	/**
	 * Displays all food items and post the selected items 
	 */
	private static final long serialVersionUID = 1L;
/* Gets all the food items in database
 * (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodItems client = ClientDao.getFoods();

		if (client != null) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.setAttribute("food", client.getFood());

			}
			response.sendRedirect("foodItems.jsp");
		}
	}
/*Posts the selected food items in database and getOldCalories to calculate
 * total calories
 * (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String foods = (String) session.getAttribute("food");
	
		
		String items[] = foods.split("x01");
		String foodKinds="";
		String foodKindsAppend ="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for (int i = 0; i < items.length; i++) {
			foodKinds = request.getParameter("food" + i);
			if ((foodKinds != null)&& !foodKinds.isEmpty()) {
			foodKindsAppend = (i+1) + " " + foodKindsAppend ;
			}
			else {
				foodKinds="";
			}
		}
		String itemsArr[] = foodKindsAppend.split(" ");
		  FoodItems food = null;
		if(itemsArr[0]!="" || !itemsArr[0].equals("")) {
            ClientDao.meal(itemsArr, (String)session.getAttribute("userID"));
             food = ClientDao.getCalories(itemsArr,(String)session.getAttribute("userID"));
		}
if (session != null) {
		
				
				if(itemsArr[0]!="" || !itemsArr[0].equals("")) {
					session.removeAttribute("totalCalories");
					session.setAttribute("totalCalories", food.getTotalCalories());
					

				}
				else {
					FoodItems food1 = ClientDao.getOldCalories((String)session.getAttribute("userID"));
					session.removeAttribute("totalCalories");
					session.setAttribute("totalCalories", food1.getTotalCalories());
					
				}
				
			
			response.sendRedirect("caloriesHistory.jsp");
		}

		out.close();
		}
	
}
