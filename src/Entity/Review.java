package Entity;

import java.io.Serializable;

/**
 * This Review class contains data about itself. Reviews are contained in each Movie.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class Review implements Serializable {
	private String author;
	private String reviewText;
	private int reviewScore;

	/**
	 * Constructor for a Review.
	 * @param author Username of MovieGoer that wrote this review.
	 * @param reviewText Content of review.
	 * @param reviewScore Score of review.
	 */
	public Review(String author, String reviewText, int reviewScore) {
		this.author = author;
		this.reviewText = reviewText;
		this.reviewScore = reviewScore;
	}

	/**
	 * Get the username of MovieGoer that wrote this review.
	 * @return Username of MovieGoer that wrote this review.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the username of MovieGoer that wrote this review.
	 * @param author Username of MovieGoer that wrote this review.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the content of the review.
	 * @return Content of the review.
	 */
	public String getReviewText() {
		return reviewText;
	}

	/**
	 * Set the content of the review.
	 * @param reviewText Content of the review.
	 */
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	/**
	 * Get the review's score.
	 * @return The review's score.
	 */
	public int getReviewScore() {
		return reviewScore;
	}

	/**
	 * Set the review's score.
	 * @param reviewScore The review's score.
	 */
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
}
