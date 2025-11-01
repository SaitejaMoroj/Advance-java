package JDBC_DataBaseConnectivity;
import java.sql.*;

public class ConnectionEstablishments {
    public static void main(String[] args) throws Exception {
        // 1. Oracle connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // xe = default SID
        String username = "sys as sysdba";  // SYS user with sysdba role
        String password = "your_password";  // replace with your actual SYS password

        // 2. Load Oracle driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 3. Establish connection
        Connection con = DriverManager.getConnection(url, username, password);

        // 4. Create statement
        Statement st = con.createStatement();

        // 5. Execute query
        ResultSet rs = st.executeQuery("SELECT * FROM Employees");

        // 6. Process results
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        // 7. Close connections
        rs.close();
        st.close();
        con.close();

        System.out.println("Oracle connection successful!");
    }
}
