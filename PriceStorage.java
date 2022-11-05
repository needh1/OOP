import java.io.*;


public class PriceStorage extends FileStorage
{
    public final static String FILENAME = "prices.txt";

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
