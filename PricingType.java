public enum PricingType
{
    STUDENT("Student"),
    SENIOR_CITIZEN("Senior"),
    NORMAL("Normal"),
    HOLIDAY("Holiday"), 
    WEEKEND("Weekend");

    private final String type;

    private PricingType(String type) {
        this.type = type;
    }

    public String toString(){
        return type;
    }
}