package MyJdbc.Mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Setup {
    public void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/codingwallah";
            String user = "root";
            String password = "123@";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query="use codingwallah;";
            stmt.execute(query);
            System.out.println("Connected to database successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db="codingwallah";
            String user = "root";
            String password = "123@";
            Connection conn = DriverManager.getConnection(url+db, user, password);
            Statement stmt = conn.createStatement();
            String query="create table Teacher(name int(20),age int (10),id varchar(20));";
            stmt.execute(query);

            System.out.println("Table to database successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db="codingwallah";
            String user = "root";
            String password = "123@";
            Connection conn = DriverManager.getConnection(url+db, user, password);
            Statement stmt = conn.createStatement();
            String query="insert into Teacher values(1,1,'10');";
            stmt.execute(query);

            System.out.println("data inserted successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
