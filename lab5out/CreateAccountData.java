package lab5out;

import java.io.Serializable;

public class CreateAccountData implements Serializable 
{
  // Private data fields for the username and password.
  private String username;
  private String password;
  private String verifypassword;
  
  // Getters for the username and password.
  public String getUsername()
  {
    return username;
  }
  public String getPassword()
  {
    return password;
  }
  public String getverifyPassword()
  {
    return verifypassword;
  }
  
  // Setters for the username and password.
  public void setUsername(String username)
  {
    this.username = username;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public void setverifyPassword(String verifypassword)
  {
    this.verifypassword = verifypassword;
  }
  
  // Constructor that initializes the username and password.
  public CreateAccountData(String username, String password, String verifypassword)
  {
    setUsername(username);
    setPassword(password);
    setverifyPassword(verifypassword);
  }
}