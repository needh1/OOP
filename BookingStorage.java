import java.util.*;
import java.io.*;


public class BookingStorage extends FileStorage
{
    public final static String FILENAME = "bookings.txt";

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
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Booking> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Booking> bookingList = (ArrayList<Booking>) ois.readObject();
            ois.close();
            return bookingList;
        } catch (ClassNotFoundException e) {
            System.out.println("Object does not exist.");
        } catch (IOException e){
            System.out.println("File does not exist.");
        }
        return new ArrayList<Booking>();
    }
}
