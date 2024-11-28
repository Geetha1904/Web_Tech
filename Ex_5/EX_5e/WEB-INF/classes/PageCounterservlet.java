import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PageCounterServlet")
public class PageCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int visitCount;

    @Override
    public void init() throws ServletException {
        // Initialize the visit count
        visitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Increment the visit count
        visitCount++;

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the counter and the taco shop welcome page
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Taco Shop - Page Counter</title>");
        out.println("<style>");
        out.println("body {");
        out.println("  background-image: url('background.jpg');"); // Add your image file
        out.println("  background-size: cover;");
        out.println("  font-family: Arial, sans-serif;");
        out.println("  color: white;");
        out.println("  text-align: center;");
        out.println("  padding: 50px;");
        out.println("}");
        out.println("h1 {");
        out.println("  font-size: 50px;");
        out.println("  margin-bottom: 20px;");
        out.println("}");
        out.println("p {");
        out.println("  font-size: 20px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Taco Shop!</h1>");
        out.println("<p>Thank you for visiting our page.</p>");
        out.println("<p><b>Page Visits:</b> " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
