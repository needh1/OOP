import java.io.*;

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