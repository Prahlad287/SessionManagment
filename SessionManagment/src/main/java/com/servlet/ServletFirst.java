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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.ConnectionProvider;

@WebServlet("/ServletFirst1")
public class ServletFirst extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Servletl</title>");
		out.println("</head>");
		out.println("<body>");

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		String email = request.getParameter("email");
		String mobile_no = request.getParameter("mobile_no");
		String gender = request.getParameter("gender");
//		getServletName();
//		getInitParameter(name);
//		getInitParameterNames();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		session.setAttribute("username", name);

		out.println("<h1>Hello " + name + " welcome to my website...</h1>");
		out.println("<h2><a href='SecondServlet'>Go to Servlet 2</h2>");
//        Cookie cookie=new Cookie("hello", name);
//        response.addCookie(cookie);

		Connection connection = ConnectionProvider.getConnection();
		String queryString = "Create Table Data (Name varchar(90),Address varchar(90), Email varchar(90),Mobile varchar(90),Gender varchar(90))";
		String query = "insert into Data values(?,?,?,?,?)";
		try {
			Statement smt = connection.createStatement();
//			if (smt.execute(queryString)) {
//				System.out.println("Table created");
//			}else {
//				System.out.println("Already");
//			}
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, address);
			psmt.setString(3, email);
			psmt.setString(4, mobile_no);
			psmt.setString(5, gender);
			int update = psmt.executeUpdate();
			if (update > 0) {
				System.out.println("update success");
				out.println("<h1>Hello " + name + " Data Saved Successfully</h1>");
			} else {
				System.out.println("not update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
