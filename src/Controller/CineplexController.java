package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.*;
import ExceptionPackage.ExistingCineplexException;
import ExceptionPackage.LessThan3CinemasException;

/**
 * Controller for interfacing with Cineplex objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-03
 */
public class CineplexController {
	public final static String FILENAME = "cineplexes.txt";

	/**
	 * Creates a new cineplex.
	 * @param name Name of cineplex.
	 * @param cinemaList ArrayList of Cinemas to be added to this cineplex.
	 * @throws LessThan3CinemasException Cineplex cannot have less than 3 Cinemas.
	 * @throws ExistingCineplexException Cineplex with the same name already exists.
	 */
	public void createCineplex(String name, ArrayList<Cinema> cinemaList) throws LessThan3CinemasException, ExistingCineplexException {
		File data = new File(FILENAME);
		ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
		if(data.exists()){
			cineplexes = read();
			if(cineplexes.size()!=0){
				for(int i=0; i<cinemaList.size(); i++){
					if(cineplexes.get(i).getName().equals(name)){
						throw new ExistingCineplexException();
					}
				}
			}

		}

		if(cinemaList.size() < 3){
			throw new LessThan3CinemasException();
		}

		Cineplex cineplexToBeAdded = new Cineplex(name, cinemaList);

		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			cineplexes.add(cineplexToBeAdded);
			outputStream.writeObject(cineplexes);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			//
		}
	}

	/**
	 * Read the cineplex data file.
	 * @return ArrayList of Cineplexes read from file.
	 */
	public ArrayList<Cineplex> read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) inputStream.readObject();
			inputStream.close();
			return cineplexList;
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<Cineplex>();
		}

	}

	/**
	 * Rename an existing cineplex.
	 * @param oldName Old name of the cineplex.
	 * @param newName New name of the cineplex.
	 */
	public void renameCineplex(String oldName, String newName){
		ArrayList<Cineplex> cineplexes = read();
		ArrayList<Cineplex> returnList = new ArrayList<Cineplex>();

		for (Cineplex cin : cineplexes) {
			if (cin.getName().equals(oldName)) {
				cin.setName(newName);
			}
			returnList.add(cin);
		}
		overwriteCineplexList(FILENAME, returnList);
	}

	/**
	 * Delete a cineplex by name.
	 * @param name Name of cineplex to be deleted.
	 */
	public void deleteCineplex(String name){
		ArrayList<Cineplex> cineplexes = read();
		ArrayList<Cineplex> returnList = new ArrayList<Cineplex>();

		for (Cineplex cin : cineplexes) {
			if (!cin.getName().equals(name)) {
				returnList.add(cin);
			}
		}
		overwriteCineplexList(FILENAME, returnList);

	}

	/**
	 * Overwrite new data to the cineplexes data file.
	 * @param filename Filename of the cineplexes data file.
	 * @param data ArrayList of Cineplexes to be written.
	 */
	private void overwriteCineplexList(String filename, ArrayList<Cineplex> data){
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
			System.out.println("caught in cineplexcontroller");
		}
	}

	/**
	 * Get a Cinema object by its codename.
	 * @param searchName Codename of the cinema.
	 * @return Cinema object with this codename.
	 */
	public Cinema getCinemaByCodeName(String searchName){
		ArrayList<Cineplex> cineplexes = read();

		for (Cineplex cinep : cineplexes) {
			for(Cinema cinem : cinep.getCinemaList()){
				if(cinem.getNameCode().equals(searchName)){
					return cinem;
				}
			}
		}
		return null;
	}
}
