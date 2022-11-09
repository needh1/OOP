import java.io.Serializable;

/**
 * Represents saved settings to check if top 5 movies can be displayed to movie-goers by sales/rating.
 */
public class Top5Valid implements Serializable
{
    private boolean sales;
    private boolean rating;

    public Top5Valid(){
        sales = true;
        rating = true;
    }

    public Top5Valid(boolean sales, boolean rating){
        this.sales = sales;
        this.rating = rating;
    }

    /**
     * Checks if top 5 movies can be displayed by sales number.
     * @return True if top 5 can be displayed by sales, false otherwise.
     */
    public boolean checkSales(){
        return sales;
    }

    public void setSales(boolean sales){
        this.sales = sales;
    }

    /**
     * Checks if top 5 movies can be displayed by rating number.
     * @return True if top 5 can be displayed by rating, false otherwise.
     */
    public boolean checkRating(){
        return rating;
    }
    
    public void setRating(boolean rating){
        this.rating = rating;
    }
}