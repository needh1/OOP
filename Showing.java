import java.io.Serializable;
import java.time.*;
/**
 * Represents a showing for a movie.
 * Stores the details of the location and timing of the movie showing.
 */
public class Showing implements Serializable
{
    /**
     * ID of showing.
     */
    private String showingID;
    /**
     * Title of movie.
     */
    private String movieTitle;
    /**
     * Name of cineplex.
     */
    private String cineplexName;
    /**
     * Seating layout for the showing.
     */
    SeatLayout seating;
    /**
     * Date of showing.
     */
    LocalDate date;
    /**
     * Time of movie.
     */
    LocalTime time;

    /**
     * Constructor for Showing object.
     * @param id Showing ID.
     * @param title Movie title.
     * @param cineplex Cineplex name.
     * @param layout Seating layout.
     * @param date Showing Date.
     * @param time Showing Time.
     */
    public Showing(String id, String title, String cineplex, SeatLayout layout, LocalDate date, LocalTime time){
        showingID = id;
        movieTitle = title;
        cineplexName = cineplex;
        seating = layout;
        this.date = date;
        this.time = time;
    }
    /**
     * Retrieves showing ID.
     * @return Showing ID.
     */
    public String getShowingID(){
        return showingID;
    }
    /**
     * Sets showing ID.
     * @param id Showing ID.
     */
    public void setShowingID(String id){
        showingID = id;
    }
    /**
     * Retrieves movie title.
     * @return Movie title.
     */
    public String getMovieTitle(){
        return movieTitle;
    }
    /**
     * Sets movie title.
     * @param id Movie title.
     */
    public void setMovieTitle(String id){
        movieTitle = id;
    }
    /**
     * Retrieves cineplex name.
     * @return Cineplex name.
     */
    public String getCineplexName(){
        return cineplexName;
    }
    /**
     * Sets cineplex name.
     * @param name Cineplex name.
     */
    public void setCineplexName(String name){
        cineplexName = name;
    }
    /**
     * Retrieves seating layout.
     * @return Seating layout.
     */
    public SeatLayout getSeating(){
        return seating;
    }
    /**
     * Sets seating layout.
     * @param layout Seating layout.
     */
    public void setSeating(SeatLayout layout){
        seating = layout;
    }
    /**
     * Retrieves showing date.
     * @return Showing date.
     */
    public LocalDate getDate(){
        return date;
    }
    /**
     * Sets showing date.
     * @param date Showing date.
     */
    public void setDate(LocalDate date){
        this.date = date;
    }
    /**
     * Retrieves showing time.
     * @return Showing time.
     */
    public LocalTime getTime(){
        return time;
    }
    /**
     * Sets showing time.
     * @param time Showing time.
     */
    public void setTime(LocalTime time){
        this.time = time;
    }
    /**
     * Displays showing information.
     */
    public void display(){
        System.out.println("Movie title: " + movieTitle +
                            " | Cineplex: " + cineplexName +
                            " | Cinema: " + seating.getCode() +
                            " | " + time + ", " + date);
    }
}
