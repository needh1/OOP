import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Movie implements Serializable
{	
	private String movieID;
	private String movieTitle;
	private MovieType type;
	private String movieRating;
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
		this.movieRating = "";
		this.duration = 0;
		this.status = "";
		this.synopsis = "";
		this.director = "";
		this.cast = "";
		this.ticketSales = 0;
		this.reviewList = new ArrayList<>();

	}

	public Movie(String id, String title, MovieType type, String movieRating, double duration, String status, String synopsis, 
			String director, String cast, int sales) {
		this.movieID = id;
		this.movieTitle = title;
		this.type = type;
		this.movieRating = movieRating;
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

	public String getMovieTitle() {
		return movieTitle;
	}

	public MovieType getType() {
		return type;
	}

	public String getMovieRating() {
		return movieRating;
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

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
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
	
	public double avgRating() {
		int total = 0;
		for(Review r : reviewList)
		    total += r.getReviewRating();
		return total / numReview();
	}
	
	public static Comparator<Movie> COMPARE_BY_SALES = new Comparator<Movie>() {
        public int compare(Movie one, Movie other) {
            return Integer.compare(one.ticketSales, other.ticketSales);
        }
    };

    public static Comparator<Movie> COMPARE_BY_RATINGS = new Comparator<Movie>() {
        public int compare(Movie one, Movie other) {
            return Double.compare(one.avgRating(), other.avgRating());
        }
    };
}