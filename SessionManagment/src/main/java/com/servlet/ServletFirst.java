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

@WebServlet("/SessionManagment/ServletFirst")
public class ServletFirst extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servletl</title>");
        out.println("</head>");
        out.println("<body>");

        String name = request.getParameter("name");
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(10);
        session.setAttribute("username", name);

        out.println("<h1>Hello " + name + " welcome to my website...</h1>");
        out.println("<h2><a href='SecondServlet'>Go to Servlet 2</h2>");
//        Cookie cookie=new Cookie("hello", name);
//        response.addCookie(cookie);

        out.println("</body>");
        out.println("</html>");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
