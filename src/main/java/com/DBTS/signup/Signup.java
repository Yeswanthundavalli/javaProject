package com.DBTS.signup;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Call the method to insert data into the database
        DataBaseToSignUp db = new DataBaseToSignUp();
        db.insertData(username, password);

        // You can redirect to a success page or display a message here
        response.sendRedirect("Login.jsp");
    }
}
