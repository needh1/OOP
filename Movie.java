import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable
{	
	private String movieID;
	private String movieTitle;
	private String type;
	private String duration;
	private String status;
	private String synopsis;
	private String director;
	private String cast;
	private int ticketSales;
	private int totalRating;
	private int numRatings;
	private float avgRating;
	private ArrayList<Review> reviews;

	public Movie() {
		this.movieID = "";
		this.movieTitle = "";
		this.type = "";
		this.duration = "";
		this.status = "";
		this.synopsis = "";
		this.director = "";
		this.cast = "";
		this.ticketSales = 0;
		this.totalRating = 0;
		this.numRatings = 0;
		this.avgRating = 0;
		this.reviews = null;
	}

	public Movie(String id, String title, String type, String duration, String status, String synopsis, 
			String director, String cast, int sales, int totalRating, int numRatings, int avgRating,
			ArrayList<Review> reviews) {
		this.movieID = id;
		this.movieTitle = title;
		this.type = type;
		this.duration = duration;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.ticketSales = sales;
		this.totalRating = totalRating;
		this.numRatings = numRatings;
		this.avgRating = avgRating;
		this.reviews = reviews;
	}

	public String getMovieId() {
		return movieID;
	}

	public String getMovietitle() {
		return movieTitle;
	}

	public String getType() {
		return type;
	}

	public String getDuration() {
		return duration;
	}

	public String getStatus() {
		return status;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getDirector() {
		return director;
	}

	public String getCast() {
		return cast;
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public int getTotalRating() {
		return totalRating;
	}
	
	public int getNumRatings() {
		return numRatings;
	}
	
	public float getAvgRating() {
		return avgRating;
	}
	
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public void setMovieID(String id) {
		this.movieID = id;
	}
	
	public void setMovietitle(String title) {
		this.movieTitle = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public void setTicketSales(int sales) {
		this.ticketSales = sales;
	}

	public void addTicketSales(int tickets) {
		this.ticketSales += tickets;
	}

	public void setTotalRating(int total) {
		this.totalRating = total;
	}

	public void addTotalRating(int rating) {
		this.totalRating += rating;
	}
	
	public void setNumRatings(int num) {
		this.numRatings = num;
	}

	public void incNumRatings() {
		this.numRatings++;
	}
	
	public void setAvgRating(int rating, int num) {
		this.avgRating = rating / num;
	}
	
	//WIP
	public void addReview() {
		
	}
}
