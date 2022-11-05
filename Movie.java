import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable
{	
	private String movieID;
	private String movieTitle;
	private MovieType type;
	private double duration;
	private String status;
	private String synopsis;
	private String director;
	private String cast;
	private int ticketSales;
	private ArrayList<Review> reviewList;
	
	public Movie() {
		this.movieID = "";
		this.movieTitle = "";
		this.type = MovieType._2D;
		this.duration = 0;
		this.status = "";
		this.synopsis = "";
		this.director = "";
		this.cast = "";
		this.ticketSales = 0;
		this.reviewList = new ArrayList<>();

	}

	public Movie(String id, String title, MovieType type, double duration, String status, String synopsis, 
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
		this.reviewList = new ArrayList<>();
	}

	public String getMovieID() {
		return movieID;
	}

	public String getMovietitle() {
		return movieTitle;
	}

	public MovieType getType() {
		return type;
	}

	public double getDuration() {
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
	
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}
	
	public void setMovieID(String id) {
		this.movieID = id;
	}
	
	public void setMovietitle(String title) {
		this.movieTitle = title;
	}

	public void setType(MovieType type) {
		this.type = type;
	}

	public void setDuration(double duration) {
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
		Review newReview = new Review(rating, content);
		reviewList.add(newReview);
	}
	
	public int numReview() {
		return reviewList.size();
	}
	
	public int avgRating() {
		int total = 0;
		for(Review r : reviewList)
		    total += r.getReviewRating();
		return total / numReview();
	}
	
}