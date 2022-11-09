package Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This Holidays class has a single ArrayList of LocalDate that contains all the holiday dates.
 */
public class Holidays implements Serializable {
	private ArrayList<LocalDate> holidayList = new ArrayList<>();

	/**
	 * Empty constructor for Holidays object. holidayList is already initialised in field declaration.
	 */
	public void Holidays(){
	}

	/**
	 * Get the list of LocalDate holidays
	 * @return ArrayList of holidays in LocalDate form.
	 */
	public ArrayList<LocalDate> getHolidayList() {
		return holidayList;
	}

	/**
	 * Set the list of LocalDate holidays
	 * @param holidayList ArrayList of holidays in LocalDate form.
	 */
	public void setHolidayList(ArrayList<LocalDate> holidayList) {
		this.holidayList = holidayList;
	}
}
