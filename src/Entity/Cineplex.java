package Entity;

import ExceptionPackage.CineplexCodeNameException;
import ExceptionPackage.LessThan3CinemasException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This Cineplex class contains data about itself and the cinemas it contains.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-31
 */
public class Cineplex implements Serializable {
	String name;
	String nameCode;
	String address;
	ArrayList<Cinema> cinemaList;

	/**
	 * Constructor for a Cineplex.
	 * @param name The name of the cineplex
	 * @param nameCode A 5-character string representing the cineplex codename
	 * @param address The street address of the cineplex
	 * @param cinemaList An ArrayList containing at least 3 Cinema objects.
	 * @throws LessThan3CinemasException cinemaList is checked to have at least 3 Cinema objects.
	 * @throws CineplexCodeNameException nameCode is checked to be 5 characters long.
	 */
	public Cineplex(String name, String nameCode, String address, ArrayList<Cinema> cinemaList) throws LessThan3CinemasException, CineplexCodeNameException {
		this.name = name;
		this.address = address;

		if(nameCode.length() != 5) {
			throw new CineplexCodeNameException();
		} else {
			this.nameCode = nameCode;
		}
		if(cinemaList.size()<3){
			throw new LessThan3CinemasException();
		} else {
			this.cinemaList = cinemaList;
		}
	}

	/**
	 * Get the name of the cineplex.
	 * @return Name of the cineplex.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the cineplex.
	 * @param name Name of the cineplex.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the codename of the cineplex.
	 * @return Codename of the cineplex.
	 */
	public String getNameCode() {
		return nameCode;
	}

	/**
	 * Set the codename of the cineplex.
	 * @param nameCode Codename of the cineplex.
	 * @throws CineplexCodeNameException nameCode is checked to be 5 characters long.
	 */
	public void setNameCode(String nameCode) throws CineplexCodeNameException {
		if(nameCode.length() != 5) {
			throw new CineplexCodeNameException();
		} else {
			this.nameCode = nameCode;
		}
	}

	/**
	 * Get the street address of the cineplex.
	 * @return Street address of the cineplex.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the street address of the cineplex.
	 * @param address Street address of the cineplex.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the list of cinemas in this cineplex.
	 * @return ArrayList of Cinema objects.
	 */
	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}

	/**
	 * Sets the list of cinemas in this cineplex.
	 * @param cinemaList ArrayList of Cinema objects.
	 * @throws LessThan3CinemasException cinemaList is checked to have at least 3 Cinema objects.
	 */
	public void setCinemaList(ArrayList<Cinema> cinemaList) throws LessThan3CinemasException{
		if(cinemaList.size()<3){
			throw new LessThan3CinemasException();
		} else {
			this.cinemaList = cinemaList;
		}
	}

	/**
	 * Output all of the cineplex data to a string.
	 * @return Output string containing cineplex data.
	 */
	public String toString(){
		String outputString = "";
		outputString += "Cineplex " + name + " with code " + nameCode + "\n";
		outputString += "Located at " + address + "\n";
		outputString += "With cinemas: \n";
		for(int i=0; i<cinemaList.size(); i++){
			Cinema currentCinema = getCinemaList().get(i);
			outputString += i + " (" + currentCinema.cinemaType + "): " + currentCinema.name + " with code " + currentCinema.nameCode + "\n";
		}
		return outputString;
	}
}


