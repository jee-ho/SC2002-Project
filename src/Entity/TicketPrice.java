package Entity;

import java.io.*;

/**
 * This TicketPrice class contains pricing data.
 */
public class TicketPrice implements Serializable {

	private double SeniorCitizenWeekday = 4.00;
	private double StudentWeekday = 7.00;
	private double StudentWeekday3D = 9.00;
	private double MonWed = 8.50;
	private double MonWed3D = 11.00;
	private double Thu = 9.50;
	private double Thu3D = 11.00;
	private double FriAft = 9.50;
	private double FriAft3D = 15.00;
	private double FriEve = 15.00;
	private double FriEve3D = 15.00;
	private double Weekend = 11.00;
	private double Weekend3D = 15.00;
	private double Card = 9.50;


	/**
	 * Get price for Senior Citizens on Weekdays.
	 * @return Price for Senior Citizens on Weekdays.
	 */
	public double getSeniorCitizenWeekday() {
		return SeniorCitizenWeekday;
	}

	/**
	 * Set price for Senior Citizens on Weekdays.
	 * @param seniorCitizenWeekday Price for Senior Citizens on Weekdays.
	 */
	public void setSeniorCitizenWeekday(double seniorCitizenWeekday) {
		SeniorCitizenWeekday = seniorCitizenWeekday;
	}
	/**
	 * Get price for Students on Weekdays.
	 * @return Price for Students on Weekdays.
	 */
	public double getStudentWeekday() {
		return StudentWeekday;
	}

	/**
	 * Set price for Students on Weekdays.
	 * @param studentWeekday Price for Students on Weekdays.
	 */
	public void setStudentWeekday(double studentWeekday) {
		StudentWeekday = studentWeekday;
	}
	/**
	 * Get price for Students on Weekdays for 3D Movie.
	 * @return Price for Students on Weekdays for 3D Movie.
	 */
	public double getStudentWeekday3D() {
		return StudentWeekday3D;
	}
	/**
	 * Set price for Students on Weekdays for 3D Movie.
	 * @param studentWeekday3D Price for Students on Weekdays for 3D Movie.
	 */
	public void setStudentWeekday3D(double studentWeekday3D) {
		StudentWeekday3D = studentWeekday3D;
	}
	/**
	 * Get price for Mondays to Wednesdays.
	 * @return Price for Mondays to Wednesdays.
	 */
	public double getMonWed() {
		return MonWed;
	}
	/**
	 * Set price for Mondays to Wednesdays.
	 * @param monWed Price for Mondays to Wednesdays.
	 */
	public void setMonWed(double monWed) {
		MonWed = monWed;
	}
	/**
	 * Get price for Mondays to Wednesdays for 3D Movie.
	 * @return Price for Mondays to Wednesdays for 3D Movie.
	 */
	public double getMonWed3D() {
		return MonWed3D;
	}
	/**
	 * Set price for Mondays to Wednesdays for 3D Movie.
	 * @param monWed3D Price for Mondays to Wednesdays for 3D Movie.
	 */
	public void setMonWed3D(double monWed3D) {
		MonWed3D = monWed3D;
	}
	/**
	 * Get price for Thursdays.
	 * @return Price for Thursdays.
	 */
	public double getThu() {
		return Thu;
	}
	/**
	 * Set price for Thursdays.
	 * @param thu Price for Thursdays.
	 */
	public void setThu(double thu) {
		Thu = thu;
	}
	/**
	 * Get price for Thursdays for 3D Movie.
	 * @return Price for Thursdays for 3D Movie.
	 */
	public double getThu3D() {
		return Thu3D;
	}
	/**
	 * Set price for Thursdays for 3D Movie.
	 * @param thu3D Price for Thursdays for 3D Movie.
	 */
	public void setThu3D(double thu3D) {
		Thu3D = thu3D;
	}
	/**
	 * Get price for Friday before 6pm.
	 * @return Price for Friday before 6pm.
	 */
	public double getFriAft() {
		return FriAft;
	}

	/**
	 * Set price for Friday before 6pm.
	 * @param friAft Price for Friday before 6pm.
	 */
	public void setFriAft(double friAft) {
		FriAft = friAft;
	}
	/**
	 * Get price for Friday before 6pm for 3D Movie.
	 * @return Price for Friday before 6pm for 3D Movie.
	 */
	public double getFriAft3D() {
		return FriAft3D;
	}
	/**
	 * Set price for Friday before 6pm for 3D Movie.
	 * @param friAft3D Price for Friday before 6pm for 3D Movie.
	 */
	public void setFriAft3D(double friAft3D) {
		FriAft3D = friAft3D;
	}
	/**
	 * Get price for Friday after 6pm.
	 * @return Price for Friday after 6pm.
	 */
	public double getFriEve() {
		return FriEve;
	}
	/**
	 * Set price for Friday after 6pm.
	 * @param friEve Price for Friday after 6pm.
	 */
	public void setFriEve(double friEve) {
		FriEve = friEve;
	}
	/**
	 * Get price for Friday after 6pm for 3D movie.
	 * @return Price for Friday after 6pm for 3D movie.
	 */
	public double getFriEve3D() {
		return FriEve3D;
	}
	/**
	 * Set price for Friday after 6pm for 3D movie.
	 * @param friEve3D Price for Friday after 6pm for 3D movie.
	 */
	public void setFriEve3D(double friEve3D) {
		FriEve3D = friEve3D;
	}
	/**
	 * Get price for Weekend.
	 * @return Price for Weekend.
	 */
	public double getWeekend() {
		return Weekend;
	}
	/**
	 * Set price for Weekend.
	 * @param weekend  Price for Weekend.
	 */
	public void setWeekend(double weekend) {
		Weekend = weekend;
	}
	/**
	 * Get price for Weekend for 3D movie.
	 * @return Price for Weekend for 3D movie.
	 */
	public double getWeekend3D() {
		return Weekend3D;
	}
	/**
	 * Set price for Weekend for 3D movie.
	 * @param weekend3D Price for Weekend for 3D movie.
	 */
	public void setWeekend3D(double weekend3D) {
		Weekend3D = weekend3D;
	}
	/**
	 * Get price for credit/loyalty card users.
	 * @return Price for credit/loyalty card users.
	 */
	public double getCard() {
		return Card;
	}
	/**
	 * Set price for credit/loyalty card users.
	 * @param card Price for credit/loyalty card users.
	 */
	public void setCard(double card) {
		Card = card;
	}
}
