//Holden Davis
//CSCI 4490 - Dr. Smith
//2/3/22

package lab3in;

import ocsf.client.*;

public class ChatClient extends AbstractClient{

	public ChatClient() {
		super("localhost", 8300);
	}

	public void handleMessageFromServer(Object msg) {
		System.out.println("Server Message sent to Client " + msg.toString());
	}
	public void connectionException(Throwable exception)
	{
		System.err.println("Connection Exception Occurred");
		System.err.println(exception.getMessage());
		exception.printStackTrace();;
	}
	public void connectionEstablished()
	{
		System.out.println("Client Connected");
	}

}
