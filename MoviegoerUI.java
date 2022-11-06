import java.util.ArrayList;
import java.util.Scanner;

public class MoviegoerUI 
{
    enum Search { ID, title };
    enum Rank { sales, ratings };
    Scanner sc = new Scanner(System.in);

    public void moviegoerUI(){
        boolean quit = false;
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
                        break;
                    case 4:
                        break;
                    case 5:
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

    private void search(Search type){ 
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();    
        String text = String.format("Enter movie %s: ", type.toString());
        System.out.print(text);
        String input = sc.next();
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

}
