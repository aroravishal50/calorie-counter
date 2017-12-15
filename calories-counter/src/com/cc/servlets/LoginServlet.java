/**
 * File - Loginservlet.java
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
import javax.servlet.http.HttpSession;
import com.cc.dao.*;
import com.cc.helpers.Client;
import com.cc.helpers.FoodItems;
import com.cc.utilities.*;

public class LoginServlet extends HttpServlet{

	/*This servlet obtains the credentials entered by the user an verify's if the information entered matches what is stored
	 * in the database. If there is a match the user is logged into their profile else an error message is printed out onto the screen.
	 **/
	
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n= request.getParameter("username");  
        
        String p= Encryption.encrypt(request.getParameter("userpass"));  //stores encrypted password
        
        Client client = ClientDao.login(n, p);
        if(client != null){
            FoodItems cd = ClientDao.getOldCalories(client.getClientId());

        	HttpSession session = request.getSession(false);
            if (session!=null){
            	 session.setAttribute("name", client.getUserName());
            	 session.setAttribute("userID", client.getClientId());
            	 session.setAttribute("firstName", client.getFirstName());
            	 session.setAttribute("lastName", client.getLastName());
            	 session.setAttribute("totalCalories", cd.getTotalCalories());
            }
            response.sendRedirect("welcome.jsp");  
        } else {
        	out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
            rd.include(request,response);
        }

        out.close();  
    }  
} 