package Entity;

import java.io.Serializable;

public class Review implements Serializable {
	private String author;
	private String reviewText;
	private int reviewScore;

	public Review(String author, String reviewText, int reviewScore) {
		this.author = author;
		this.reviewText = reviewText;
		this.reviewScore = reviewScore;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
}
