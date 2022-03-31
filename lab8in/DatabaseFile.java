package lab8in;

import java.io.*;

public class DatabaseFile
{
  private FileInputStream fis;
  
  
  public void setStream(String fn) throws FileNotFoundException
  {
    fis = new FileInputStream(fn);
    
  }
  
  public FileInputStream getStream()
  {
    return fis;
  }
  
  public String query(String input) throws IOException
  {
    String line;
    String pass;
    String[] array;
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    
    //Read each line checking for input
    while(true)
    {
      //Read the password
      line = br.readLine();
      
      if (line == null)
        break;
      
      //Split based on :
      array = line.split(":");
      
      //Compare user
      if (input.equals(array[0]))
      {
        return array[1];
      }
    }
    
    return null;  
      
 
  }
  

 }
