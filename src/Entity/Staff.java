package Entity;

import java.io.Serializable;

public class Staff extends User implements Serializable {
	public Staff(String username, String password){
		super(username, password);
	}

	public boolean isStaff(){
		return true;
	}
}
