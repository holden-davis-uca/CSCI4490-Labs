//Holden Davis
//CSCI 4490 - Dr. Smith
//2/3/22

package lab3in;

import java.io.IOException;

public class TestChatClient {
	
	private ChatClient client;

	public TestChatClient(String host, int port)
	{
		client = new ChatClient();
		client.setHost(host);
		client.setPort(port);
		try {
			client.openConnection();
			client.sendToServer("Hello Server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void main(String[] args)
	{
		new TestChatClient(args[0], Integer.parseInt(args[1]));
	}
}
