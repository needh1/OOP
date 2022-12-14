import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Used by admin to configure system settings.
 */
public class ConfigureSystem
{
    Scanner sc = new Scanner(System.in);
    /**
     * Main program to display options.
     */
    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n_____Configure System Settings____");
            System.out.println("1. Add Holiday\n"+
                                "2. Delete Holiday\n"+
                                "3. List Holidays\n"+
                                "4. Update Price\n"+
                                "5. List Prices\n"+
                                "6. Change Top 5 display settings\n"+
                                "7. Return");
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
                        sc.nextLine();
                        break;
                    case 5:
                        listPrices();
                        break;
                    case 6:
                        displaySettings();
                        break;
                    case 7:
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
    /**
     * Adds a new Holiday into the system.
     */
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
    /**
     * Deletes an existing holiday from system.
     */
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
    /**
     * Lists out all existing holidays.
     */
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
    /**
     * Updates the prices of movie tickets.
     */
    private void updatePrice(){
        System.out.println("\n____Update Price____");
        System.out.print("Select type:\n1. Student\n2. Senior\n3. Normal\n4. Weekend/Holiday\nEnter choice: ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }
        int personType = sc.nextInt();
        if(personType < 1 || personType > 4){
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("\nSelect movie type:\n1. 2D\n2. 3D\nEnter choice: ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }
        int movieType = sc.nextInt();
        if(movieType < 1 || movieType > 2){
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("\nSelect cinema type:\n1. Standard\n2. Premium\nEnter choice: ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }
        int cinemaType = sc.nextInt();
        if(cinemaType < 1 || cinemaType > 2){
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("\nEnter new price: ");
        if(!sc.hasNextDouble()){
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }
        double price = sc.nextDouble();
        if(price < 0){
            System.out.println("Invalid price!");
            return;
        }

        PriceStorage storage = new PriceStorage();
        Price prices = storage.read();
        if(personType == 1){
            if(movieType == 1 && cinemaType == 1){prices.changePrice(PricingType.STUDENT_2D_STANDARD, price);}
            else if(movieType == 1 && cinemaType == 2){prices.changePrice(PricingType.STUDENT_2D_PREMIUM, price);}
            else if(movieType == 2 && cinemaType == 1){prices.changePrice(PricingType.STUDENT_3D_STANDARD, price);}
            else {prices.changePrice(PricingType.STUDENT_3D_PREMIUM, price);}
        }
        else if(personType == 2){
            if(movieType == 1 && cinemaType == 1){prices.changePrice(PricingType.SENIOR_2D_STANDARD, price);}
            else if(movieType == 1 && cinemaType == 2){prices.changePrice(PricingType.SENIOR_2D_PREMIUM, price);}
            else if(movieType == 2 && cinemaType == 1){prices.changePrice(PricingType.SENIOR_3D_STANDARD, price);}
            else {prices.changePrice(PricingType.SENIOR_3D_PREMIUM, price);}
        }
        else if(personType == 3){
            if(movieType == 1 && cinemaType == 1){prices.changePrice(PricingType.NORMAL_2D_STANDARD, price);}
            else if(movieType == 1 && cinemaType == 2){prices.changePrice(PricingType.NORMAL_2D_PREMIUM, price);}
            else if(movieType == 2 && cinemaType == 1){prices.changePrice(PricingType.NORMAL_3D_STANDARD, price);}
            else {prices.changePrice(PricingType.NORMAL_3D_PREMIUM, price);}
        }
        else {
            if(movieType == 1 && cinemaType == 1){prices.changePrice(PricingType.WEEKEND_2D_STANDARD, price);}
            else if(movieType == 1 && cinemaType == 2){prices.changePrice(PricingType.WEEKEND_2D_PREMIUM, price);}
            else if(movieType == 2 && cinemaType == 1){prices.changePrice(PricingType.WEEKEND_3D_STANDARD, price);}
            else {prices.changePrice(PricingType.WEEKEND_3D_PREMIUM, price);}
        }
        storage.writeObject(prices);
    }
    /**
     * Updates Top 5 display settings.
     */
    private void displaySettings(){
        Top5Storage storage = new Top5Storage();
        Top5Valid settings = storage.read();
        System.out.println("\nSelect option to change:\n"+
                            "1. Top 5 by sales\n"+
                            "2. Top 5 by ratings\n");
        System.out.print("Enter choice: ");
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    System.out.print("\nEnter new setting (true/false): ");
                    if(sc.hasNextBoolean()){
                        settings.setSales(sc.nextBoolean());
                        storage.writeObject(settings);
                    }
                    else{
                        System.out.println("Invalid value!\n");
                        sc.nextLine();
                        return;
                    }
                    break;
                case 2:
                    System.out.print("\nEnter new setting (true/false): ");
                    if(sc.hasNextBoolean()){
                        settings.setRating(sc.nextBoolean());
                        storage.writeObject(settings);
                    }
                    else{
                        System.out.println("Invalid value!\n");
                        sc.nextLine();
                        return;
                    }
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
    /**
     * Lists out the ticket prices in the system.
     */
    private void listPrices(){
        PriceStorage priceStore = new PriceStorage();
        Price prices = priceStore.read();
        System.out.println("\nPricing Type                  : Price");
        int count = 0;
        for(PricingType type : PricingType.values()){
            System.out.printf("%-30s: %.2f\n", type, prices.getPrice(type));
            count++;
            if(count%4 == 0){
                System.out.println();
            }
        }
    }
}
