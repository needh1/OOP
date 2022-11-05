import java.util.*;
import java.io.*;


public class MovieStorage extends FileStorage
{
    public final static String FILENAME = "movie.txt";

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
                e.printStackTrace();
            }
        }
    }

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