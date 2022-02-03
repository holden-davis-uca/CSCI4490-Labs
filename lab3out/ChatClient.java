//Holden Davis
//CSCI 4490 - Dr. Smith
//2/3/22

package lab3out;

import ocsf.client.*;
import java.awt.*;
import javax.swing.*;

public class ChatClient extends AbstractClient{

	private JLabel status;
	private JTextArea serverMsg;
	private JTextField clientID;
	
	public ChatClient() {
		super("localhost", 8300);
	}
	
	public void setStatus(JLabel status) 
	{
		this.status = status;
	}
	public void setServerMsg(JTextArea serverMsg)
	{
		this.serverMsg = serverMsg;
	}
	public void setClientID(JTextField clientID)
	{
		this.clientID = clientID;
	}

	public void handleMessageFromServer(Object arg0) 
	{
		serverMsg.append(arg0.toString());
	}
	public void connectionEstablished()
	{
		status.setText("Connected");
		status.setForeground(Color.GREEN);
	}
	public void connectionClosed()
	{
		status.setText("Not Connected");
		status.setForeground(Color.RED);
	}

}
