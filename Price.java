import java.io.Serializable;
import java.util.Hashtable;
/**
 * Represents price object.
 * Contains prices for different ticket types.
 */
public class Price implements Serializable
{
    /**
     * List of prices for different ticket types.
     */
    private Hashtable<PricingType, Double> prices;
    /**
     * Constructor for Price object.
     */
    public Price(){
        prices = new Hashtable<PricingType, Double>();
    }
    /**
     * Adds price of ticket type.
     * @param type Pricing type.
     * @param price Price.
     */
    public void addPrice(PricingType type, double price){
        if(prices.containsKey(type)){
            System.out.println("Price type already added.");
            return;
        }
        prices.put(type, price);
    }
    /**
     * Removes price of ticket type.
     * @param type Pricing type.
     */
    public void removePrice(PricingType type){
        if(prices.containsKey(type)){
            prices.remove(type);
            return;
        }
        System.out.println("Price type does not exist.");
    }
    /**
     * Change price of ticket type.
     * @param type Pricing type.
     * @param price Price.
     */
    public void changePrice(PricingType type, double price){
        if(prices.containsKey(type)){
            prices.replace(type, price);
            return;
        }
        System.out.println("Price type does not exist.");
    }
    /**
     * Retrieves price of ticket type.
     * @param type Pricing type.
     * @return Ticket price.
     */
    public double getPrice(PricingType type){
        return prices.get(type);
    }
    /**
     * Retrieves size of pricing list.
     * @return Size of price list.
     */
    public int getSize(){
        return prices.size();
    }
}
