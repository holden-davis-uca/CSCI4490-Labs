package lab2in;

import java.io.IOException;

public class TestChatServer {
	
	private ChatServer server;
	
	public TestChatServer(int port, int timeout)
	{
		server = new ChatServer();
		server.setPort(port);
		server.setTimeout(timeout);
		try {
			server.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new TestChatServer(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}

}
