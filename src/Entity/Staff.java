package Entity;

import java.io.Serializable;
/**
 * This Staff class is a specific instantiation of User..
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class Staff extends User implements Serializable {
	/**
	 * Constructor for Staff.
	 * @param username Username of Staff.
	 * @param password Password of Staff.
	 */
	public Staff(String username, String password){
		super(username, password);
	}

	/**
	 * Check if Staff is a Staff member.
	 * @return True.
	 */
	public boolean isStaff(){
		return true;
	}
}
