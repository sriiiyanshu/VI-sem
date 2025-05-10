import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
// Creating a new cookie
Cookie userCookie = new Cookie("username", "Sriyanshu");

userCookie.setMaxAge(60 * 60); // 1 hour
response.addCookie(userCookie);

out.println("<h3>Cookie has been set!</h3>");
}
}