import java.io.*;

public class Cinema implements Serializable
{
    private String code;
    private CinemaType cinemaType;
    private int row;
    private int column;

    public Cinema(String code, CinemaType cinemaType, int row, int column){
        this.code = code;
        this.cinemaType = cinemaType;
        this.row = row;
        this.column = column;
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

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }
}