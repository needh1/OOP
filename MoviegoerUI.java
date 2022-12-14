import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * User interface for movie-goers
 */
public class MoviegoerUI 
{
    enum Search { ID, title };
    enum Rank { Sales, Ratings };
    Scanner sc = new Scanner(System.in);
    /**
     * Method to display menu for movie-goers to use.
     */
    public void moviegoerUI(){
        Rank type;
        boolean quit = false;
        Top5Storage top5 = new Top5Storage();
        Top5Valid valid = top5.read();
        while(!quit){
            System.out.println("\n_____Movie-goer_____");
            System.out.println("1. Search movies\n"+
                                "2. List movies\n"+
                                "3. View Top 5 by ticket sales\n"+
                                "4. View Top 5 by review ratings\n"+
                                "5. View booking history\n"+
                                "6. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        search();
                        break;
                    case 2:
                        list();
                        break;
                    case 3:
                        if(!valid.checkSales()){
                            System.out.println("Option has been disabled by admin.");
                            break;
                        }
                        type = Rank.Sales;
                        rank(type);
                        break;
                    case 4:
                        if(!valid.checkRating()){
                            System.out.println("Option has been disabled by admin.");
                            break;
                        }
                        type = Rank.Ratings;
                        rank(type);
                        break;
                    case 5:
                        history();
                        break;
                    case 6:
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
     * Method to display menu to search movies using ID or title.
     */
    private void search() {
        Search type;
        boolean quit = false;
        while(!quit){
            System.out.println("\n_____Search/List Movies_____");
            System.out.println("1. Search movie by ID\n"+
                                "2. Search movie by title\n"+
                                "3. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        type = Search.ID;
                        search(type);
                        break;
                    case 2:
                        type = Search.title;
                        search(type);
                        break;
                    case 3:
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
     * Search movies by either ID or title. 
     * @param type ID or title.
     */
    private void search(Search type){ 
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();    
        String text = String.format("Enter movie %s: ", type.toString());
        System.out.print(text);
        sc.nextLine();
        String input = sc.nextLine();
        System.out.println(input);
        if (type == Search.ID) {
            for(Movie movie : movieList){
                if(movie.getMovieID().equals(input)){
                    System.out.println("Movie found!");
                    MovieMenu movieMenu = new MovieMenu();
                    movieMenu.main(movie);;
                }  
            }
        }
        else if (type == Search.title) {
            for(Movie movie : movieList){
                if(movie.getMovieTitle().equals(input)){
                    System.out.println("Movie found!");
                    MovieMenu movieMenu = new MovieMenu();
                    movieMenu.main(movie);;
                }  
            }
        }
        System.out.println("Movie not found!");
    }
    /**
     * Shows movie list.
     */
    private void list() {
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        boolean quit = false;
        while(!quit){
            System.out.println("\n_______Movie List_______");
            System.out.println("ID  Title\n");
            for (Movie movie : movieList){
                String text = String.format("%s  %s", movie.getMovieID(), movie.getMovieTitle());
                System.out.println(text);
            }
            System.out.println("\n0. Return\n");      
            System.out.print("Enter ID or 0: ");
            String choice = sc.next();
            String zero = "0";
            if (choice.equals(zero)){
                quit = true;
                continue;
            }
            for (Movie movie : movieList){
                if (movie.getMovieID().equals(choice)){
                    MovieMenu movieMenu = new MovieMenu();
                    movieMenu.main(movie);
                }
            }
            System.out.println("Invalid choice!\n");
        }
    }
    /**
     * Sort movie list based on tickets sales or review ratings.
     * @param type Ticket sales or review ratings.
     */
    private void rank(Rank type) {
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        String text = String.format("\n____Top 5 by %s____", type.toString());
        System.out.print(text);
        if (type == Rank.Sales) {
            Collections.sort(movieList, Movie.COMPARE_BY_SALES);
            Collections.reverse(movieList);
            for (int i = 0; i < Math.min(5, movieList.size()); i++) {
                String top = String.format("\n%d. %-15s %d", i+1, movieList.get(i).getMovieTitle(), movieList.get(i).getTicketSales());
                System.out.print(top);
            }
        }
        else if (type == Rank.Ratings) {
            ArrayList<Movie> lessThan2 = new ArrayList<Movie>();
            for (int i = 0; i < movieList.size(); i++) {
                if (movieList.get(i).numReview() < 2) lessThan2.add(movieList.get(i));
            }
            movieList.removeAll(lessThan2);
            Collections.sort(movieList, Movie.COMPARE_BY_RATINGS);
            Collections.reverse(movieList);
            if(movieList.size() == 0){
                System.out.println("\nThere are no movies with sufficient reviews.");
            }
            else{
                for (int i = 0; i < Math.min(5, movieList.size()); i++) {
                    String top = String.format("\n%d. %-15s %,.1f", i+1, movieList.get(i).getMovieTitle(), movieList.get(i).avgRating());
                    System.out.print(top);
                }
            }
        }
        System.out.println();
    }
    /**
     * Check movie-goer booking history.
     */
    private void history() {
        BookingStorage storage = new BookingStorage();
        ArrayList<Booking> bookingList = storage.read(); 
        System.out.println("\n___Booking History___");
        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        boolean empty = true;
        for (Booking record : bookingList) {
            if (record.getName().equals(name)) {
                record.display();
                empty = false;
            }
        }
        if (empty) {
            System.out.println("\nBooking history not found!");
        }
    }

}