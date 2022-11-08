import java.io.*;

/**
 * Represents a storage handler for Top 5 settings.
 * Used to store and retrieve Top 5 settings.
 */
public class Top5Storage extends FileStorage
{
    /**
     * The file where Top 5 settings will be stored in.
     */
    public final static String FILENAME = "top5valid.txt";
    /**
     * Adds the given Top 5 setting into the storage file.
     * @param o Top 5 settings to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Top5Valid){
            Top5Valid top5 = (Top5Valid) o;
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                out.writeObject(top5);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }
    /**
     * Retrieves the Top 5 settings in the storage file.
     * @return {@link Top5Valid} Returns Top5Valid object if found, else a new Top5Valid object.
     */
    public Top5Valid read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            Top5Valid top5 = (Top5Valid) ois.readObject();
            ois.close();
            return top5;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new Top5Valid();
    }
}
