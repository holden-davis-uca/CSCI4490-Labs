//Holden Davis
//CSCI 4490 - Dr. Smith
//2/5/22

package lab3out;

import ocsf.server.*;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class ChatServer extends AbstractServer{
	private JTextArea log;
	private JLabel status;
	public ChatServer()
	{
		super(12345);	
	}
	public void setLog(JTextArea log)
	{
		this.log = log;
	}
	public void setStatus(JLabel status)
	{
		this.status = status;
	}
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		log.append("Client " + arg1.getId() + ": " + arg0.toString());
		try {
			arg1.sendToClient(arg0.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void listeningException(Throwable exception)
	{
		log.append(exception.getMessage() + "\n");
		log.append("\nPress Listen to Restart Server\n");
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.RED);
	}
	public void serverStarted()
	{
		status.setText("Listening");
		status.setForeground(Color.GREEN);
		log.append("Server Started\n");
	}
	public void serverStopped()
	{
		status.setText("Stopped");
		status.setForeground(Color.RED);
		log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
	}
	public void serverClosed()
	{
		status.setText("Closed");
		status.setForeground(Color.RED);
		log.append("Server and all current clients are closed - Press Listen to Restart\n");
	}
	public void clientConnected(ConnectionToClient client)
	{
		log.append("Client " + client.getId() + " Connected\n");
		try {
			client.sendToClient("username: client-" + client.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
