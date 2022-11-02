public enum PricingType
{
    STUDENT("Student"),
    SENIOR_CITIZEN("Senior"),
    NORMAL("Normal"),
    HOLIDAY("Holiday"), 
    WEEKEND("Weekend");

    private final String text;

    private PricingType(String text) {
        this.text = text;
    }

    public String toString(){
        return text;
    }
}