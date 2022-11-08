package Entity;

import java.io.Serializable;

public class MovieGoer extends User implements Serializable {
	private String fullName;
	private int mobileNo;
	private String email;

	public MovieGoer(String username, String password, String fullName, int mobileNo, String email){
		super(username, password);
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStaff(){
		return false;
	}

}
