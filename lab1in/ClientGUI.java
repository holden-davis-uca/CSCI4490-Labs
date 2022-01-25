//Holden Davis
//CSCI 4490 - Dr. Smith
//1/20/22

package lab1in;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientGUI extends JFrame
{
  private JLabel status;
  private JButton connect;
  private JButton submit;
  private JButton stop;
  private JPanel north;
  private JPanel south;
  
  public ClientGUI(String title)
  {
    int i = 0;
    
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    
    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
    System.out.println("\nSTARTING " + title + "\n");
    status = new JLabel();
    status.setText("NOT CONNECTED");
    status.setForeground(Color.RED);
    north = new JPanel();
    north.add(status); 
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
			System.out.println("Submit Button Pressed");
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
    south.add(connect);
    south.add(submit);
    south.add(stop);
    this.add(north);
    this.add(south, BorderLayout.SOUTH);
    this.setMinimumSize(new Dimension(720,480));
    this.setVisible(true);
    System.out.println("\nSTOPPING " + title + "\n");    
  }
  
  public static void main(String[] args)
  {
    new ClientGUI(args[0]); //args[0] represents the title of the GUI
  }
}

