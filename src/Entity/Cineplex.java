package Entity;

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
	private String name;
	private ArrayList<Cinema> cinemaList;

	/**
	 * Constructor for a Cineplex.
	 * @param name The name of the cineplex
	 * @param cinemaList An ArrayList containing at least 3 Cinema objects.
	 */
	public Cineplex(String name, ArrayList<Cinema> cinemaList){
		this.name = name;
		this.cinemaList = cinemaList;
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
		outputString += "Cineplex \"" + name +  "\"\n";
		for(int i=0; i<cinemaList.size(); i++){
			Cinema currentCinema = getCinemaList().get(i);
			outputString += i + " (" + currentCinema.getCinemaType() + "): \"" + currentCinema.getName() + "\", codename " + currentCinema.getNameCode() + "\n";
		}
		return outputString;
	}
}


