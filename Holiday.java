import java.io.*;

public class Holiday implements Serializable
{
    private String holidayID;
    private LocalDate holidayDate;

    public Holiday(String id, LocalDate date){
        holidayID = id;
        holidayDate = date;
    }

    public String getHolidayID(){
        return holidayID;
    }

    public void setHolidayID(String id){
        holidayID = id;
    }

    public LocalDate getHolidayDate(){
        return holidayDate;
    }

    public void setHolidayDate(LocalDate date){
        holidayDate = date;
    }
}