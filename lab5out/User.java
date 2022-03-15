package lab5out;

public class User
{
	private String username;
	private String password;
	public User(String uname, String pw)
	{
		setUsername(uname);
		setPassword(pw);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}