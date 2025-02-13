import java.sql.*;
import java.util.Scanner;

public class prac6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sriyanshu"; // Change "testdb" to your database name
        String user = "root";  // Default XAMPP user
        String password = "";  // Default XAMPP password (empty)

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("\nConnected to the database!");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter an SQL query (or type 'exit' to quit):");
                String query = scanner.nextLine().trim();

                if (query.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program...");
                    break;
                }

                try (Statement stmt = conn.createStatement()) {
                    if (query.toLowerCase().startsWith("select")) {
                        ResultSet rs = stmt.executeQuery(query);
                        ResultSetMetaData metaData = rs.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        // Print column names
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-10s",metaData.getColumnName(i));
                        }
                        System.out.println("\n---------------------------------------------");

                        // Print rows
                        while (rs.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                System.out.printf("%-10s",rs.getString(i));
                            }
                            System.out.println();
                        }
                    } else {
                        int rowsAffected = stmt.executeUpdate(query);
                        System.out.println("Query executed successfully. Rows affected: " + rowsAffected);
                    }
                } catch (SQLException e) {
                    System.out.println("Error executing query: " + e.getMessage());
                }
            }

            // Close resources
            conn.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
