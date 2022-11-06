import java.io.*;
import java.time.*;
/**
 * Represents a holiday record in the system.
 */
public class Holiday implements Serializable
{
    /**
     * ID of holiday record.
     */
    private String holidayID;
    /**
     * Date of holiday record.
     */
    private LocalDate holidayDate;
     /**
      * Cnstructor for Holiday object.
      * @param id Holiday ID.
      * @param date Holiday date.
      */
    public Holiday(String id, LocalDate date){
        holidayID = id;
        holidayDate = date;
    }
    /**
     * Retrives ID of holiday record.
     * @return holiday ID.
     */
    public String getHolidayID(){
        return holidayID;
    }
    /**
     * Sets new ID for holiday record.
     * @param id  New holiday ID.
     */
    public void setHolidayID(String id){
        holidayID = id;
    }
    /**
     * Retrives date of holiday record.
     * @return Date of holiday record.
     */
    public LocalDate getHolidayDate(){
        return holidayDate;
    }
    /**
     * Sets new date for holiday record.
     * @param date New date of holiday record.
     */
    public void setHolidayDate(LocalDate date){
        holidayDate = date;
    }
}