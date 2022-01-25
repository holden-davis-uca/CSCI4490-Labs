//Holden Davis
//CSCI 4490 - Dr. Smith
//1/??/22

package lab1out;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientGUI extends JFrame
{
	private JLabel statuslabel;
	private JLabel status;
	private JButton connect;
	private JButton submit;
	private JButton stop;
	private JPanel north;
	private JPanel south;
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

	public ClientGUI(String title)
	{
		System.out.println("\nSTARTING " + title + "\n");
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		statuslabel = new JLabel();
		statuslabel.setText("Status: ");
		status = new JLabel();
		status.setText("NOT CONNECTED");
		status.setForeground(Color.RED);
		north = new JPanel();
		north.setLayout(new FlowLayout());
		north.add(statuslabel);
		north.add(status); 
		
		textFields[0] = new JTextField();
		textFields[0].setEditable(false);
		textFields[1] = new JTextField();
		textFields[2] = new JTextField();
		
		clientid = new JLabel();
		clientid.setText(labels[0]);
		serverurl = new JLabel();
		serverurl.setText(labels[1]);
		serverport = new JLabel();
		serverport.setText(labels[2]);
		
		north.add(clientid);
		north.add(textFields[0]);
		north.add(serverurl);
		north.add(textFields[1]);
		north.add(serverport);
		north.add(textFields[2]);
		
		clientdata = new JLabel();
		clientdata.setText("Enter Client Data Below");
		serverdata = new JLabel();
		serverdata.setText("Received Server Data");
		clientArea = new JTextArea();
		serverArea = new JTextArea();
		clientscroll = new JScrollPane();
		serverscroll = new JScrollPane();
		clientscroll.add(clientArea);
		serverscroll.add(serverArea);
		
		north.add(clientdata);
		north.add(clientscroll);
		north.add(serverdata);
		north.add(serverscroll);
		
		connect = new JButton();
		connect.setText("Connect");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connect Button Pressed");
			}
		}
				);
		submit = new JButton();
		submit.setText("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Data: " + clientArea.getText());
			}
		}
				);
		stop = new JButton();
		stop.setText("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop Button Pressed");
			}
		}
				);
		south = new JPanel();
		south.setLayout(new FlowLayout());
		south.add(connect);
		south.add(submit);
		south.add(stop);
		this.add(north);
		this.add(south, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(480, 720));
		this.setVisible(true);
		System.out.println("\nSTOPPING " + title + "\n");    
	}

	public static void main(String[] args)
	{
		new ClientGUI(args[0]);
	}
}

