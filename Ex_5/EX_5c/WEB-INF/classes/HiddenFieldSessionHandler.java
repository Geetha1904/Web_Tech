import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HiddenFieldSessionHandler")
public class HiddenFieldSessionHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get order details from the form
        String tacoType = request.getParameter("tacoType");
        String quantity = request.getParameter("quantity");

        response.setContentType("text/html");
        response.getWriter().println("<h2>Passing data using Hidden Fields</h2>");
        response.getWriter().println("<form action='HiddenFieldSessionHandler' method='post'>");
        response.getWriter().println("<input type='hidden' name='tacoType' value='" + tacoType + "'>");
        response.getWriter().println("<input type='hidden' name='quantity' value='" + quantity + "'>");
        response.getWriter().println("<button type='submit' name='action' value='retrieve'>View Order</button>");
        response.getWriter().println("</form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("HiddenFieldSessionHandler");
    }

    protected void doPostForRetrieve(HttpServletRequest request, HttpServletResponse response) 
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
