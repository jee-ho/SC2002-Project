package Controller;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Entity.*;
import ExceptionPackage.ExistingCineplexException;
import ExceptionPackage.LessThan3CinemasException;

public class CineplexController {
	public final static String FILENAME = "database.txt";

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
	public void renameCineplex(String oldName, String newName){
		ArrayList<Cineplex> cineplexes = read();
		ArrayList<Cineplex> returnList = new ArrayList<Cineplex>();

		for(int i=0; i<cineplexes.size(); i++){
			Cineplex cin = cineplexes.get(i);
			if(cin.getName().equals(oldName)){
				cin.setName(newName);
			}
			returnList.add(cin);
		}
		overwriteCineplexList(FILENAME, returnList);
	}
	public void deleteCineplex(String name){
		ArrayList<Cineplex> cineplexes = read();
		ArrayList<Cineplex> returnList = new ArrayList<Cineplex>();

		for(int i=0; i<cineplexes.size(); i++){
			Cineplex cin = cineplexes.get(i);
			if(!cin.getName().equals(name)){
				returnList.add(cin);
			}
		}
		overwriteCineplexList(FILENAME, returnList);

	}

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
}
