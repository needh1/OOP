import java.util.ArrayList;
import java.util.Scanner;
/**
 * Allows admin to create, update or remove movie listings.
 */
public class CURListing
{
    Scanner sc = new Scanner(System.in);
    /**
     * Main program to display options.
     */
    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n___Create/Update/Remove movie Listing___");
            System.out.println("1. Create movie listing\n"+
                                "2. Update movie listing\n"+
                                "3. Remove movie listing\n"+
                                "4. List out movie listings\n"+
                                "5. Return");
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
                        MovieStorage movieStore = new MovieStorage();
                        ArrayList<Movie> movieList = movieStore.read();
                        System.out.println("_______Movie Listings______");
                        for(Movie movie : movieList){
                            System.out.println(movie.getMovieID() + "|" + movie.getMovieTitle() + "|" + movie.getDuration() + "|" + movie.getStatus() + "|" + movie.getMovieRating() + "|" + movie.getDirector() + "|" + movie.getCast());
                        }
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
    /**
     * Creates a new movie listing in the system.
     */
    private void create(){
        System.out.print("Enter movie ID: ");
        String id = sc.next();
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        for(Movie movie : movieList){
            if(movie.getMovieID().equals(id)){
                System.out.println("Movie exists in system.");
                return;
            }
        }
        sc.nextLine();
        System.out.print("Enter movie title: ");
        String title = sc.nextLine();
        
        MovieType type;
        System.out.print("Enter movie type: \n1. 2D\n2. 3D\n");
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    type = MovieType._2D;
                    break;
                case 2:
                    type = MovieType._3D;
                    break;
                default:
                    System.out.println("Invalid choice!\n");
                    return;
            }
        }
        else {
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }

        System.out.print("Enter movie duration: ");
        if(!sc.hasNextDouble()){
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }
        double duration = sc.nextDouble();

        System.out.print("Select movie status:\n1. Coming Soon\n2. Now Showing\n3. Preview\nChoice: ");
        String newStatus = "";
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    newStatus = "Coming Soon";
                    break;
                case 2:
                    newStatus = "Now Showing";
                    break;
                case 3:
                    newStatus = "Preview";
                    break;
                default:
                    System.out.println("Invalid choice!\n");
                    return;
            }
        }
        else {
            System.out.println("Invalid input!\n");
            sc.nextLine();
            return;
        }

        sc.nextLine();
        System.out.println("Enter movie synopsis: ");
        String synopsis = sc.nextLine();

        System.out.print("Enter movie director: ");
        String director = sc.nextLine();

        System.out.print("Enter movie cast: ");
        String cast = sc.nextLine();

        System.out.print("Enter movie rating: ");
        String rating = sc.nextLine();

        Movie newMovie = new Movie(id, title, type, rating, duration, newStatus, synopsis, director, cast, 0);
        storage.writeObject(newMovie);
    }
    /**
     * Updates an existing movie listing.
     */
    private void update(){
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        if(movieList.size() == 0){
            System.out.println("There are no movies in the system.");
            return;
        }
        System.out.print("Enter movie ID to update [");
        for(Movie movie : movieList){
            System.out.print(movie.getMovieID() + ", ");
        }
        System.out.print("]: ");
        String id = sc.next();

        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(id)){
                break;
            }
            if(i == movieList.size() - 1){
                System.out.println("Movie does not exist in system.");
                return;
            }
        }

        System.out.println("Select movie attribute to update");
		System.out.printf(  "1. Title\n"+
							"2. Type\n"+
							"3. Duration\n"+
                            "4. Status\n"+
							"5. Synopsis \n" +
							"6. Director\n"+
							"7. Cast\n"+
                            "8. Movie Rating\n"+
                            "9. Return\n\n"+
							"Enter option: ");
        
        if (sc.hasNextInt()) {
            switch(sc.nextInt()){
                case 1:
                    System.out.print("Enter new title: ");
                    sc.nextLine();
                    String newTitle = sc.nextLine();
                    movieList.get(getIndex(movieList, id)).setMovietitle(newTitle);
                    break;
                case 2:
                    System.out.print("Enter new type:\n1. 2D\n2. 3D\n");
                    MovieType newType;
                    if (sc.hasNextInt()) {
                        switch(sc.nextInt()){
                            case 1:
                                newType = MovieType._2D;
                                break;
                            case 2:
                                newType = MovieType._3D;
                                break;
                            default:
                                System.out.println("Invalid choice!\n");
                                return;
                        }
                    }
                    else {
                        System.out.println("Invalid input!\n");
                        sc.nextLine();
                        return;
                    }
                    movieList.get(getIndex(movieList, id)).setType(newType);
                    break;
                case 3:
                    System.out.print("Enter new duration: ");
                    if(!sc.hasNextDouble()){
                        System.out.println("Invalid input!\n");
                        sc.nextLine();
                        return;
                    }
                    double newDuration = sc.nextDouble();
                    movieList.get(getIndex(movieList, id)).setDuration(newDuration);
                    break;
                case 4:
                    System.out.print("Select option:\n1. Now Showing\n2. Preview\n3. End of Showing\nChoice: ");
                    String newStatus;
                    if (sc.hasNextInt()) {
                        switch(sc.nextInt()){
                            case 1:
                                newStatus = "Now Showing";
                                movieList.get(getIndex(movieList, id)).setStatus(newStatus);
                                break;
                            case 2:
                                newStatus = "Preview";
                                movieList.get(getIndex(movieList, id)).setStatus(newStatus);
                                break;
                            case 3:
                                for(int i = 0; i < movieList.size(); i++){
                                    if(movieList.get(i).getMovieID().equals(id)){
                                        ShowingStorage showStore = new ShowingStorage();
                                        ArrayList<Showing> showList = showStore.read();
                                        ArrayList<Showing> temp = new ArrayList<>();
                                        for(int j = 0; i < showList.size(); j++){
                                            if(movieList.get(i).getMovieTitle().equals(showList.get(j).getMovieTitle())){
                                                temp.add(showList.get(i));
                                            }
                                        }
                                        showList.removeAll(temp);
                                        showStore.replaceExistingFile(showList);
                                        movieList.remove(i);
                                        storage.replaceExistingFile(movieList);
                                        System.out.println("Movie successfully removed!");
                                        return;
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid choice!\n");
                                return;
                        }
                    }
                    else {
                        System.out.println("Invalid input!\n");
                        sc.nextLine();
                        return;
                    }
                    break;
                case 5:
                    System.out.print("Enter new synopsis: ");
                    sc.nextLine();
                    String newSynopsis = sc.nextLine();
                    movieList.get(getIndex(movieList, id)).setMovietitle(newSynopsis);
                    break;
                case 6:
                    System.out.print("Enter new director: ");
                    sc.nextLine();
                    String newDirector = sc.nextLine();
                    movieList.get(getIndex(movieList, id)).setDirector(newDirector);
                    break;
                case 7:
                    System.out.print("Enter new cast: ");
                    sc.nextLine();
                    String newCast = sc.nextLine();
                    movieList.get(getIndex(movieList, id)).setCast(newCast);
                    break;
                case 8:
                    System.out.print("Enter new movie rating: ");
                    sc.nextLine();
                    String newMovieRating = sc.nextLine();
                    movieList.get(getIndex(movieList, id)).setMovieRating(newMovieRating);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice!\n");
                    return;
            }
            storage.replaceExistingFile(movieList);
            System.out.println("Movie successfully updated!");
        }
        else {
            System.out.println("Please enter an integer!\n");
            sc.nextLine();
            return;
        }
    }
    /**
     * Removes an existing movie listing.
     */
    private void remove(){
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        if(movieList.size() == 0){
            System.out.println("There are no movies in the system.");
            return;
        }
        System.out.print("Enter movie ID to remove [");
        for(Movie movie : movieList){
            System.out.print(movie.getMovieID() + ", ");
        }
        System.out.print("]: ");
        String id = sc.next();

        
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(id)){
                ShowingStorage showStore = new ShowingStorage();
                ArrayList<Showing> showList = showStore.read();
                ArrayList<Showing> temp = new ArrayList<>();
                for(int j = 0; i < showList.size(); j++){
                    if(movieList.get(i).getMovieTitle().equals(showList.get(j).getMovieTitle())){
                        temp.add(showList.get(i));
                    }
                }
                showList.removeAll(temp);
                showStore.replaceExistingFile(showList);
                movieList.remove(i);
                storage.replaceExistingFile(movieList);
                System.out.println("Movie successfully removed!");
                return;
            }
        }
        System.out.println("Movie does not exist in system.");
    }

    private int getIndex(ArrayList<Movie> list, String id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMovieID().equals(id)){
                return i;
            }
        }
        return -1;
    }
}