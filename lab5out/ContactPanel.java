package lab5out;

import java.awt.*;
import javax.swing.*;

public class ContactPanel extends JPanel
{
	private JTextArea usernamearea;
	private JButton deletecontact, addcontact, logout;
	private JLabel contactlabel;
	
	public ContactPanel()
	{
		JPanel panel1 = new JPanel(new GridLayout(1,1,5,5));
		contactlabel = new JLabel("Contacts", JLabel.CENTER);
		panel1.add(contactlabel);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 5, 5));
		usernamearea = new JTextArea();

		panel2.add(usernamearea);
		JPanel panel3 = new JPanel(new GridLayout(1, 1, 5, 5));
		deletecontact = new JButton("Delete Contact");
		panel3.add(deletecontact);
		addcontact = new JButton("Add Contact");
		panel3.add(addcontact);
		JPanel panel4 = new JPanel(new GridLayout(1, 1, 5, 5));
		logout = new JButton("Logout");
		panel4.add(logout);
		JPanel grid = new JPanel(new GridLayout(4, 1, 0, 5));
		grid.add(panel1);
		grid.add(panel2);
		grid.add(panel3);
		grid.add(panel4);
		this.add(grid);
	}
}

