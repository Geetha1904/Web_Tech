@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String tacoType = request.getParameter("tacoType");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (userId == null) {
            response.sendRedirect("login.html");
            return;
        }

        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO orders (user_id, taco_type, quantity) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, tacoType);
            preparedStatement.setInt(3, quantity);

            int result = preparedStatement.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.println("<h2>Order placed successfully!</h2>");
                out.println("<a href='order.html'>Place Another Order</a>");
            } else {
                out.println("<h2>Order failed. Try again.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
