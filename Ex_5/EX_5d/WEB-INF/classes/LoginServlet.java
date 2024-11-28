@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT id FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", resultSet.getInt("id"));
                session.setAttribute("username", username);

                response.sendRedirect("order.html");
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Invalid credentials. Try again.</h2>");
                out.println("<a href='login.html'>Back to Login</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
