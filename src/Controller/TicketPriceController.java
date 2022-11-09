package Controller;

import Entity.TicketPrice;

import java.io.*;

/**
 * Controller for supporting prices data file operations.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-09
 */
public class TicketPriceController {
	public final static String FILENAME = "prices.txt";

	/**
	 * Initialise the prices data file.
	 */
	public void initialisePricesList(){
		File data = new File(FILENAME);
		if(data.exists()){

		} else {
			overwritePricesList(new TicketPrice());
		}

	}

	/**
	 * Overwrite the prices data file with new TicketPrice.
	 * @param ticketPrice New TicketPrice to overwrite with.
	 */
	public void overwritePricesList(TicketPrice ticketPrice){
		File temp = new File(FILENAME);
		if(temp.exists()){
			temp.delete();
		}
		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			outputStream.writeObject(ticketPrice);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Read from the prices data file.
	 * @return TicketPrice in the data file.
	 */
	public TicketPrice read() {

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			TicketPrice ticketPrice = (TicketPrice) inputStream.readObject();
			inputStream.close();
			return ticketPrice;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
}
