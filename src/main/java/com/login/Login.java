package com.login;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.login.DataBaseCon;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")

public class Login extends HttpServlet {
	protected void doPost (HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		DataBaseCon dbc = new DataBaseCon();
		
		if (dbc.check(uname, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
		
	}

}
