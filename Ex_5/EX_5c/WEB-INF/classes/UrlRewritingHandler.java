import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UrlRewritingHandler")
public class UrlRewritingHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get order details from the form
        String tacoType = request.getParameter("tacoType");
        String quantity = request.getParameter("quantity");

        // Redirect with URL Rewriting
        response.sendRedirect("UrlRewritingHandler?action=retrieve&tacoType=" + tacoType + "&quantity=" + quantity);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("retrieve".equals(action)) {
            String tacoType = request.getParameter("tacoType");
            String quantity = request.getParameter("quantity");

            response.setContentType("text/html");
            response.getWriter().println("<h2>Your Taco Order:</h2>");
            response.getWriter().println("<p>Taco Type: " + tacoType + "</p>");
            response.getWriter().println("<p>Quantity: " + quantity + "</p>");
        }
    }
}
