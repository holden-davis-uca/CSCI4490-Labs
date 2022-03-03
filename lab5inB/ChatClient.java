package lab5inB;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
  
  public ChatClient()
  {
    super("localhost",8300);
  }

  @Override
  public void handleMessageFromServer(Object arg0)
  {
    System.out.println("Server Message sent to Client " + (String)arg0);

  }
  
  public void connectionException (Throwable exception) 
  {
    //Add your code here
  }
  public void connectionEstablished()
  {
    //Add your code here
  }
  

}
