package Controller;

import Entity.*;
import ExceptionPackage.ExistingUserException;

import java.io.*;
import java.util.ArrayList;

public class UserController {
	public final static String FILENAME = "users.txt";

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

	public void updateMovieGoer(String username, String fullName, int mobileNo, String email, int age){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			if (userArrayList.size() != 0) {
				for(User user : userArrayList){
					if(user.getUsername().equals(username)){
						user = new MovieGoer(user.getUsername(), user.getPassword(), fullName, mobileNo, email, age);
					}
				}
			}
		}
	}

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

	public MovieGoer addMovieGoer(String username, String password, String fullName, int mobileNo, String email, int age){
		File data = new File(FILENAME);
		ArrayList<User> userArrayList = new ArrayList<User>();
		if(data.exists()){
			userArrayList = read();
			MovieGoer movieGoerToAdd = new MovieGoer(username, password, fullName, mobileNo, email, age);
			userArrayList.add(movieGoerToAdd);
			overwriteUserList(FILENAME, userArrayList);
			return movieGoerToAdd;
		}

		return null;
	}

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


