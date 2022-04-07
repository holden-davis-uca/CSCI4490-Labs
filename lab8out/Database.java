package lab8out;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Database
{
  private Connection conn;
	private String user;
	private String password;
	private String url;
	private FileInputStream fis;
  //Add any other data fields you like – at least a Connection object is mandatory
  public Connection setConnection(String fn) 
  {
		try {
			fis = new FileInputStream(fn);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties props = new Properties();
		try {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		user = props.getProperty("user");
		password = props.getProperty("password");
		url = props.getProperty("url");
		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
  }

  public Connection getConnection()
  {
    return conn;
  }

  public ArrayList<String> query(String query) 
  {
		try {
			
			Statement stmt = conn.createStatement();
			ArrayList<String> queryresults = new ArrayList<String>();
			ResultSet results = stmt.executeQuery(query);
			if (results == null)
			{
				return null;
			}
			while (results.next())
			{
				queryresults.add(results.getString(1));
				queryresults.add(results.getString(2));
			}
			
			return queryresults;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
  }
  
  public void executeDML(String dml) throws SQLException
  {
		Statement stmt = conn.createStatement();
		stmt.execute(dml);
  }
  
}
