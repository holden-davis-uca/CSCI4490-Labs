package lab7in;

import java.sql.*;
import java.util.*;

public class TestDatabaseServer {

	public static void main(String[] args)
	  {
	    // Make sure there are 2 command line arguments.
	    if (args.length < 2)
	    {
	      System.out.println("This program requires 2 command line arguments.");
	      return;
	    }
	    
	    // Get the command line arguments.
	    String command = args[0];
	    String type = args[1];
	    
	    // Create the database object.
	    Database database = new Database();
	    
	    // Execute a query if Q was specified.
	    if (type.equals("Q"))
	    {
	      // Do the query.
	      ArrayList<String> result = database.query(command);
	     
	      // Print the result.
	      if (result != null)
	      {
	        for (String row : result)
	        {
	          System.out.println(row);
	        }
	      }
	      else
	      {
	        System.out.println("Error executing query.");
	      }
	    }
	    
	    // Execute DML if D was specified.
	    else if (type.equals("D"))
	    {
	      // Run the DML.
	      try
	      {
	         database.executeDML(command);
	       }
	       catch(SQLException sql)
	       {
	           System.out.println("Error executing DML.");
	        }

	     }
	  }

}
