import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CURShowing
{
    Scanner sc = new Scanner(System.in);

    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n___Create/Update/Remove Showing Listing___");
            System.out.println("1. Create showing listing\n"+
                                "2. Update showing listing\n"+
                                "3. Remove showing listing\n"+
                                "4. Return");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        create();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        remove();
                        break;
                    case 4:
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
    
    private void create(){
        ShowingStorage showingStore = new ShowingStorage();
        System.out.println("Enter new showing ID: ");
        String showingID = sc.next();
        ArrayList<Showing> showingList = showingStore.read();
        for(Showing showing : showingList){
            if(showing.getShowingID().equals(showingID)){
                System.out.println("Showing is already in system.");
                return;
            }
        }

        System.out.println("Enter movieID for new showing:");
        String id = sc.next();
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        if(movieList.size() == 0){
            System.out.println("Movie does not exist in system.");
            return;
        }
        String movieName = "";
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(id)){
                movieName = movieList.get(i).getMovietitle();
                break;
            }
            if(i == movieList.size() - 1){
                System.out.println("Movie does not exist in system.");
                return;
            }
        }

        sc.nextLine();
        System.out.print("Enter cineplex name: ");
        String cineplexName = sc.nextLine();
        CineplexStorage cineplexStore = new CineplexStorage();
        ArrayList<Cineplex> cineplexList = cineplexStore.read();
        if(cineplexList.size() == 0){
            System.out.println("Cineplex does not exist in system.");
            return;
        }
        int cineplexIndex = 0;
        for(int i = 0; i < cineplexList.size(); i++){
            if(cineplexList.get(i).getName().equals(cineplexName)){
                cineplexIndex = i;
                break;
            }
            if(i == movieList.size() - 1){
                System.out.println("Cineplex does not exist in system.");
                return;
            }
        }

        System.out.print("Enter cinemaCode: ");
        String cinemaCode = sc.next();
        Cinema cinema = cineplexList.get(cineplexIndex).getCinema(cinemaCode);
        if(cinema == null){
            System.out.println("Cinema does not exist!");
            return;
        }
        SeatLayout layout = new SeatLayout(cinemaCode, cinema.getType(), cinema.getRow(), cinema.getColumn());

        System.out.print("Enter date(dd/MM/yyyy):");
        String d = sc.next();
        LocalDate date;
        try{
            date = LocalDate.parse(d, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch(DateTimeParseException e){
            System.out.println("Must be of pattern DD/MM/YYYY!");
            return;
        }

        System.out.print("Enter time(HH:mm):");
        String t = sc.next();
        LocalTime time;
        try{
            time = LocalTime.parse(t, DateTimeFormatter.ofPattern("HH:mm"));
        }
        catch(DateTimeParseException e){
            System.out.println("Must be of pattern HH:mm!");
            return;
        }

        Showing newShowing = new Showing(showingID, movieName, cineplexName, layout, date, time);
        showingStore.writeObject(newShowing);
    }

    private void update(){
        ShowingStorage storage = new ShowingStorage();
        System.out.println("Enter showing ID: ");
        String showingID = sc.next();
        ArrayList<Showing> showingList = storage.read();
        if(showingList.size() == 0){
            System.out.println("Showing does not exist in system.");
            return;
        }
        int index = 0;
        for(index = 0; index < showingList.size(); index++){
            if(showingList.get(index).getShowingID().equals(showingID)){
                break;
            }
            if(index == showingList.size() - 1){
                System.out.println("Movie does not exist in system.");
                return;
            }
        }

        System.out.println("Select showing attribute to update");
		System.out.printf(  "1. Movie name\n"+
							"2. Cinema number\n"+
							"3. Date\n"+
							"4. Time \n" +
							"Enter option: ");
        
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter new movie ID: ");
                    String id = sc.next();
                    MovieStorage movieStore = new MovieStorage();
                    ArrayList<Movie> movieList = movieStore.read();
                    if(movieList.size() == 0){
                        System.out.println("Movie does not exist in system.");
                        return;
                    }
                    String movieName = "";
                    for(int i = 0; i < movieList.size(); i++){
                        if(movieList.get(i).getMovieID().equals(id)){
                            movieName = movieList.get(i).getMovietitle();
                            break;
                        }
                        if(i == movieList.size() - 1){
                            System.out.println("Movie does not exist in system.");
                            return;
                        }
                    }
                    showingList.get(index).setMovieTitle(movieName);
                    break;
                case 2:
                    System.out.print("Enter new cinema code: ");
                    String cinemaCode = sc.next();
                    CineplexStorage cineplexStorage = new CineplexStorage();
                    ArrayList<Cineplex> cineplexList = cineplexStorage.read();
                    int cineplexIndex = 0;
                    for(int i = 0; i < cineplexList.size(); i++){
                        if(cineplexList.get(i).getName().equals(showingList.get(index).getCineplexName())){
                            cineplexIndex = i;
                            break;
                        }
                        if(i == cineplexList.size() - 1){
                            System.out.println("Cineplex does not exist in system.");
                            return;
                        }
                    }
                    Cinema cinema = cineplexList.get(cineplexIndex).getCinema(cinemaCode);
                    if(cinema == null){
                        System.out.println("Cinema does not exist!");
                        return;
                    }
                    SeatLayout newLayout = new SeatLayout(cinemaCode, cinema.getType(), cinema.getRow(), cinema.getColumn());
                    showingList.get(index).setSeating(newLayout);
                    break;
                case 3:
                    System.out.print("Enter new date(dd/MM/yyyy):");
                    String d = sc.next();
                    LocalDate date;
                    try{
                        date = LocalDate.parse(d, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    }
                    catch(DateTimeParseException e){
                        System.out.println("Must be of pattern DD/MM/YYYY!");
                        return;
                    }
                    showingList.get(index).setDate(date);
                    break;
                case 4:
                    System.out.print("Enter new time(HH:mm):");
                    String t = sc.next();
                    LocalTime time;
                    try{
                        time = LocalTime.parse(t, DateTimeFormatter.ofPattern("HH:mm"));
                    }
                    catch(DateTimeParseException e){
                        System.out.println("Must be of pattern HH:mm!");
                        return;
                    }
                    showingList.get(index).setTime(time);
                    break;
                default:
                    System.out.println("Invalid choice!\n");
                    return;
            }
            storage.replaceExistingFile(showingList);
            System.out.println("Movie successfully updated!");
        }
        else {
            System.out.println("Please enter an integer!\n");
            sc.nextLine();
            return;
        }
    }

    private void remove(){
        System.out.print("Enter showing ID to remove: ");
        String id = sc.next();

        ShowingStorage storage = new ShowingStorage();
        ArrayList<Showing> showingList = storage.read();
        for(int i = 0; i < showingList.size(); i++){
            if(showingList.get(i).getShowingID().equals(id)){
                showingList.remove(i);
                storage.replaceExistingFile(showingList);
                System.out.println("Showing successfully removed!");
                return;
            }
        }
        System.out.println("Showing does not exist in system.");
    }
}