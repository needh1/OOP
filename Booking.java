import java.io.*;

public class Booking 
{
    private String name;
    private String email;
    private String ticket_ID;
    private int phone_num;
    private double price;

    public Booking(String name, String email, String ticket_ID, int phone_num, double price){
        this.name = name;
        this.email = email;
        this.ticket_ID = ticket_ID;
        this.phone_num = phone_num;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getTicketID(){
        return ticket_ID;
    }

    public int getPhoneNum(){
        return phone_num;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String Name){
        name = Name;
    }

    public void setEmail(String Email){
        email = Email;
    }

    public void setTicketNum(String TicketID){
        ticket_ID = TicketID;
    }

    public void setPhoneNum(int number){
        phone_num = number;
    }

    public void setPrice(double Price){
        price = Price;
    }

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