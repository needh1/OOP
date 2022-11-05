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

        } catch (IOException e){

        }
        return new ArrayList<Booking>();
    }

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