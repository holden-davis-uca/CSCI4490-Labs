package lab8out;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class DatabaseTest {
	
	Database db;
	String[] users = {"jsmith@uca.edu","msmith@uca.edu","tjones@yahoo.com","jjones@yahoo.com"};
	String[] passwords = {"hello123","pass123","123456","hello1234"};
	private int rando;

	@Test
	public void testSetConnection() {
		this.db = new Database();
		db.setConnection("./lab8out/db.properties");
		assertNotNull(db.getConnection());
	}
	@Test
	public void testQuery() {
		this.db = new Database();
		db.setConnection("./lab8out/db.properties");
		db.getConnection();
		rando = ((int)Math.random()*users.length); 
		String username = users[rando]; 
		String expected = passwords[rando];
				
		//get actual result (invoke query with username
		ArrayList<String> results = db.query("select username, aes_decrypt(password, 'key') from users where username='"+username+"';");
		for (String test: results)
		{
			if (test==expected)
				assert(true);
		}
	}
	@Test
	public void testExecuteDML() {
		this.db = new Database();
		db.setConnection("./lab8out/db.properties");
		db.getConnection();
		try {
			db.executeDML("insert into users values('jsmith1@uca.edu', aes_encrypt('hello1231', 'key'));");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
