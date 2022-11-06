import java.util.*;
import java.io.*;
/**
 * Represents a storage handler for holiday records.
 * Used to store and retrieve holiday records.
 */
public class HolidayStorage extends FileStorage
{
    /**
     * The file where holiday records will be stored in.
     */
    public final static String FILENAME = "holiday.txt";
    /**
     * Adds the given holiday record into the storage file.
     * @param o Holiday record to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Holiday){
            Holiday holiday = (Holiday) o;
            ArrayList<Holiday> allData = new ArrayList<Holiday>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(holiday);
                out.writeObject(allData);
                out.flush();
                out.close();
                System.out.println("Holiday successfully added!");
            } catch (IOException e) {

            }
        }
    }
    /**
     * Retrieves all the holiday records in the storage file.
     * @return {@link Holiday} Returns list of holdiay records if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Holiday> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Holiday> holidayList = (ArrayList<Holiday>) ois.readObject();
            ois.close();
            return holidayList;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Holiday>();
    }
    /**
     * Replaces the existing list of holiday records with the given list.
     * @param data new list of holiday records.
     */
    public void replaceExistingFile(ArrayList<Holiday> data){
        File tempFile = new File(FILENAME);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
            out.writeObject(data);
            out.flush();
            out.close();
            System.out.println("Holiday removed successfully!");
        } catch (IOException e) {
            //
        }
    }
}