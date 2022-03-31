package lab8in;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.*;
import org.junit.*;

public class DatabaseFileTest {
	
	String[] users = {"jsmith@uca.edu","msmith@uca.edu","tjones@yahoo.com","jjones@yahoo.com"};
	String[] passwords = {"hello123","pass123","123456","hello1234"};

	private DatabaseFile db; 
		
	private int rando;

	@Before
	public void setUp() throws Exception 
	{
	  db = new DatabaseFile(); 
	  db.setStream("lab8in/users.txt");
	  rando = ((int)Math.random()*users.length); 
	}
	
	@Test
	public void testSetStream() throws FileNotFoundException
	{
	  //1. call setStream() with users.txt
		db.setStream("lab8in/users.txt");
	  //2. call getStream() and return a FileInputStream object (fis)
		FileInputStream fis = db.getStream();
	  //3. make sure FileInputStream object returned by getStream is not null
		assertNotNull("Check setStream", fis); //Place object here 
			
			//fail("not yet implemented");
	}


	@Test(expected = FileNotFoundException.class)
	public void testStream() throws FileNotFoundException
	{
	  
	  //1. Set the stream with user.txt (wrong name) – should throw FileNotFoundException
		db.setStream("lab8in/user.txt");

	}

		

	@Test
	public void testQuery() throws IOException 
	{
	  //Use Random # to extract username/ and expected password
	 String username = users[rando]; 
	 String expected = passwords[rando];
			
	 //get actual result (invoke query with username
	 String realpassword = db.query(username);
			
	//compare expected with actual using assertEquals
	 assertEquals(expected, realpassword);			
			
			
	}
		
	@Test  //Test for bad user name
	public void testQuery2() throws IOException
	{
			
	 //Set bad username to an invalid name
	  String username = "bungus";		
	 //Extract actual name based on bad user name
	  String what = db.query(username);	
	 //compare actual with assertNull 
	 assertNull("Check query", what); 
	}



}
