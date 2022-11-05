import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigureSystem
{
    Scanner sc = new Scanner(System.in);

    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("_____Configure System Settings____");
            System.out.println("1. Add Holiday\n"+
                                "2. Delete Holiday\n"+
                                "3. List Holidays\n"+
                                "4. Update Price\n"+
                                "5. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        addHoliday();
                        break;
                    case 2:
                        deleteHoliday();
                        break;
                    case 3:
                        listHoliday();
                        break;
                    case 4:
                        updatePrice();
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice!\n");
                }
            }
            else {
                System.out.println("Please enter an integer!\n");
                sc.nextLine();
            }
        }
    }

    private void addHoliday(){
        HolidayStorage storage = new HolidayStorage();
        ArrayList<Holiday> holidayList = storage.read();
        System.out.println("Enter new Holiday ID: ");
        String id = sc.next();
        for(Holiday holiday : holidayList){
            if(holiday.getHolidayID().equals(id)){
                System.out.println("Holiday already added.");
                return;
            }
        }
        System.out.println("Enter new Holiday date(dd/MM/yyyy): ");
        String d = sc.next();
        LocalDate date;
        try{
            date = LocalDate.parse(d, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch(DateTimeParseException e){
            System.out.println("Must be of pattern DD/MM/YYYY!");
            return;
        }

        Holiday newHoliday = new Holiday(id, date);
        storage.writeObject(newHoliday);
    }

    private void deleteHoliday(){
        HolidayStorage storage = new HolidayStorage();
        ArrayList<Holiday> holidayList = storage.read();
        System.out.println("Enter Holiday ID to delete: ");
        String id = sc.next();
        for(Holiday holiday : holidayList){
            if(holiday.getHolidayID().equals(id)){
                holidayList.remove(holiday);
                storage.replaceExistingFile(holidayList);
                return;
            }
        }
        System.out.println("HolidayID not in system.");
    }

    private void listHoliday(){
        HolidayStorage storage = new HolidayStorage();
        ArrayList<Holiday> holidayList = storage.read();
        if(holidayList.size() == 0){
            System.out.println("No holiday found.");
            return;
        }
        System.out.println("HolidayID|Date");
        for(Holiday holiday : holidayList){
            System.out.println(holiday.getHolidayID() + "|" + holiday.getHolidayDate());
        }
        System.out.println();
    }

    private void updatePrice(){
        
    }
}