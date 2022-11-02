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
	private ArrayList<Integer> reviewRating;
	private ArrayList<String> reviewContent;

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
	}

	public Movie(String id, String title, String type, String duration, String status, String synopsis, 
			String director, String cast, int sales) {
		this.movieID = id;
		this.movieTitle = title;
		this.type = type;
		this.duration = duration;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.ticketSales = sales;
	}

	public String getMovieID() {
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

	public void incTicketSales() {
		this.ticketSales++;
	}

	public void addReview(int rating, String content) {
		reviewRating.add(rating);
		reviewContent.add(content);
	}
	
	public int numReview() {
		return reviewRating.size();
	}
	
	public int avgRating() {
		int total = 0;
		for(int r : reviewRating)
		    total += r;
		return total / numReview();
	}

}
