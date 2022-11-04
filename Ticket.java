import java.io.Serializable;
import java.time.*;

public class Ticket implements Serializable
{
    private String ticketID;
    private String movieName;
    private MovieType movieType;
    private CinemaType cinemaType;
    private double price;
    private int seatNo;
    private LocalDate showDate;
    private LocalTime showTime;
    private String cineplexName;

    public Ticket(String ticketID, String movieName, MovieType type, CinemaType cinemaType, double price, int seatNo,
                    LocalDate showDate, LocalTime showTime, String cineplexName){
        this.ticketID = ticketID;
        this.movieName = movieName;
        this.movieType = type;
        this.cinemaType = cinemaType;
        this.price = price;
        this.seatNo = seatNo;
        this.showDate = showDate;
        this.showTime = showTime;
        this.cineplexName = cineplexName;
    }

    public String getTicketID(){
        return ticketID;
    }

    public String getMovieName(){
        return movieName;
    }

    public MovieType getMovieType(){
        return movieType;
    }

    public CinemaType getCinemaType(){
        return cinemaType;
    }

    public double getPrice(){
        return price;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public LocalDate getDate(){
        return showDate;
    }

    public LocalTime getTime(){
        return showTime;
    }

    public String getCineplexName(){
        return cineplexName;
    }

    public void setTicketID(String id){
        ticketID = id;
    }

    public void setMovieName(String name){
        movieName = name;
    }

    public void setMovieType(MovieType type){
        movieType = type;
    }

    public void setCinemaType(CinemaType type){
        cinemaType = type;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setSeatNo(int num){
        seatNo = num;
    }

    public void setDate(LocalDate date){
        showDate = date;
    }

    public void setTime(LocalTime time){
        showTime = time;
    }

    public void setCineplexName(String name){
        cineplexName = name;
    }

    public double getPrice(PricingType type){
        PriceStorage storage = new PriceStorage();
        Price price = storage.read();
        return price.getPrice(type);
    }
}
