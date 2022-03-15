package lab5out;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class CreateAccountControl implements ActionListener
{
  // Private data fields for the container and chat client.
  private JPanel container;
  
  
  // Constructor for the login controller.
  public CreateAccountControl(JPanel container)
  {
    this.container = container;
   
  }
  
  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();

    // The Cancel button takes the user back to the initial panel.
    if (command == "Cancel")
    {
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "1");
    }

    // The Submit button submits the login information to the server.
    else if (command == "Submit")
    {
      // Get the username and password the user entered.
      CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
      CreateAccountData data = new CreateAccountData(createPanel.getUsername(), createPanel.getPassword(), createPanel.getverifyPassword());
      
      // Check the validity of the information locally first.
      if (data.getUsername().equals("") || data.getPassword().equals(""))
      {
        displayError("You must enter a username and password.");
        return;
      }
      if (!(data.getPassword().equals(data.getverifyPassword())))
      {
    	  displayError("Password and re-entered password must match");
    	  return;
      }
      if (data.getPassword().length() < 6)
      {
    	  displayError("Password must be at least 6 characters long");
    	  return;
      }

      // Submit the login information to the server.
      else
      {
    	  ContactPanel contactPanel = (ContactPanel)container.getComponent(3);
    	  CardLayout cardLayout = (CardLayout)container.getLayout();
          cardLayout.show(container, "4");
      }
     
    }
  }

  // After the login is successful, set the User object and display the contacts screen. - this method would be invoked by 
  //the ChatClient
  public void loginSuccess()
  {
    
  }

  // Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
  public void displayError(String error)
  {
	 CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
    createPanel.setError(error);
  }
}