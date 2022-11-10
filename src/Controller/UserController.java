package Controller;

import Entity.*;
import ExceptionPackage.ExistingUserException;

import java.io.*;
import java.util.ArrayList;

/**
 * Controller interfacing with User objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-09
 */
public class UserController {
	public final static String FILENAME = "users.txt";

	/**
	 * Check if a given username and password is a valid user login.
	 * @param username Username attempt.
	 * @param password Password attempt.
	 * @return True if valid user login.
	 */
	public boolean isValidLogin(String username, String password){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if (userArrayList.size() != 0) {
				for(User user : userArrayList){
					if(user.getUsername().equals(username) && user.getPassword().equals(password)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Gets a User according to username.
	 * @param searchName Username of user to search.
	 * @return User with this username.
	 */
	public User getUserByUsername(String searchName){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if (userArrayList.size() != 0) {
				for(User user : userArrayList){
					if(user.getUsername().equals(searchName)){
						return user;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Update details of a MovieGoer.
	 * @param username Username of MovieGoer.
	 * @param fullName Full name of MovieGoer.
	 * @param mobileNo Mobile number of MovieGoer.
	 * @param email Email of MovieGoer.
	 * @param age Age of MovieGoer.
	 * @param booking Bookings of MovieGoer.
	 */
	public void updateMovieGoer(String username, String fullName, int mobileNo, String email, int age, ArrayList<Booking> booking){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if (userArrayList.size() != 0) {
				for(User user : userArrayList){
					if(user.getUsername().equals(username)){
						MovieGoer tempMovieGoer = (MovieGoer) user;
						userArrayList.remove(user);
						tempMovieGoer = new MovieGoer(username, tempMovieGoer.getPassword(), fullName, mobileNo, email, age, booking);
						userArrayList.add(tempMovieGoer);
						overwriteUserList(FILENAME, userArrayList);
					}
				}
			}
		}
	}

	/**
	 * Check if a User is Staff member, according to username.
	 * @param username Username of User to check.
	 * @return True if user is a Staff.
	 */
	public boolean isStaff(String username){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if (userArrayList.size() != 0) {
				for(User user : userArrayList){
					if(user.getUsername().equals(username) && user.isStaff()){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Add a new MovieGoer to User datafile.
	 * @param username Username of MovieGoer.
	 * @param password Password of MovieGoer.
	 * @param fullName Full name of MovieGoer.
	 * @param mobileNo Mobile number of MovieGoer.
	 * @param email Email of MovieGoer.
	 * @param age Age of MovieGoer.
	 * @param bookings Bookings of MovieGoer.
	 * @return MovieGoer object that was added.
	 */
	public MovieGoer addMovieGoer(String username, String password, String fullName, int mobileNo, String email, int age, ArrayList<Booking> bookings){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			MovieGoer movieGoerToAdd = new MovieGoer(username, password, fullName, mobileNo, email, age, bookings);
			userArrayList.add(movieGoerToAdd);
			overwriteUserList(FILENAME, userArrayList);
			return movieGoerToAdd;
		}

		return null;
	}

	/**
	 * Deletes a user from user data file.
	 * @param searchName Username of user to delete.
	 */
	public void deleteUser(String searchName){
		ArrayList<User> users = read();
		ArrayList<User> returnList = new ArrayList<User>();

		for (User user : users) {
			if (!(user.getUsername().equals(searchName))) {
				returnList.add(user);
			}
		}
		overwriteUserList(FILENAME, returnList);

	}

	/**
	 * Add a new Staff to User datafile.
	 * @param username Username of Staff.
	 * @param password Password of Staff.
	 * @return Staff object that was added.
	 * @throws ExistingUserException Cannot add a new Staff when there is an existing Staff with same username.
	 */
	public Staff addStaff(String username, String password) throws ExistingUserException {
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if(userArrayList.size()!=0){
				for (User user : userArrayList) {
					if (user.getUsername().equals(username)) {
						throw new ExistingUserException();
					}
				}
			}
		}
		Staff staffToAdd = new Staff(username, password);
		userArrayList.add(staffToAdd);
		overwriteUserList(FILENAME, userArrayList);
		return staffToAdd;
	}

	/**
	 * Read from User data file.
	 * @return ArrayList of Users from data file.
	 */
	public ArrayList<User> read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			ArrayList<User> userList = (ArrayList<User>) inputStream.readObject();
			inputStream.close();
			return userList;
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<User>();
		}

	}

	/**
	 * Overwrite the User data file.
	 * @param filename Filename of User data file.
	 * @param data ArrayList of all Users.
	 */
	private void overwriteUserList(String filename, ArrayList<User> data){
		File temp = new File(filename);
		if(temp.exists()){
			temp.delete();
		}
		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			outputStream.writeObject(data);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e){
			System.out.println("caught in usercontroller");
		}
	}
}


