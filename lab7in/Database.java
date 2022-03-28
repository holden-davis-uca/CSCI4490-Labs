package lab7in;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database
{
  private Connection conn;
  //Add any other data fields you like – at least a Connection object is mandatory
  private String user;
  private String password;
  private FileInputStream fis;
  public Database()
  {
    //Add your code here
	  try
	  {
		  fis = new FileInputStream("");
		  
	  } catch (FileNotFoundException e)
	  {
		  
	  }
	  property.load(fis);
	  //Create connection
	  
  }
  
  public ArrayList<String> query(String query)
  {
    //Add your code here
	//create statement from conn and run query w/ executequery, return resultset
	  //getstring
	  //store each string in arraylist
  }
  
  public void executeDML(String dml) throws SQLException
  {
    //Add your code here
	  Statement stmt = conn.createStatement();
	  stmt.execute(dml);
  }
  
}
