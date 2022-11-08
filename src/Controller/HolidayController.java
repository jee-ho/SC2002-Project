package Controller;

import Entity.Holidays;
import Entity.TicketPrice;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HolidayController {
	public final static String FILENAME = "holidays.txt";
	public void initialiseHolidays(){
		File data = new File(FILENAME);
		if(data.exists()){

		} else {
			Holidays holidays = new Holidays();
			overwriteHolidaysList(holidays);
		}

	}

	public void overwriteHolidaysList(Holidays holidays){
		File temp = new File(FILENAME);
		if(temp.exists()){
			temp.delete();
		}
		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			outputStream.writeObject(holidays);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public Holidays read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			Holidays holidays = (Holidays) inputStream.readObject();
			inputStream.close();
			return holidays;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public boolean isPH(LocalDateTime dateTime) {
		Holidays holidays = read();
		for(LocalDate holiday : holidays.getHolidayList()){
			LocalDate holidayEve = holiday.minusDays(1);
			if((dateTime.truncatedTo(ChronoUnit.DAYS).compareTo(holiday.atStartOfDay()) == 0) || (dateTime.truncatedTo(ChronoUnit.DAYS).compareTo(holidayEve.atStartOfDay()) == 0)){
				return true;
			}
		}
		return false;
	}
}
