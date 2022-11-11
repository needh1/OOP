import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Represents movie object.
 * Contains information such as details, reviews and ticket sales for the movie. 
 */
public class Movie implements Serializable
{	
	/**
	 * ID of movie.
	 */
	private String movieID;
	/**
	 * Title of movie.
	 */
	private String movieTitle;
	/**
	 * Type of movie.
	 */
	private MovieType type;
	/**
	 * Rating of movie.
	 */
	private String movieRating;
	/**
	 * Duration of movie.
	 */
	private double duration;
	/**
	 * Showing status of movie.
	 */
	private String status;
	/**
	 * Synopsis of movie.
	 */
	private String synopsis;
	/**
	 * Director of movie.
	 */
	private String director;
	/**
	 * Cast of movie.
	 */
	private String cast;
	/**
	 * Ticket sales of movie.
	 */
	private int ticketSales;
	/**
	 * List of reviews for movie.
	 */
	private ArrayList<Review> reviewList;
	/**
	 * Constructor for Movie object.
	 */
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
	/**
	 * Constructor for Movie object.
	 * @param id Movie ID.
	 * @param title Movie title.
	 * @param type Movie type.
	 * @param movieRating Movie rating.
	 * @param duration Movie duration.
	 * @param status Showing status of movie.
	 * @param synopsis Movie synopsis.
	 * @param director Movie's director.
	 * @param cast Movie's cast.
	 * @param sales Movie's ticket sales.
	 */
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
	/**
	 * Retrieves movie ID.
	 * @return Movie ID.
	 */
	public String getMovieID(){
		return movieID;
	}
	/**
	 * Retrieves movie title.
	 * @return Movie title.
	 */
	public String getMovieTitle(){
		return movieTitle;
	}
	/**
	 * Retrieves movie type.
	 * @return Movie type.
	 */
	public MovieType getType(){
		return type;
	}
	/**
	 * Retrieves movie rating.
	 * @return Movie rating.
	 */
	public String getMovieRating(){
		return movieRating;
	}
	/**
	 * Retrieves movie duration.
	 * @return Movie duration.
	 */
	public double getDuration(){
		return duration;
	}
	/**
	 * Retrieves movie showing status.
	 * @return Movie showing status.
	 */
	public String getStatus(){
		return status;
	}
	/**
	 * Retrieves movie synopsis.
	 * @return Movie synopsis.
	 */
	public String getSynopsis(){
		return synopsis;
	}
	/**
	 * Retrieves movie director.
	 * @return Movie director.
	 */
	public String getDirector(){
		return director;
	}
	/**
	 * Retrieves movie cast.
	 * @return Movie cast.
	 */
	public String getCast(){
		return cast;
	}
	/**
	 * Retrieves movie ticket sales.
	 * @return Movie ticket sales.
	 */
	public int getTicketSales(){
		return ticketSales;
	}
	/**
	 * Retrieves review list of movie.
	 * @return Review list of movie.
	 */
	public ArrayList<Review> getReviewList(){
		return reviewList;
	}
	/**
	 * Sets movie ID.
	 * @param id Movie ID.
	 */
	public void setMovieID(String id){
		this.movieID = id;
	}
	/**
	 * Sets movie title.
	 * @param title Movie title.
	 */
	public void setMovietitle(String title){
		this.movieTitle = title;
	}
	/**
	 * Sets movie type.
	 * @param type Movie type.
	 */
	public void setType(MovieType type){
		this.type = type;
	}
	/**
	 * Sets movie rating.
	 * @param movieRating Movie rating.
	 */
	public void setMovieRating(String movieRating){
		this.movieRating = movieRating;
	}
	/**
	 * Sets movie duration
	 * @param duration Movie duration.
	 */
	public void setDuration(double duration){
		this.duration = duration;
	}
	/**
	 * Sets movie status.
	 * @param status Movie status.
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * Sets movie synopsis.
	 * @param synopsis Movie synopsis.
	 */
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}
	/**
	 * Sets movie director.
	 * @param director Movie director.
	 */
	public void setDirector(String director){
		this.director = director;
	}
	/**
	 * Sets movie cast.
	 * @param cast Movie cast.
	 */
	public void setCast(String cast){
		this.cast = cast;
	}
	/**
	 * Sets movie ticket sales.
	 * @param sales Movie ticket sales.
	 */
	public void setTicketSales(int sales){
		this.ticketSales = sales;
	}
	/**
	 * Increase movie ticket sales.
	 */
	public void incTicketSales(){
		this.ticketSales++;
	}
	/**
	 * Adds review of movie.
	 * @param rating Review rating.
	 * @param content Review content.
	 */
	public void addReview(int rating, String content){
		Review newReview = new Review(rating, content);
		reviewList.add(newReview);
	}
	/**
	 * Retrieves number of reviews.
	 * @return Number of reviews.
	 */
	public int numReview(){
		return reviewList.size();
	}
	/**
	 * Calculates average rating of reviews.
	 * @return Average rating of reviews.
	 */
	public double avgRating(){
		int total = 0;
		for(Review r : reviewList)
		    total += r.getReviewRating();
		return total / numReview();
	}
	/**
	 * Sorts movies by ticket sales.
	 */
	public static Comparator<Movie> COMPARE_BY_SALES = new Comparator<Movie>(){
        public int compare(Movie one, Movie other) {
            return Integer.compare(one.ticketSales, other.ticketSales);
        }
    };
	/**
	 * Sorts movies by average review ratings.
	 */
    public static Comparator<Movie> COMPARE_BY_RATINGS = new Comparator<Movie>(){
        public int compare(Movie one, Movie other) {
            return Double.compare(one.avgRating(), other.avgRating());
        }
    };
}