import java.io.*;

/**
 * Represents a storage handler for price records.
 * Used to store and retrieve price records.
 */
public class PriceStorage extends FileStorage
{
    /**
     * The file where price records will be stored in.
     */
    public final static String FILENAME = "prices.txt";
    /**
     * Adds the given price record into the storage file.
     * @param o Price record to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Price){
            Price price = (Price) o;
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                out.writeObject(price);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }
    /**
     * Retrieves all the price records in the storage file.
     * @return {@link Price} Returns Price object if found, else a new Price object.
     */
    public Price read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            Price prices = (Price) ois.readObject();
            ois.close();
            return prices;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new Price();
    }
}