/*  
 * File - VerifyServlet.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 */

package com.cc.servlets;

import java.io.IOException;  
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cc.dao.*;
import com.cc.helpers.Client;

public class VerifyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/*
	 *This servlet is used to verify the email of the user after registering as security purposes. If the right credentials are entered
	 *the user is directed to the login page else the user is given an error message allowing another attempt.
	 * 
	 **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		String verification_code= request.getParameter("verification_code");  
		String email= request.getParameter("email"); 


		Client client = ClientDao.verifyEmail(verification_code, email);

		if(client != null && verification_code.equals(client.getverification_code())){
			ClientDao.flipVerify(email);
			response.sendRedirect("login.jsp"); 
		} else {
			out.print("<p style=\"color:red\">Sorry username or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			rd.include(request,response);
		}

		out.close();  
	}  
} 