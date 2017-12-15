/**
 * File - SearchFriend.java 
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.dao.ClientDao;
import com.cc.helpers.Client;
import com.cc.utilities.Encryption;

/**
 * Servlet implementation class searchAddFriend
 */
@WebServlet("/searchAddFriend")
/*
 * This classe's function is to use to allow User A to search for other users in the database and allows User B to see the profile of User A.
 */
public class SearchFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		String userName= request.getParameter("friendSearch");  

		Client client = ClientDao.searchFriend(userName);
		if(client != null){
			HttpSession session = request.getSession(false);
			if (session!=null){
				session.setAttribute("usernameFriend", client.getFriend());

			}
			response.sendRedirect("addFriends.jsp");  
		} else {
			out.print("<p style=\"color:red\">Sorry username or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			rd.include(request,response);
		}

		out.close();  


	}

}
