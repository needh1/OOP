/**
 * Enumerated type for better readability and easier referencing to attribute 
 */
public enum CinemaType {
    STANDARD("Standard"),
    PREMIUM("Premium");

    private String type;

    CinemaType(String type){
        this.type = type;
    }

    public String toString(){
        return type;
    }
}