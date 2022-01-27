package lab2in;

import ocsf.server.*;

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
		exception.printStackTrace();
	}
	public void serverStarted() 
	{
		System.out.println("Server Started");
	}

}
