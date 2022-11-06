import java.util.*;
import java.io.*;

/**
 * Represents a storage handler for movie records.
 * Used to store and retrieve movie records.
 */
public class MovieStorage extends FileStorage
{
    /**
     * The file where movie records will be stored in.
     */
    public final static String FILENAME = "movie.txt";
    /**
     * Adds the given movie record into the storage file.
     * @param o Movie record to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Movie){
            Movie movie = (Movie) o;
            ArrayList<Movie> allData = new ArrayList<Movie>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(movie);
                out.writeObject(allData);
                out.flush();
                out.close();
                System.out.println("Movie added!");
            } catch (IOException e) {

            }
        }
    }
    /**
     * Retrieves all the movie records in the storage file.
     * @return {@link Movie} Returns list of movie records if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Movie> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Movie> movieListing = (ArrayList<Movie>) ois.readObject();
            ois.close();
            return movieListing;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Movie>();
    }
    /**
     * Replaces the existing list of movie records with the given list.
     * @param data new list of movie records.
     */
    public void replaceExistingFile(ArrayList<Movie> data){
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