package dev.testlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDBConnection {

	  private static Connection conn = null;
	  
	  // Hostname
	  private static String dbHost = "localhost";
	 
	  // Port -- Standard: 3306
	  private  String dbPort = "3306";
	 
	  // Datenbankname
	  private  String database = "webtest";
	 
	  // Datenbankuser
	  private  String dbUser = "db_test";
	 
	  // Datenbankpasswort
	  private  String dbPassword = "test1234";
	  
	  public MyDBConnection(){
		  try {
			  
		      // Datenbanktreiber für ODBC Schnittstellen laden.
		      // Für verschiedene ODBC-Datenbanken muss dieser Treiber
		      // nur einmal geladen werden.
		      Class.forName("com.mysql.jdbc.Driver");
		 
		      // Verbindung zur ODBC-Datenbank 'sakila' herstellen.
		      // Es wird die JDBC-ODBC-Brücke verwendet.
		      conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
		          + dbPort + "/" + database + "?", dbUser, dbPassword);
		    } catch (ClassNotFoundException e) {
		      System.out.println("Treiber nicht gefunden");
		      System.out.println(e);
		    } catch (SQLException e) {
		      System.out.println("Connect nicht moeglich");
		    }
	  }
	  
	  public List<User> getUsers(){
		  List<User> users = new ArrayList<User>();
		  
		  if(conn != null)
		    {
		      // Anfrage-Statement erzeugen.
		      Statement query;
		      try {
		        query = conn.createStatement();
		 
		        // Ergebnistabelle erzeugen und abholen.
		        String sql = "SELECT * FROM user";
		        ResultSet result = query.executeQuery(sql);
		 
		        // Ergebnissätze durchfahren.
		        while (result.next()) {
		          String userID = Integer.toString(result.getInt("userid")); // Alternativ: result.getString(1);
		          String uname = result.getString("uname"); // Alternativ: result.getString(2);
		          String pwd = result.getNString("passwd");
		          User user = new User(userID, uname, pwd);
		          users.add(user);
		        }
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		  
		  return users;
	  }
	  
	  public User getUser(String userId){
		  User user = null;
		  if(conn != null)
		    {
		      // Anfrage-Statement erzeugen.
		      Statement query;
		      try {
		        query = conn.createStatement();
		 
		        // Ergebnistabelle erzeugen und abholen.
		        String sql = "SELECT * FROM user WHERE userid=" + userId;
		        ResultSet result = query.executeQuery(sql);
		 
		        // Ergebnissätze durchfahren.
		        while (result.next()) {
		          String userID = Integer.toString(result.getInt("userid")); // Alternativ: result.getString(1);
		          String uname = result.getString("uname"); // Alternativ: result.getString(2);
		          String pwd = result.getNString("passwd");
		          user = new User(userID, uname, pwd);
		        }
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		  
		  return user;
	  }
	
	
}
