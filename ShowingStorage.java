import java.util.*;
import java.io.*;
/**
 * Represents a storage handler for showing records.
 * Used to store and retrieve showing records.
 */
public class ShowingStorage extends FileStorage
{
    /**
     * The file where showing records will be stored in.
     */
    public final static String FILENAME = "showing.txt";
    /**
     * Adds the given showing record into the storage file.
     * @param o Showing record to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Showing){
            Showing showing = (Showing) o;
            ArrayList<Showing> allData = new ArrayList<Showing>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(showing);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }
    /**
     * Retrieves all the showing records in the storage file.
     * @return {@link Showing} Returns list of showing records if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Showing> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Showing> showingList = (ArrayList<Showing>) ois.readObject();
            ois.close();
            return showingList;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Showing>();
    }
    /**
     * Replaces the existing list of showing records with the given list.
     * @param data new list of showing records.
     */
    public void replaceExistingFile(ArrayList<Showing> data){
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