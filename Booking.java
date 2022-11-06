import java.io.*;
/**
 * Represents a booking entry.
 * Stores the personal details of the movie-goer and purchase information.
 */
public class Booking implements Serializable
{
    /**
     * Name of movie-goer.
     */
    private String name;
    /**
     * Email of movie-goer.
     */
    private String email;
    /**
     * Ticket ID of movie-goer.
     */
    private String ticket_ID;
    /**
     * Phone number of movie-goer.
     */
    private int phone_num;
    /**
     * Price of purchased ticket.
     */
    private double price;

    /**
     * Constructor for Booking object.
     * @param name Movie-goer's name.
     * @param email Movie-goer's email
     * @param ticket_ID Movie-goer's ticket ID.
     * @param phone_num Movie-goer's phone number.
     * @param price Ticket price.
     */
    public Booking(String name, String email, String ticket_ID, int phone_num, double price){
        this.name = name;
        this.email = email;
        this.ticket_ID = ticket_ID;
        this.phone_num = phone_num;
        this.price = price;
    }
    /**
     * Gets movie-goer name.
     * @return Movie-goer's name.
     */
    public String getName(){
        return name;
    }
    /**
     * Gets movie-goer email.
     * @return Movie-goer's email.
     */
    public String getEmail(){
        return email;
    }
    /**
     * Gets ticket ID.
     * @return ticket ID.
     */
    public String getTicketID(){
        return ticket_ID;
    }
    /**
     * Gets movie-goer phone number.
     * @return Movie-goer's phone number.
     */
    public int getPhoneNum(){
        return phone_num;
    }
    /**
     * Gets ticket price.
     * @return Ticket price.
     */
    public double getPrice(){
        return price;
    }
    /**
     * Sets movie-goer's name.
     * @param Name
     */
    public void setName(String Name){
        name = Name;
    }
    /**
     * Sets movie-goer's email.
     * @param Email
     */
    public void setEmail(String Email){
        email = Email;
    }
    /**
     * Sets ticket ID.
     * @param TicketID
     */
    public void setTicketNum(String TicketID){
        ticket_ID = TicketID;
    }
    /**
     * Sets movie-goer's phone number.
     * @param number
     */
    public void setPhoneNum(int number){
        phone_num = number;
    }
    /**
     * Sets ticket price.
     * @param Price
     */
    public void setPrice(double Price){
        price = Price;
    }
    /**
     * Displays booking information.
     */
    public void display(){
        System.out.println("x----.............Booking Details............----x");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.printf("|        Transaction ID: %-22s  |\n", getTicketID());
		System.out.printf("|        Name: %-33s |\n", getName());
		System.out.printf("|        Phone: %-32d |\n", getPhoneNum());
		System.out.printf("|        Email: %-32s |\n", getEmail());
		System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }
}