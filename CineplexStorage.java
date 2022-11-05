import java.util.*;
import java.io.*;


public class CineplexStorage extends FileStorage
{
    public final static String FILENAME = "cineplex.txt";

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
