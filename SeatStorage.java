import java.util.*;
import java.io.*;

public class SeatStorage {
    public final static String FILENAME = "seat.txt";

    public void writeObject(Seat seat) {
        ArrayList<Seat> allData = new ArrayList<Seat>();
        File tempFile = new File(FILENAME);
        if (tempFile.exists()) 
            allData = read();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
            allData.add(seat);
            out.writeObject(allData);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Seat> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Seat> cineplexListing = (ArrayList<Seat>) ois.readObject();
            ois.close();
            return cineplexListing;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Seat>();
    }; 
}
