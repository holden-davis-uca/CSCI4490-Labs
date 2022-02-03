//Holden Davis
//CSCI 4490 - Dr. Smith
//2/3/22

package lab3in;

import java.io.IOException;

import ocsf.server.*;

public class ChatServer extends AbstractServer{

	public ChatServer() {
		super(12345);
		super.setTimeout(500);
		// TODO Auto-generated constructor stub
	}
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		System.out.println("Client " + arg1.getId() + " " + arg0.toString());
		try {
			arg1.sendToClient("Hello Client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listeningException(Throwable exception)
	{
		System.err.println("Listening Exception Occurred\n");
		System.err.println(exception.getMessage());
		exception.printStackTrace();
	}
	public void serverStarted() 
	{
		System.out.println("Server Started");
	}

}
