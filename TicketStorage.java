import java.util.*;
import java.io.*;

/**
 * Represents a storage handler for ticket records.
 * Used to store and retrieve ticket records.
 */
public class TicketStorage extends FileStorage
{
    /**
     * The file where showing records will be stored in.
     */
    public final static String FILENAME = "tickets.txt";
    /**
     * Adds the given ticket record into the storage file.
     * @param o Ticket record to be stored into the file.
     */
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

            }
        }
    }
    /**
     * Retrieves all the ticket records in the storage file.
     * @return {@link Ticket} Returns list of ticket records if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Ticket> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Ticket> ticketList = (ArrayList<Ticket>) ois.readObject();
            ois.close();
            return ticketList;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Ticket>();
    }
    /**
     * Replaces the existing list of ticket records with the given list.
     * @param data new list of ticket records.
     */
    public void replaceExistingFile(ArrayList<Ticket> data){
        File tempFile = new File(FILENAME);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            //
        }
    }
}