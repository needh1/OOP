import java.io.*;
/**
 * Represents cinema information stored in the system.
 * Contains it's code, type and dimensions.
 */
public class Cinema implements Serializable
{
    /**
     * Cinema unique code.
     */
    private String code;
    /**
     * Cinema's type.
     */
    private CinemaType cinemaType;
    /**
     * Number of rows in cinema.
     */
    private int row;
    /**
     * Number of columns in cinema.
     */
    private int column;
    /**
     * Constructor for Cinema object.
     * @param code
     * @param cinemaType
     * @param row
     * @param column
     */
    public Cinema(String code, CinemaType cinemaType, int row, int column){
        this.code = code;
        this.cinemaType = cinemaType;
        this.row = row;
        this.column = column;
    }
    /**
     * Retrieves cinema code.
     * @return cinema code.
     */
    public String getCode(){
        return code;
    }
    /**
     * Sets cinema code.
     * @param code
     */
    public void setCode(String code){
        this.code = code;
    }
    /**
     * Retrieves cinema type.
     * @return cinema type.
     */
    public CinemaType getType(){
        return cinemaType;
    }
    /**
     * Sets cinema type.
     * @param type
     */
    public void setType(CinemaType type){
        cinemaType = type;
    }
    /**
     * Retrieves number of rows in cinema.
     * @return number of rows.
     */
    public int getRow(){
        return row;
    }
    /**
     * Sets number of rows in cinema.
     * @param row
     */
    public void setRow(int row){
        this.row = row;
    }
    /**
     * Retrieves number of columns in cinema.
     * @return number of columns.
     */
    public int getColumn(){
        return column;
    }
    /**
     * Sets number of columns in cinema.
     * @param column
     */
    public void setColumn(int column){
        this.column = column;
    }
}