import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomepage")
public class welcomepage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String username = (String) request.getSession().getAttribute("username");

        // Use try-with-resources to ensure that resources are closed
        try (Connection con = getDBConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO LoginUserData (content, username) VALUES (?, ?)")) {
            ps.setString(1, content);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Consider logging this exception or rethrowing it as a custom exception
            throw new ServletException("Database error", e);
        }
    }

    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Project";
        String Dausername = "root";
        String Dapassword = "prasad143tara+asha";
        return DriverManager.getConnection(url, Dausername, Dapassword);
    }
}
