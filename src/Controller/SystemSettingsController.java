package Controller;

import Entity.SystemSettings;

import java.io.*;

/**
 * Controller for interfacing with SystemSettings objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class SystemSettingsController {
	public final static String FILENAME = "settings.txt";
	/**
	 * Initialise the system settings data file
	 */
	public void initialiseSettings(){
		File data = new File(FILENAME);
		if(data.exists()){

		} else {
			SystemSettings systemSettings = new SystemSettings();
			overwriteSystemSettings(systemSettings);
		}

	}

	/**
	 * Overwrite the system settings data file
	 * @param systemSettings System settings data to overwrite with.
	 */
	public void overwriteSystemSettings(SystemSettings systemSettings){
		File temp = new File(FILENAME);
		if(temp.exists()){
			temp.delete();
		}
		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			outputStream.writeObject(systemSettings);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Read the systems settings data file.
	 * @return Returns null if cannot read.
	 */
	public SystemSettings read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			SystemSettings systemSettings = (SystemSettings) inputStream.readObject();
			inputStream.close();
			return systemSettings;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * Sets the MovieDisplayToggle field.
	 */
	public void setMovieDisplayToggle(int value){
		SystemSettings systemSettings = read();
		systemSettings.setMovieDisplayToggle(value);
		overwriteSystemSettings(systemSettings);
	}
}
