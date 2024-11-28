import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletBill")
public class ServletBill extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int item1 = Integer.parseInt(request.getParameter("item1"));
        int item2 = Integer.parseInt(request.getParameter("item2"));
        int item3 = Integer.parseInt(request.getParameter("item3"));
        int item4 = Integer.parseInt(request.getParameter("item4"));
        int totalCost = (item1 * 5) + (item2 * 7) + (item3 * 4) + (item4 * 2);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Order Summary</h2>");
        out.println("<p>Taco: " + item1 + " x $5 = $" + (item1 * 5) + "</p>");
        out.println("<p>Burrito: " + item2 + " x $7 = $" + (item2 * 7) + "</p>");
        out.println("<p>Nachos: " + item3 + " x $4 = $" + (item3 * 4) + "</p>");
        out.println("<p>Soda: " + item4 + " x $2 = $" + (item4 * 2) + "</p>");
        out.println("<h3>Total Cost: $" + totalCost + "</h3>");
        out.println("<a href='orderform.html'>Back to Order Form</a>");
        out.println("</body></html>");
    }
}
