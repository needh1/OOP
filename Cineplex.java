import java.io.*;
import java.util.*;


public class Cineplex implements Serializable
{
    private String name;
    private ArrayList<Cinema> cinemaList;

    public Cineplex(String name){
        this.name = name;
        this.cinemaList = new ArrayList<Cinema>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Cinema> getCinemaList(){
        return cinemaList;
    }

    public boolean isEmpty(){
        if(cinemaList.size() == 0){
            return true;
        }
        return false;
    }

    public Cinema getCinema(String code){
        if(cinemaPresent(code)){
            for(int i = 0; i < cinemaList.size(); i++){
                if(cinemaList.get(i).getCode() == code){
                    return cinemaList.get(i);
                }
            }
        }
        return null;
    }

    public int cineplexSize(){
        return cinemaList.size();
    }

    public boolean cinemaPresent(String code){
        if(cinemaList.size() > 0){
            for(int i = 0; i < cinemaList.size(); i++){
                if(cinemaList.get(i).getCode() == code){
                    return true;
                }
            }
        }
        return false;
    }

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