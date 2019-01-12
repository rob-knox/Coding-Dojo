package com.codingdojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get the value for the query parameter
        String userName = request.getParameter("name");
        String language = request.getParameter("language");
        String location = request.getParameter("location");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        if (userName == "" || userName == null) {
        	out.write("<h1>Welcome!</h1>");
        } else {
        	out.write("<h1>Welcome, " + userName + "</h1>");
        }
        
        if (language == "" || language == null) {
        	out.write("<p>Your favorite language is: Unknown</p>");
        } else {
        	out.write("<p>Your favorite language is: " + language + "</p>");
        }
        
        if (location == "" || location == null) {
        	out.write("<p>Your hometown is: Unknown</p>");
        } else {
        	out.write("<p>Your hometown is: " + location + "</p>");
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
