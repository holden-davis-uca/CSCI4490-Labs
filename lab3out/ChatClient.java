//Holden Davis
//CSCI 4490 - Dr. Smith
//2/5/22

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
		try
		{
			String[] response = arg0.toString().split("-");
			String id = response[1];
			clientID.setText("client" + id);
			serverMsg.append("Server: " + arg0.toString() + "\n");
		} catch (Exception e)
		{
			serverMsg.append("Server: " + arg0.toString() + "\n");
		}
	}
	public void connectionException(Throwable exception)
	{
		System.err.println("Connection Exception Occurred");
		System.err.println(exception.getMessage());
		exception.printStackTrace();;
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
