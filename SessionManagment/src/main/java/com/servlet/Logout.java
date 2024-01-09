package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;



/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet Servletl</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        HttpSession session=request.getSession();
	       
	        String name=(String) session.getAttribute("username");
	        session.removeAttribute(name);
	       // session.invalidate();
	        
			String[] msg = {"Logout Successfully", "success", "alert-success"};
			session.setAttribute("msg", msg);
			response.sendRedirect("NewFile.html");
	        
	     

	        out.println("</body>");
	        out.println("</html>");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

}
