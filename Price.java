import java.io.Serializable;
import java.util.Hashtable;

public class Price implements Serializable
{
    private Hashtable<PricingType, Double> prices;

    public Price(){
        prices = new Hashtable<PricingType, Double>();
    }

    public void addPrice(PricingType type, double price){
        if(prices.containsKey(type)){
            System.out.println("Price type already added.");
            return;
        }
        prices.put(type, price);
    }

    public void removePrice(PricingType type){
        if(prices.containsKey(type)){
            prices.remove(type);
            return;
        }
        System.out.println("Price type does not exist.");
    }

    public void changePrice(PricingType type, double price){
        if(prices.containsKey(type)){
            prices.replace(type, price);
            return;
        }
        System.out.println("Price type does not exist.");
    }

    public double getPrice(PricingType type){
        return prices.get(type);
    }

    public int getSize(){
        return prices.size();
    }
}
