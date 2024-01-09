package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet Servletl</title>");
	        out.println("</head>");
	        out.println("<body>");

//	        Cookie[] cookies = request.getCookies();
//	        boolean f=false;
//	        String name="";
//	        if (cookies==null) {
//	        	 out.println("<h1>You are new user go to home page and submit your name..</h1>");
//			}else {
//				for (Cookie cookie : cookies) {
//					String tnameString=cookie.getName();
//					if (tnameString.equals("hello")) {
//						f=true;
//						name=cookie.getValue();
//					}
//				}
//			}
//	        if (f) {
//	        	out.println("<h1>Hello " + name + " welcome Back to my Servlet 2...</h1>");
//			}else {
//				out.println("<h1>You are new user go to home page and submit your name..</h1>");
//			}
	        
	        HttpSession session=request.getSession();
	        session.setMaxInactiveInterval(10);
	        String name=(String) session.getAttribute("username");
	        
	        
	        if (name!=null) {
	        	out.println("<h1>Hello " + name + " welcome Back to my Servlet 2.By HttpSession</h1>");
	        	out.println("<h1>Hello " + name + " Data Saved Successfully</h1>");
			}else {
				out.println("<h1>You are new user go to home page and submit your name..</h1>");
			}
	        
	        out.println("<h1><a href='Logout'>Logout</a></h1>");

	        out.println("</body>");
	        out.println("</html>");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

}
