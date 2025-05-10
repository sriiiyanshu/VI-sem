<%@ page import="java.sql.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // JDBC Connection Setup
    String url = "jdbc:mysql://localhost:3306/AJPprac10";
    String dbUser = "college";
    String dbPass = "password";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure MySQL JDBC Driver is in classpath
        conn = DriverManager.getConnection(url, dbUser, dbPass);

        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);

        rs = stmt.executeQuery();

        if (rs.next()) {
            // Login successful
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.jsp");
        } else {
            // Invalid login
            response.sendRedirect("login.jsp?error=invalid");
        }

    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
