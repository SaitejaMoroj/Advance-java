package JDBC_DataBaseConnectivity;
import java.sql.*;  // Step 1: Import JDBC classes (for Connection, Statement, ResultSet, etc.)

public class Data_Connections {
    public static void main(String[] args) {
        try {
            // Step 2: Load and register the JDBC driver
            // This line loads the MySQL JDBC driver class into memory.
            // It allows Java to communicate with the MySQL database.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish the connection to the database
            // Here, we specify:
            //  - URL of the database (protocol, host, port, and database name)
            //  - Username and password for authentication
            String url = "jdbc:mysql://localhost:3306/yourDatabaseName"; // Replace with your DB name
            String username = "root";        // Replace with your username
            String password = "yourPassword"; // Replace with your password

            // DriverManager.getConnection() returns a Connection object that links Java to the database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connected successfully!");

            // Step 4: Create a Statement object to send SQL queries to the database
            // Statement is used for executing static SQL queries.
            Statement st = con.createStatement();

            // Step 5: Execute an SQL query
            // executeQuery() is used when we expect a result set (like SELECT queries)
            // The query must be written inside double quotes.
            ResultSet rs = st.executeQuery("SELECT * FROM Students");

            // Step 6: Process the ResultSet
            // ResultSet represents a table of data returned by the SQL query.
            // rs.next() moves the cursor to the next row in the result.
            while (rs.next()) {
                // Here, we fetch columns using getXXX() methods.
                // Example: getInt(1) → first column, getString(2) → second column.
                System.out.println("Student ID   : " + rs.getInt(1));
                System.out.println("Student Name : " + rs.getString(2));
                System.out.println("--------------------------------");
            }

            // Step 7: Close all resources
            // It’s very important to close these objects to prevent memory leaks.
            rs.close();
            st.close();
            con.close();
            System.out.println("✅ Connection closed successfully!");

        } catch (Exception e) {
            // This block catches any exceptions (like SQL errors or ClassNotFound)
            e.printStackTrace();
        }
    }
}
