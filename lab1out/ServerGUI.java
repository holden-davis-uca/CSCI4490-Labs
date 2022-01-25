//Holden Davis
//CSCI 4490 - Dr. Smith
//1/??/22

package lab1out;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServerGUI extends JFrame
{
	private JButton listen;
	private JButton close;
	private JButton stop;
	private JButton quit;
	private JLabel statuslabel;
	private JLabel status; //Initialized to “Not Connected”
	private JLabel port;
	private JLabel timeout;
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;
	private JPanel north;
	private JPanel south;

	public ServerGUI(String title)
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
		
		port = new JLabel();
		port.setText(labels[0]);
		textFields[0] = new JTextField();
		north.add(port);
		north.add(textFields[0]);
		
		timeout = new JLabel();
		timeout.setText(labels[1]);
		textFields[1] = new JTextField();
		north.add(timeout);
		north.add(textFields[1]);
		
		south = new JPanel();
		south.setLayout(new FlowLayout());
		listen = new JButton();
		listen.setText("Listen");
		listen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Listen Button Pressed");
			}
		}
				);
		close = new JButton();
		close.setText("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Close Button Pressed");
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
		quit = new JButton();
		quit.setText("Quit");
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
		this.add(north);
		this.add(south, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(480,720));
		this.setVisible(true);
		System.out.println("\nSTOPPING " + title + "\n");    
	}

	public static void main(String[] args)
	{
		new ServerGUI(args[0]);
	}
}