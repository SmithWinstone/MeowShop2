package javacode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool  {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static List<Connection> freeDbConnections;
	
	static{
	    try {
	    	System.out.println("Init driver manager: ");
	    	freeDbConnections = new LinkedList<Connection>();
	    	Class.forName(DRIVER);
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}	
	
    public static synchronized Connection getConnection() throws Exception {
	    Connection connection;
	    if (!freeDbConnections.isEmpty()) {
	      connection = (Connection) freeDbConnections.get(0);
	      freeDbConnections.remove(0);
	
	      try {
	        if (connection.isClosed())
	          connection = getConnection();
	      } catch (SQLException e) {
	        connection.close();
	        connection = getConnection();
	      }
	    } else {
	      connection = createDBConnection();   
	    }
	
	    return connection; 
    }
    
    
	private static synchronized Connection createDBConnection() throws Exception {
	    String dbURL = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "meowshop"; 
	    String dbUsername = "root"; 
	    String dbPassword = "Password00"; 
	    try {
			System.out.println("create db connection");
			Connection con = DriverManager.getConnection(dbURL + dbName+"?useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false", dbUsername, dbPassword); 
			return con; 
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
 
    public static synchronized void releaseConnection(Connection connection) throws SQLException {
      if(connection != null) freeDbConnections.add(connection);
    }
}
