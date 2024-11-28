import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int result = preparedStatement.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.println("<h2>Registration successful!</h2>");
                out.println("<a href='login.html'>Login Here</a>");
            } else {
                out.println("<h2>Registration failed. Try again.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
