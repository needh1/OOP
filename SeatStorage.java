import java.util.*;
import java.io.*;

public class SeatStorage extends FileStorage {
    public final static String FILENAME = "seat.txt";

    public void writeObject(Object o) {
        if(o instanceof Seat){
            Seat seat = (Seat) o;
            ArrayList<Seat> allData = new ArrayList<Seat>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(seat);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    }
}
