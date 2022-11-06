import java.util.*;
import java.io.*;

/**
 * Represents a storage handler for Cineplexes.
 * Used to store and retrieve Cineplexes.
 */
public class CineplexStorage extends FileStorage
{
    /**
     * The file where cineplex information will be stored in.
     */
    public final static String FILENAME = "cineplex.txt";

    /**
     * Adds the given cineplex into the storage file.
     * @param o Cineplex information to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Cineplex){
            Cineplex cineplex = (Cineplex) o;
            ArrayList<Cineplex> allData = new ArrayList<Cineplex>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(cineplex);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }

    /**
     * Retrieves all the cineplexes in the storage file.
     * @return {@link Cineplex} Returns list of cineplexes if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Cineplex> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Cineplex> cineplexListing = (ArrayList<Cineplex>) ois.readObject();
            ois.close();
            return cineplexListing;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Cineplex>();
    }
}
