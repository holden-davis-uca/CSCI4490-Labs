package lab5inB;

import java.io.IOException;

public class TestChatServer
{
  private ChatServer server;
  public TestChatServer(int port, int timeout)
  {
    // TODO Auto-generated constructor stub
    server = new ChatServer(port);
    
    server.setPort(port);
    server.setTimeout(timeout);
    
    
    //Start listening
    try
    {
      server.listen();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    //Test if listening
    if (server.isListening())
    {
      System.out.println("Server is listening");
    }
    
    //Display number of Clients:
    System.out.println("Number of Client:" + server.getNumberOfClients());
    
    //Display the 
    
    
    
  }
  
  public static void main(String[] args)
  {
   
   
    new TestChatServer(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
  }

}
