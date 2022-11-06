import java.io.*;
import java.util.*;

/**
 * Represents Cineplex information stored in the system.
 * Contains it's name and a list of the cinemas in it.
 */
public class Cineplex implements Serializable
{
    /**
     * Cinema name.
     */
    private String name;
    /**
     * List of cinemas in the cineplex.
     */
    private ArrayList<Cinema> cinemaList;
    /**
     * Constructor for Cineplex object.
     * @param name Cineplex name.
     */
    public Cineplex(String name){
        this.name = name;
        this.cinemaList = new ArrayList<Cinema>();
    }
    /**
     * Retrieves Cineplex name.
     * @return Cineplex name.
     */
    public String getName(){
        return name;
    }
    /**
     * Retrieves list of cinemas in the cineplex.
     * @return {@link Cinema} list of cinemas.
     */
    public ArrayList<Cinema> getCinemaList(){
        return cinemaList;
    }
    /**
     * Checks if list of cinemas is empty.
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty(){
        if(cinemaList.size() == 0){
            return true;
        }
        return false;
    }
    /**
     * Retrieves Cinema object based on given cinema code.
     * @param code Cinema code.
     * @return {@link Cinema} Cinema object.
     */
    public Cinema getCinema(String code){
        if(cinemaPresent(code)){
            for(int i = 0; i < cinemaList.size(); i++){
                if(cinemaList.get(i).getCode().equals(code)){
                    return cinemaList.get(i);
                }
            }
        }
        return null;
    }
    /**
     * Retrieves number of cinemas in the cineplex.
     * @return Number of cinemas.
     */
    public int cineplexSize(){
        return cinemaList.size();
    }
    /**
     * Checks if cinema of given code exists.
     * @param code Cinema code.
     * @return True if cinema exists, false otherwise.
     */
    public boolean cinemaPresent(String code){
        if(cinemaList.size() > 0){
            for(int i = 0; i < cinemaList.size(); i++){
                if(cinemaList.get(i).getCode().equals(code)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Adds a new cinema to the cineplex.
     * @param code New cinema code.
     * @param cinemaType Cinema type.
     * @param row Number of rows in cinema.
     * @param column Number of columns in cinema.
     */
    public void addCinema(String code, CinemaType cinemaType, int row, int column){
        if(!cinemaPresent(code)){
            Cinema newCinema = new Cinema(code, cinemaType, row, column);
            cinemaList.add(newCinema);
        }
        else{
            System.out.println("Cinema already added.");
        }
    }
}