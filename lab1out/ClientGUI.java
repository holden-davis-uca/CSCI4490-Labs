//Holden Davis
//CSCI 4490 - Dr. Smith
//1/26/22

package lab1out;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientGUI extends JFrame
{
	private JPanel north;
	private JPanel core;
	private JPanel central;
	private JPanel scrolls;
	private JPanel south;
	
	private JLabel statuslabel;
	private JLabel status;
	
	private String[] labels = {"Client ID", "Server URL", "Server Port"};
	private JLabel clientid;
	private JLabel serverurl;
	private JLabel serverport;
	private JTextField[] textFields = new JTextField[labels.length];
	private JLabel clientdata;
	private JLabel serverdata;
	private JTextArea clientArea;
	private JTextArea serverArea;
	private JScrollPane clientscroll;
	private JScrollPane serverscroll;
	
	private JButton connect;
	private JButton submit;
	private JButton stop;

	public ClientGUI(String title)
	{
		System.out.println("\nSTARTING " + title + "\n");
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		statuslabel = new JLabel("Status: ");
		status = new JLabel("NOT CONNECTED");
		status.setForeground(Color.RED);
		north = new JPanel();
		
		textFields[0] = new JTextField();
		textFields[0].setEditable(false);
		textFields[1] = new JTextField();
		textFields[2] = new JTextField();
		
		clientid = new JLabel(labels[0]);
		serverurl = new JLabel(labels[1]);
		serverport = new JLabel(labels[2]);

		scrolls = new JPanel();
		scrolls.setLayout(new BoxLayout(scrolls, BoxLayout.Y_AXIS));
		clientdata = new JLabel("Enter Client Data Below");
		serverdata = new JLabel("Received Server Data");
		clientArea = new JTextArea(10, 20);
		serverArea = new JTextArea(10, 20);
		clientscroll = new JScrollPane(clientArea);
		serverscroll = new JScrollPane(serverArea);
		
		north.add(statuslabel);
		north.add(status); 
		
		core = new JPanel(new BorderLayout());
		central = new JPanel(new GridLayout(6, 1, 10, 10));
		
		central.add(clientid);
		central.add(textFields[0]);
		central.add(serverurl);
		central.add(textFields[1]);
		central.add(serverport);
		central.add(textFields[2]);
		scrolls.add(clientdata);
		scrolls.add(clientscroll);
		scrolls.add(serverdata);
		scrolls.add(serverscroll);
		core.add(central, BorderLayout.NORTH);
		core.add(scrolls, BorderLayout.SOUTH);
		
		south = new JPanel();
		connect = new JButton();
		connect.setText("Connect");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connect Button Pressed");
			}
		}
		);
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Data: " + clientArea.getText());
			}
		}
		);
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop Button Pressed");
			}
		}
		);
		south.add(connect);
		south.add(submit);
		south.add(stop);
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(core, BorderLayout.CENTER);
		this.getContentPane().add(south, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(480, 720));
		this.setVisible(true);
		System.out.println("\nSTOPPING " + title + "\n");    
	}

	public static void main(String[] args)
	{
		new ClientGUI(args[0]);
	}
}

