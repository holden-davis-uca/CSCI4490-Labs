//Holden Davis
//CSCI 4490 - Dr. Smith
//2/1/22

package lab3out;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class ServerGUI extends JFrame
{
	private ChatServer server;
	
	private JPanel north;
	private JPanel core;
	private JPanel central;
	private JPanel scrolls;
	private JPanel south;
	
	private JLabel statuslabel;
	private JLabel status;

	private JLabel port;
	private JLabel timeout;
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JLabel loglabel;
	private JTextArea log;
	private JScrollPane serverscroll;
	
	
	private JButton listen;
	private JButton close;
	private JButton stop;
	private JButton quit;

	public ServerGUI(String title)
	{
		System.out.println("\nSTARTING " + title + "\n");
		server = new ChatServer();
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		statuslabel = new JLabel("Status: ");
		status = new JLabel("NOT CONNECTED");
		status.setForeground(Color.RED);
		north = new JPanel();
	
		port = new JLabel(labels[0]);
		textFields[0] = new JTextField();

		timeout = new JLabel(labels[1]);
		textFields[1] = new JTextField();
		
		scrolls = new JPanel();
		scrolls.setLayout(new BoxLayout(scrolls, BoxLayout.Y_AXIS));
		
		north.add(statuslabel);
		north.add(status); 
		loglabel = new JLabel("Server Log Below");
		log = new JTextArea(10, 20);
		serverscroll = new JScrollPane(log);
		
		core = new JPanel(new BorderLayout());
		central = new JPanel(new GridLayout(4, 1, 10, 10));
		
		central.add(port);
		central.add(textFields[0]);
		central.add(timeout);
		central.add(textFields[1]);
		scrolls.add(loglabel);
		scrolls.add(serverscroll);
		core.add(central, BorderLayout.NORTH);
		core.add(scrolls, BorderLayout.SOUTH);
		
		south = new JPanel();
		listen = new JButton("Listen");
		listen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Listen Button Pressed");
				if (textFields[0].getText().equals("") && textFields[1].getText().equals(""))
				{
					log.append("Port Number/timeout not entered before pressing Listen\n");
				}
				else {
					try {
						server.setPort(Integer.parseInt(textFields[0].getText()));
						server.setTimeout(Integer.parseInt(textFields[1].getText()));
						server.listen();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		);
		close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Close Button Pressed");
				if (!server.isListening())
				{
					log.append("Server not currently started\n");
				}
				else {
					try {
						server.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		);
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop Button Pressed");
				if (!server.isListening())
				{
					log.append("Server not currently started\n");
				}
				else{
					server.stopListening();
				}
			}
		}
		);
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		);
		south.add(listen);
		south.add(close);
		south.add(stop);
		south.add(quit);
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(core, BorderLayout.CENTER);
		this.getContentPane().add(south, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(480,720));
		this.setVisible(true);
		server.setLog(log);
		server.setStatus(status);
		System.out.println("\nSTOPPING " + title + "\n");    
	}

	public static void main(String[] args)
	{
		new ServerGUI(args[0]);
	}
}