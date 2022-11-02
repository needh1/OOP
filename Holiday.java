import java.io.*;

public class Holiday implements Serializable
{
    private LocalDate holidayDate;

    public Holiday(LocalDate date){
        holidayDate = date;
    }

    public LocalDate getHolidayDate(){
        return holidayDate;
    }

    public void setHolidayDate(LocalDate date){
        holidayDate = date;
    }
}