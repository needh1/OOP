import java.util.ArrayList;
import java.util.Scanner;

public class CURListing
{
    Scanner sc = new Scanner(System.in);

    public void main(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n___Create/Update/Remove movie Listing___");
            System.out.println("1. Create movie listing\n"+
                                "2. Update movie listing\n"+
                                "3. Remove movie listing\n"+
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
            }
        }
    }

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
        double duration = sc.nextDouble();

        sc.nextLine();
        System.out.print("Enter movie status(Coming Soon/Now Showing): ");
        String status = sc.nextLine();

        System.out.println("Enter movie synopsis: ");
        String synopsis = sc.nextLine();

        System.out.print("Enter movie director: ");
        String director = sc.nextLine();

        System.out.print("Enter movie cast: ");
        String cast = sc.nextLine();

        Movie newMovie = new Movie(id, title, type, duration, status, synopsis, director, cast, 0);
        storage.writeObject(newMovie);
    }

    private void update(){
        MovieStorage storage = new MovieStorage();

        System.out.print("Enter movie ID to update: ");
        String id = sc.next();

        ArrayList<Movie> movieList = storage.read();
        if(movieList.size() == 0){
            System.out.println("Movie does not exist in system.");
            return;
        }
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
							"7. Cast\n\n"+
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
                    double newDuration = sc.nextDouble();
                    movieList.get(getIndex(movieList, id)).setDuration(newDuration);
                    break;
                case 4:
                    System.out.print("Enter new status (Now Showing/End of Showing): ");
                    sc.nextLine();
                    String newStatus = sc.nextLine();
                    if(newStatus.equals("End of Showing")){
                        for(int i = 0; i < movieList.size(); i++){
                            if(movieList.get(i).getMovieID().equals(id)){
                                movieList.remove(i);
                                storage.replaceExistingFile(movieList);
                                System.out.println("Movie successfully removed!");
                                return;
                            }
                        }
                    }
                    movieList.get(getIndex(movieList, id)).setMovietitle(newStatus);
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

    private void remove(){
        System.out.print("Enter movie ID to remove: ");
        String id = sc.next();

        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieID().equals(id)){
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