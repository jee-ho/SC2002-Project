package Entity;

import java.io.*;

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


	public double getSeniorCitizenWeekday() {
		return SeniorCitizenWeekday;
	}

	public void setSeniorCitizenWeekday(double seniorCitizenWeekday) {
		SeniorCitizenWeekday = seniorCitizenWeekday;
	}

	public double getStudentWeekday() {
		return StudentWeekday;
	}

	public void setStudentWeekday(double studentWeekday) {
		StudentWeekday = studentWeekday;
	}

	public double getStudentWeekday3D() {
		return StudentWeekday3D;
	}

	public void setStudentWeekday3D(double studentWeekday3D) {
		StudentWeekday3D = studentWeekday3D;
	}

	public double getMonWed() {
		return MonWed;
	}

	public void setMonWed(double monWed) {
		MonWed = monWed;
	}

	public double getMonWed3D() {
		return MonWed3D;
	}

	public void setMonWed3D(double monWed3D) {
		MonWed3D = monWed3D;
	}

	public double getThu() {
		return Thu;
	}

	public void setThu(double thu) {
		Thu = thu;
	}

	public double getThu3D() {
		return Thu3D;
	}

	public void setThu3D(double thu3D) {
		Thu3D = thu3D;
	}

	public double getFriAft() {
		return FriAft;
	}

	public void setFriAft(double friAft) {
		FriAft = friAft;
	}

	public double getFriAft3D() {
		return FriAft3D;
	}

	public void setFriAft3D(double friAft3D) {
		FriAft3D = friAft3D;
	}

	public double getFriEve() {
		return FriEve;
	}

	public void setFriEve(double friEve) {
		FriEve = friEve;
	}

	public double getFriEve3D() {
		return FriEve3D;
	}

	public void setFriEve3D(double friEve3D) {
		FriEve3D = friEve3D;
	}

	public double getWeekend() {
		return Weekend;
	}

	public void setWeekend(double weekend) {
		Weekend = weekend;
	}

	public double getWeekend3D() {
		return Weekend3D;
	}

	public void setWeekend3D(double weekend3D) {
		Weekend3D = weekend3D;
	}

	public double getCard() {
		return Card;
	}

	public void setCard(double card) {
		Card = card;
	}
}
