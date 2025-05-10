import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
Cookie[] cookies = request.getCookies(); // Retrieve all cookies
String userName = "Guest"; // Default value
if (cookies != null) {
for (Cookie cookie : cookies) {
if (cookie.getName().equals("username")) {
userName = cookie.getValue();
break;
} }
}
out.println("<h3>Welcome, " + userName + "!</h3>");
}}