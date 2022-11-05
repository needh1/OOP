import java.util.*;
import java.io.*;

public class HolidayStorage extends FileStorage
{
    public final static String FILENAME = "holiday.txt";

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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Holiday> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Holiday> holidayList = (ArrayList<Holiday>) ois.readObject();
            ois.close();
            return holidayList;
        } catch (ClassNotFoundException e) {
            System.out.println("Object does not exist.");
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Holiday>();
    }

    public void replaceExistingFile(ArrayList<Holiday> data){
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
