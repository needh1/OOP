import java.io.Serializable;
import java.time.*;

public class Showing implements Serializable
{
    private String showingID;
    private String movieTitle;
    private String cineplexName;
    SeatLayout seating;
    LocalDate date;
    LocalTime time;

    public Showing(String id, String title, String cineplex, SeatLayout layout, LocalDate date, LocalTime time){
        showingID = id;
        movieTitle = title;
        cineplexName = cineplex;
        seating = layout;
        this.date = date;
        this.time = time;
    }

    public String getShowingID(){
        return showingID;
    }

    public void setShowingID(String id){
        showingID = id;
    }

    public String getMovieTitle(){
        return movieTitle;
    }

    public void setMovieTitle(String id){
        movieTitle = id;
    }

    public String getCineplexName(){
        return cineplexName;
    }

    public void setCineplexName(String name){
        cineplexName = name;
    }

    public SeatLayout getSeating(){
        return seating;
    }

    public void setSeating(SeatLayout layout){
        seating = layout;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalTime getTime(){
        return time;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    public void display(){
        System.out.println("Showing ID: " + showingID +
                            "Movie title: " + movieTitle +
                            " | Cineplex: " + cineplexName +
                            " | Cinema: " + seating.getCode() +
                            " | " + time + ", " + date);
    }
}
