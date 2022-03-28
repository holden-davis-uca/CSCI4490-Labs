package lab7in;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {
	private Connection conn;
	// Add any other data fields you like – at least a Connection object is
	// mandatory
	private String user;
	private String password;
	private String url;
	private FileInputStream fis;

	public Database() {

		try {
			fis = new FileInputStream("C:\\Users\\holde\\CSCI4490Workspace\\Labs\\lab7in\\db.properties");
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> query(String query) {

		// using conn object create statement object
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

	public void executeDML(String dml) throws SQLException {
		// Add your code here
		
		Statement stmt = conn.createStatement();
		stmt.execute(dml);
		
	}

}