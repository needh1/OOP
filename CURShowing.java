import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Allows admin to create, update or remove movie showings.
 */
public class CURShowing
{
    Scanner sc = new Scanner(System.in);
    /**
     * Main program to display options.
     */
    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n___Create/Update/Remove Showing Listing___");
            System.out.println("1. Create showing listing\n"+
                                "2. Update showing listing\n"+
                                "3. Remove showing listing\n"+
                                "4. Return\n");
            System.out.print("Enter choice: ");
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
    /**
     * Creates a new movie showing.
     */
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

        System.out.print("Enter movieID for new showing [");
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        for(Movie movie : movieList){
            if(movie.getStatus().equals("Now Showing") || movie.getStatus().equals("Preview")){
                System.out.print(movie.getMovieID() + ", ");
            }
        }
        System.out.print("]: ");
        String id = sc.next();
        
        if(movieList.size() == 0){
            System.out.println("Movie does not exist in system.");
            return;
        }
        String movieName = "";
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(id)){
                if(movieList.get(i).getStatus().equals("Coming Soon")){
                    System.out.println("Movie is not available currently.");
                    return;
                }
                movieName = movieList.get(i).getMovieTitle();
                break;
            }
            if(i == movieList.size() - 1){
                System.out.println("Movie does not exist in system.");
                return;
            }
        }

        sc.nextLine();
        System.out.print("Enter cineplex name [");
        CineplexStorage cineplexStore = new CineplexStorage();
        ArrayList<Cineplex> cineplexList = cineplexStore.read();
        for(Cineplex cineplex : cineplexList){
            System.out.print(cineplex.getName() + ", ");
        }
        System.out.print("]: ");
        String cineplexName = sc.nextLine();
        
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
            if(i == cineplexList.size() - 1){
                System.out.println("Cineplex does not exist in system.");
                return;
            }
        }

        System.out.print("Enter cinemaCode [");
        for(Cinema cinema : cineplexList.get(cineplexIndex).getCinemaList()){
            System.out.print(cinema.getCode() + "(" + cinema.getType() + "), ");
        }
        System.out.print("]: ");
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
    /**
     * Updates an existing movie showing.
     */
    private void update(){
        ShowingStorage storage = new ShowingStorage();
        ArrayList<Showing> showingList = storage.read();
        if(showingList.size() == 0){
            System.out.println("There are no showings in the system.");
            return;
        }
        System.out.print("Enter showing ID [");
        for(Showing showing : showingList){
            System.out.print(showing.getShowingID() + ", ");
        }
        System.out.print("]: ");
        String showingID = sc.next();
        
        
        int index = 0;
        for(index = 0; index < showingList.size(); index++){
            if(showingList.get(index).getShowingID().equals(showingID)){
                break;
            }
            if(index == showingList.size() - 1){
                System.out.println("Showing does not exist in system.");
                return;
            }
        }

        System.out.println("Select showing attribute to update");
		System.out.printf(  "1. Movie name\n"+
							"2. Cinema number\n"+
							"3. Date\n"+
							"4. Time \n" +
                            "5. Return\n"+
							"Enter option: ");
        
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    
                    MovieStorage movieStore = new MovieStorage();
                    ArrayList<Movie> movieList = movieStore.read();
                    if(movieList.size() == 0){
                        System.out.println("There are no movies in the system.");
                        return;
                    }
                    System.out.print("Enter new movie ID [");
                    for(Movie movie : movieList){
                        if(movie.getStatus().equals("Now Showing") || movie.getStatus().equals("Preview")){
                            System.out.print(movie.getMovieID() + ", ");
                        }
                    }
                    System.out.print("]: ");
                    String id = sc.next();
                    
                    String movieName = "";
                    for(int i = 0; i < movieList.size(); i++){
                        if(movieList.get(i).getMovieID().equals(id)){
                            if(movieList.get(i).getStatus().equals("Coming Soon")){
                                System.out.println("Movie is not available currently.");
                                return;
                            }
                            movieName = movieList.get(i).getMovieTitle();
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
                    System.out.print("Enter new cinemaCode [");
        for(Cinema cinema : cineplexList.get(cineplexIndex).getCinemaList()){
            System.out.print(cinema.getCode() + "(" + cinema.getType() + "), ");
        }
                    System.out.print("]: ");
                    String cinemaCode = sc.next();
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
                case 5:
                    return;
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
    /**
     * Removes an existing movie showing.
     */
    private void remove(){
        

        ShowingStorage storage = new ShowingStorage();
        ArrayList<Showing> showingList = storage.read();
        if(showingList.size() == 0){
            System.out.println("There are no showings in th system.");
            return;
        }
        System.out.print("Enter showing ID to remove [");
        for(Showing showing : showingList){
            System.out.print(showing.getShowingID() + ", ");
        }
        System.out.print("]: ");
        String id = sc.next();
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