import java.util.*;
import java.io.*;

/**
 * Represents a storage handler for booking records.
 * Used to store and retrieve booking records.
 */
public class BookingStorage extends FileStorage
{
    /**
     * The file where booking records will be stored in.
     */
    public final static String FILENAME = "bookings.txt";
    
    /**
     * Adds the given booking record into the storage file.
     * @param o Booking record to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Booking){
            Booking booking = (Booking) o;
            ArrayList<Booking> allData = new ArrayList<Booking>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(booking);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }

    /**
     * Retrieves all the booking records in the storage file.
     * @return {@link Booking} Returns list of booking records if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Booking> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Booking> bookingList = (ArrayList<Booking>) ois.readObject();
            ois.close();
            return bookingList;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Booking>();
    }
    /**
     * Replaces the existing list of booking records with the given list.
     * @param data new list of booking records.
     */
    public void replaceExistingFile(ArrayList<Booking> data){
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