package Controller;

import Entity.TicketPrice;

import java.io.*;

public class TicketPriceController {
	public final static String FILENAME = "prices.txt";

	public void initialisePricesList(){
		File data = new File(FILENAME);
		if(data.exists()){

		} else {
			overwritePricesList(new TicketPrice());
		}

	}
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
