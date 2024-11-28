import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieSessionHandler")
public class CookieSessionHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get order details from the form
        String tacoType = request.getParameter("tacoType");
        String quantity = request.getParameter("quantity");

        // Store order details in cookies
        Cookie tacoCookie = new Cookie("tacoType", tacoType);
        Cookie quantityCookie = new Cookie("quantity", quantity);
        tacoCookie.setMaxAge(3600); // 1 hour expiration
        quantityCookie.setMaxAge(3600); // 1 hour expiration
        response.addCookie(tacoCookie);
        response.addCookie(quantityCookie);

        response.setContentType("text/html");
        response.getWriter().println("<h2>Order stored using Cookies!</h2>");
        response.getWriter().println("<a href='CookieSessionHandler?action=retrieve'>View Order</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("retrieve".equals(action)) {
            Cookie[] cookies = request.getCookies();
            String tacoType = "None";
            String quantity = "0";

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("tacoType".equals(cookie.getName())) {
                        tacoType = cookie.getValue();
                    } else if ("quantity".equals(cookie.getName())) {
                        quantity = cookie.getValue();
                    }
                }
            }

            response.setContentType("text/html");
            response.getWriter().println("<h2>Your Taco Order:</h2>");
            response.getWriter().println("<p>Taco Type: " + tacoType + "</p>");
            response.getWriter().println("<p>Quantity: " + quantity + "</p>");
        }
    }
}
