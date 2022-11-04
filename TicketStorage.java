import java.util.*;
import java.io.*;


public class TicketStorage extends FileStorage
{
    public final static String FILENAME = "tickets.txt";

    public void writeObject(Object o) {
        if(o instanceof Ticket){
            Ticket ticket = (Ticket) o;
            ArrayList<Ticket> allData = new ArrayList<Ticket>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(ticket);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Ticket> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Ticket> ticketList = (ArrayList<Ticket>) ois.readObject();
            ois.close();
            return ticketList;
        } catch (ClassNotFoundException e) {
            System.out.println("Object does not exist.");
        } catch (IOException e){
            System.out.println("File does not exist.");
        }
        return new ArrayList<Ticket>();
    }
}
