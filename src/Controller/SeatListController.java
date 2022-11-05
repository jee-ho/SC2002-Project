package Controller;

import Entity.Seat;

import Entity.SeatList;
import ExceptionPackage.SeatDoesNotExistException;
import ExceptionPackage.SeatOccupiedException;

public class SeatListController {
	public void printLayout(SeatList seatingPlan){
		Seat[][] tempSeatArray = seatingPlan.getSeatingPlan();
		for(int row = 9; row>= 0; row--){
			for(int col = 0; col<= 18; col++){
				if(col==9)
					System.out.print("  ");			//Make a space for the middle aisle
				if(row == 0){
					if(col<10 && col!=0){
						System.out.print(" ");		//Align single-digit cols preceded by space to match double-digit
					}
					System.out.print(col + " ");	//Print col number with a space after
				}
				if(col == 0&&row!=0){
					char rowChar = 'A';
					switch(row){
						case 1: rowChar = 'A'; break;
						case 2: rowChar = 'B'; break;
						case 3: rowChar = 'C'; break;
						case 4: rowChar = 'D'; break;
						case 5: rowChar = 'E'; break;
						case 6: rowChar = 'F'; break;
						case 7: rowChar = 'G'; break;
						case 8: rowChar = 'H'; break;
						case 9: rowChar = 'I'; break;
						default: rowChar = 'Z'; break;
					}
					System.out.print(rowChar + " ");	//Print row number with a space after
				}
				if(row>0 && col>0){
					if(tempSeatArray[row-1][col-1].isExists() && tempSeatArray[row-1][col-1].isOccupied()){
						System.out.print(" X ");
					} else if(tempSeatArray[row-1][col-1].isExists() && tempSeatArray[row-1][col-1].isCoupleSeat()){
						System.out.print(" C ");	//Mark couple seats
					} else if(tempSeatArray[row-1][col-1].isExists()){
						System.out.print(" O ");	//Mark existing seats
					} else if(!tempSeatArray[row-1][col-1].isExists()){
						System.out.print("   ");	//Show empty space for non-existent seats
					}
				}
			}
			System.out.println();	//Newline every row
		}
	}

	public SeatList bookSeat(SeatList seatingPlan, char rowChar, int col) throws SeatDoesNotExistException, SeatOccupiedException {
		Seat[][] tempSeatArray = seatingPlan.getSeatingPlan();
		int row;
		switch (rowChar) {
			case 'A':
				row = 1;
				break;
			case 'B':
				row = 2;
				break;
			case 'C':
				row = 3;
				break;
			case 'D':
				row = 4;
				break;
			case 'E':
				row = 5;
				break;
			case 'F':
				row = 6;
				break;
			case 'G':
				row = 7;
				break;
			case 'H':
				row = 8;
				break;
			case 'I':
				row = 9;
				break;
			default:
				row = -1;
				break;
		}
		if (row == -1 || col < 1 || col > 18 || !tempSeatArray[row - 1][col - 1].isExists()) {
			throw new SeatDoesNotExistException();
		}
		if (tempSeatArray[row - 1][col - 1].isOccupied()) {
			throw new SeatOccupiedException();
		}
		tempSeatArray[row - 1][col - 1].assignSeat();            //book the seat

		if (tempSeatArray[row - 1][col - 1].isCoupleSeat()) {    //if booking a couple seat, book the other seat also
			if (row % 2 == 0) {
				tempSeatArray[row - 1][col - 2].assignSeat();
			} else {
				tempSeatArray[row - 1][col].assignSeat();
			}
		}

		SeatList returnedList = new SeatList();
		returnedList.setSeatingPlan(tempSeatArray);
		return returnedList;
	}
}
