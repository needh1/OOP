import java.io.*;

public class Cinema implements Serializable
{
    private String code;
    private CinemaType cinemaType;

    public Cinema(String code, CinemaType cinemaType){
        this.code = code;
        this.cinemaType = cinemaType;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public CinemaType getType(){
        return cinemaType;
    }

    public void setType(CinemaType type){
        cinemaType = type;
    }
}