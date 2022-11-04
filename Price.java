import java.io.Serializable;
import java.util.Hashtable;

public class Price implements Serializable
{
    private Hashtable<String, Integer> prices;

    public Price(){
        prices = new Hashtable<String, Integer>();
    }

    public void addPrice(String type, int price){
        if(prices.containsKey(type)){
            System.out.println("Price type already added.");
            return;
        }
        prices.put(type, price);
    }

    public void removePrice(String type){
        if(prices.containsKey(type)){
            prices.remove(type);
            return;
        }
        System.out.println("Price type does not exist.");
    }

    public void changePrice(String type, int price){
        if(prices.containsKey(type)){
            prices.replace(type, price);
            return;
        }
        System.out.println("Price type does not exist.");
    }
}