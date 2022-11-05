import java.util.*;
import java.io.*;

public class ShowingStorage extends FileStorage
{
    public final static String FILENAME = "showing.txt";

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