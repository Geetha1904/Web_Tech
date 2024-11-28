import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HttpSessionHandler")
public class HttpSessionHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get order details from the form
        String tacoType = request.getParameter("tacoType");
        String quantity = request.getParameter("quantity");

        // Store order details in HttpSession
        HttpSession session = request.getSession();
        session.setAttribute("tacoType", tacoType);
        session.setAttribute("quantity", quantity);

        response.setContentType("text/html");
        response.getWriter().println("<h2>Order stored in HttpSession!</h2>");
        response.getWriter().println("<a href='HttpSessionHandler?action=retrieve'>View Order</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("retrieve".equals(action)) {
            HttpSession session = request.getSession();
            String tacoType = (String) session.getAttribute("tacoType");
            String quantity = (String) session.getAttribute("quantity");

            response.setContentType("text/html");
            response.getWriter().println("<h2>Your Taco Order:</h2>");
            response.getWriter().println("<p>Taco Type: " + tacoType + "</p>");
            response.getWriter().println("<p>Quantity: " + quantity + "</p>");
        }
    }
}
