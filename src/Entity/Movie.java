package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Movie implements Serializable {
	private String title;
	private ShowStatus status;
	private String synopsis;
	private String director;
	private String[] cast;
	private ArrayList<Review> reviews;
	private MovieType type;
	private int duration;
	private MovieRating rating;

	public Movie(String title, ShowStatus status, String synopsis, String director, String[] cast, MovieType type, int duration, MovieRating rating) {
		this.title = title;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		//this.reviews = reviews;
		this.reviews = new ArrayList<Review>();	//by default, initialise with no reviews
		this.type = type;
		this.duration = duration;
		this.rating = rating;
	}

	public enum ShowStatus{
		PREVIEW("preview"),
		NOWSHOWING("nowshowing"),
		COMINGSOON("comingsoon"),
		ENDOFSHOWING("endofshowing");
		private final String text;
		ShowStatus(final String text){
			this.text = text;
		}
		public String toString(){
			return text;
		}
	}

	public enum MovieType{
		TYPE_REGULAR("regular"),
		TYPE_3D("3D");
		private final String text;
		MovieType(final String text){
			this.text = text;
		}
		public String toString(){
			return text;
		}
	}

	public enum MovieRating{
		G("G"),
		PG("PG"),
		PG13("PG13"),
		NC16("NC16"),
		M18("M18"),
		R21("R21");
		private final String text;
		MovieRating(final String text){
			this.text = text;
		}
		public String toString(){
			return text;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ShowStatus getStatus() {
		return status;
	}

	public void setStatus(ShowStatus status) {
		this.status = status;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public MovieType getType() {
		return type;
	}

	public void setType(MovieType type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public MovieRating getRating() {
		return rating;
	}

	public void setRating(MovieRating rating) {
		this.rating = rating;
	}

	public String toString(){
		String outputString = "";
		outputString = "Movie: " + title +  "\n" +
						" status: " + status + "\n" +
						" synopsis: " + synopsis + "\n" +
						" director: " + director + "\n" +
						" cast: " + Arrays.toString(cast) + "\n" +
						" type: " + type + "\n" +
						" rating: " + rating + "\n" +
						" reviews: \n";
		if(reviews != null && reviews.size() != 0){
			for(Review rev : reviews){
				outputString += "  author: " + rev.getAuthor() + "\n"
				+ "  review: " + rev.getReviewText() + "\n"
				+ "  score: " + rev.getReviewScore() + "\n";
			}
		}
		return outputString;
	}
}
