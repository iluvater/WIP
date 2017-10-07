package dev.testlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;

public class MyDBConnection {

	  private static Connection conn = null;
	  
	  // Hostname
	  private static String dbHost = "localhost";
	 
	  // Port -- Standard: 3306
	  private static String dbPort = "3306";
	 
	  // Datenbankname
	  private static String database = "webtest";
	 
	  // Datenbankuser
	  private static String dbUser = "root";
	 
	  // Datenbankpasswort
	  private static String dbPassword = "root";
	  
	  public MyDBConnection(){
		  try {
			  
		      // Datenbanktreiber für ODBC Schnittstellen laden.
		      // Für verschiedene ODBC-Datenbanken muss dieser Treiber
		      // nur einmal geladen werden.
		      Class.forName("com.mysql.jdbc.Driver");
		 
		      // Verbindung zur ODBC-Datenbank 'sakila' herstellen.
		      // Es wird die JDBC-ODBC-Brücke verwendet.
		      conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
		              + dbPort + "/" + database + "?" + "user=" + dbUser);
		    } catch (ClassNotFoundException e) {
		      System.out.println("Treiber nicht gefunden");
		      e.printStackTrace();
		    } catch (SQLException e) {
		      System.out.println("Connect nicht moeglich");
		      e.printStackTrace();
		    }
	  }
	  
	  private static Connection getInstance()
	  {
	    if(conn == null)
	      new MyDBConnection();
	    return conn;
	  }
	  
	  public List<User> getUsers(){
		  List<User> users = new ArrayList<User>();
		  conn = getInstance();
		  
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
		  conn = getInstance();
		  
		  if(conn != null)
		    {
		      // Anfrage-Statement erzeugen.
		      Statement query;
		      try {
		        query = conn.createStatement();
		 
		        // Ergebnistabelle erzeugen und abholen.
		        String sql = "SELECT * FROM user WHERE userid='" + userId + "'";
		        ResultSet result = query.executeQuery(sql);
		 
		        // Ergebnissätze durchfahren.
		        while (result.next()) {
		          String userID = Integer.toString(result.getInt("userid")); // Alternativ: result.getString(1);
		          String uname = result.getString("uname"); // Alternativ: result.getString(2);
		          String pwd = result.getString("passwd");
		          user = new User(userID, pwd, uname);
		        }
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		  
		  return user;
	  }
	
	
}
