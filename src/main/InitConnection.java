package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InitConnection {

  public static Connection createConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/practice",
        "root",
        "Saad@2786"
      );

      return con;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
