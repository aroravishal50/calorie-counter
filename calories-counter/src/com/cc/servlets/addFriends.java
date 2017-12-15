/**
 * File - addFriends.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * **/

package com.cc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
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
@WebServlet("/addFriends")

public class addFriends extends HttpServlet {

	/**
	 * Adds the friend in database
	 */
	private static final long serialVersionUID = 1L;
/*
 * Calls the add friend method and adds the friend using usernameFriend stored in session
 * (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(true);
        String usernameFriend= (String) session.getAttribute("usernameFriend");
        String userId= (String) session.getAttribute("userID");
        Client client = ClientDao.addFriend(usernameFriend,userId);
        response.sendRedirect("displayAllFriends");  
        if(client == null){
            	out.print("<p style=\"color:red\">Sorry friend can't be added</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
                rd.include(request,response);   
            
            response.sendRedirect("displayAllFriends");  
        } 

        out.close();  
    
	
	
	
	
	
	
	}

}
