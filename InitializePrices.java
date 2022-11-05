public class InitializePrices extends Initializer
{
    public InitializePrices(){}

    public final void initialize(){
        PriceStorage storage = new PriceStorage();

        Price prices = new Price();

        //Set price for student
        prices.addPrice(PricingType.STUDENT_2D_STANDARD, 7);
        prices.addPrice(PricingType.STUDENT_2D_PREMIUM, 9);
        prices.addPrice(PricingType.STUDENT_3D_STANDARD, 8);
        prices.addPrice(PricingType.STUDENT_3D_PREMIUM, 10);

        //Set price for senior
        prices.addPrice(PricingType.SENIOR_2D_STANDARD, 5);
        prices.addPrice(PricingType.SENIOR_2D_PREMIUM, 7);
        prices.addPrice(PricingType.SENIOR_3D_STANDARD, 6);
        prices.addPrice(PricingType.SENIOR_3D_PREMIUM, 8);

        //Set price for normal
        prices.addPrice(PricingType.NORMAL_2D_STANDARD, 8);
        prices.addPrice(PricingType.NORMAL_2D_PREMIUM, 10);
        prices.addPrice(PricingType.NORMAL_3D_STANDARD, 9);
        prices.addPrice(PricingType.NORMAL_3D_PREMIUM, 11);
        
        //Set price for Weekend/holidays
        prices.addPrice(PricingType.WEEKEND_2D_STANDARD, 10);
        prices.addPrice(PricingType.WEEKEND_2D_PREMIUM, 12);
        prices.addPrice(PricingType.WEEKEND_3D_STANDARD, 11);
        prices.addPrice(PricingType.WEEKEND_3D_PREMIUM, 13);
        
        

        storage.writeObject(prices);
    }
}
