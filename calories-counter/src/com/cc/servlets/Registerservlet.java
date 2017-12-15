/**
 * File - Registerservlet.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 **/
package com.cc.servlets;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.dao.ClientDao;
import com.cc.helpers.Client;
import com.cc.helpers.sendEmail;
import com.cc.servlets.Registerservlet;
import com.cc.utilities.*;

/*
 * This class is responsible to create a session for the user to log in. 
 */
public class Registerservlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Client client;

		String username = request.getParameter("username");
		String password = Encryption.encrypt(request.getParameter("userpass")); 
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		client = ClientDao.register(username, password, firstName, lastName, email, gender, age);

		if(client != null){
			HttpSession session = request.getSession(false);
			if (session!=null){
				session.setAttribute("username", client.getUserName());
				session.setAttribute("client_id", client.getClientId());
				session.setAttribute("firstName", client.getFirstName());
				session.setAttribute("lastName", client.getLastName());

				try {
					int temp = tempPwd();
					ClientDao.temPwd(username, temp);
					sendEmail.send(email, "Temporay Password for Login", Integer.toString(temp));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect("verifyEmail.jsp"); 
		} else {
			out.print("<p style=\"color:red\">Email already exists</p>"); 
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
			rd.include(request,response);
		}
	}

	public static int tempPwd() {
		int min = 10000;
		int max = 99999;
		int randomNum = min + (int)(Math.random() * max); 
		return randomNum;
	}
} //End Registerservlet class