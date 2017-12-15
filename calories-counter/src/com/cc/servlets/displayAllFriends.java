/**
 * File - displayAllFriends.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * **/

package com.cc.servlets;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.dao.ClientDao;
import com.cc.helpers.friendDetails;

/**
 * Servlet implementation class searchAddFriend
 */
@WebServlet("/displayAllFriends")

public class displayAllFriends extends HttpServlet {

	/**
	 * Displays all friends from database
	 */
	private static final long serialVersionUID = 1L;

	/*Displays all friends first name, last name, food items and total calories
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		friendDetails fd = ClientDao.displayAllFriends((String)session.getAttribute("userID"));
		
		if (fd != null) {
			if (session != null) {
				session.setAttribute("friendsFirstName", fd.getfriendsFirstName());
				session.setAttribute("friendsLastName", fd.getfriendsLastName());
				session.setAttribute("friendsFoodItems", fd.getfriendsFoodItems());
				session.setAttribute("friendsTotalCalories", fd.getfriendsTotalCalories());

			}
			response.sendRedirect("viewAllFriends.jsp");
		}
	}
}
