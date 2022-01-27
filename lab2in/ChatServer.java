package lab2in;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer{

	public ChatServer() {
		super(12345);
		super.setTimeout(500);
		// TODO Auto-generated constructor stub
	}
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		System.out.println("Client Message Send to Server\n");
	}
	public void listeningException(Throwable exception)
	{
		System.err.println("Listening Exception Occurred\n");
		System.err.println(exception.getMessage());
		System.err.println("\n");
		System.err.println(exception.getStackTrace());
		System.err.println("\n");
	}
	public void serverStarted() 
	{
		System.out.println("Server Started");
	}

}
