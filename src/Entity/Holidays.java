package Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Holidays implements Serializable {
	private ArrayList<LocalDate> holidayList = new ArrayList<>();

	public void Holidays(){
	}

	public ArrayList<LocalDate> getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(ArrayList<LocalDate> holidayList) {
		this.holidayList = holidayList;
	}
}
