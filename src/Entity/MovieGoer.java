package Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This MovieGoer class is a specific instantiation of User..
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class MovieGoer extends User implements Serializable {
	private String fullName;
	private int mobileNo;
	private String email;

	private int age;
	private ArrayList<Booking> bookings = new ArrayList<Booking>();

	/**
	 * Constructor for MovieGoer.
	 * @param username Username of MovieGoer.
	 * @param password Password of MovieGoer.
	 * @param fullName Full name of MovieGoer.
	 * @param mobileNo Mobile number of MovieGoer.
	 * @param email Email of MovieGoer.
	 * @param age Age of MovieGoer.
	 * @param bookings Bookings of MovieGoer.
	 */
	public MovieGoer(String username, String password, String fullName, int mobileNo, String email, int age, ArrayList<Booking> bookings){
		super(username, password);
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.age = age;
		this.bookings = bookings;
	}

	/**
	 * Get MovieGoer's full name.
	 * @return MovieGoer's full name.
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Set MovieGoer's full name.
	 * @param fullName MovieGoer's full name.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Get MovieGoer's mobile number.
	 * @return MovieGoer's mobile number.
	 */
	public int getMobileNo() {
		return mobileNo;
	}

	/**
	 * Set MovieGoer's mobile number.
	 * @param mobileNo MovieGoer's mobile number.
	 */
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Get MovieGoer's email.
	 * @return MovieGoer's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set MovieGoer's email.
	 * @param email MovieGoer's email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get MovieGoer's age.
	 * @return MovieGoer's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set MovieGoer's age.
	 * @param age MovieGoer's age.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get MovieGoer's bookings.
	 * @return MovieGoer's bookings.
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	/**
	 * Set MovieGoer's bookings.
	 * @param bookings MovieGoer's bookings.
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * Check if MovieGoer is a Staff member.
	 * @return False.
	 */
	public boolean isStaff(){
		return false;
	}

}
