package Entity;

import java.io.Serializable;

/**
 * This User abstract class defines the required fields username and password; and method isStaff() for all Users.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public abstract class User implements Serializable {
	private String username;
	private String password;

	/**
	 * Constructor for User.
	 * @param username Username of User.
	 * @param password Password of User.
	 */
	protected User(String username, String password){
		this.username = username;
		this.password = password;
	}

	/**
	 * Get User's username.
	 * @return User's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set User's username.
	 * @param username User's username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get User's password.
	 * @return User's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set User's password.
	 * @param password User's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Check if User is a Staff member.
	 * @return True if User is a Staff member.
	 */
	public abstract boolean isStaff();

}
