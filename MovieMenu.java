import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MovieMenu 
{
    Scanner sc = new Scanner(System.in);

    public void main(Movie movie) {
        boolean quit = false;
        while(!quit){
            String heading = String.format("\n___%s___", movie.getMovieTitle());
            System.out.println(heading);
            System.out.println("1. View movie details\n"+
                                "2. Movie rating/reviews\n"+
                                "3. View showtimes and seat availability\n"+
                                "4. Book ticket\n"+
                                "5. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        viewDetails(movie);
                        break;
                    case 2:
                        review(movie);
                        break;
                    case 3:
                        showtimes(movie).getSeating().printLayout();
                        break;
                    case 4:
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

    private void review(Movie movie) {
        boolean quit = false;
        while(!quit){
            System.out.println("\n_____Ratings/Reviews_____");
            System.out.println("1. View reviews\n"+
                                "2. New review\n"+
                                "3. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        viewReviews(movie);
                        break;
                    case 2:
                        newReview(movie);
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

    private void viewDetails(Movie movie) {
        String text;
        System.out.println();
        text = String.format("Movie title: %s", movie.getMovieTitle());
        System.out.println(text);
        text = String.format("Showing status: %s", movie.getStatus());
        System.out.println(text);
        text = String.format("Sypnosis: %s", movie.getSynopsis());
        System.out.println(text);
        text = String.format("Director: %s", movie.getDirector());
        System.out.println(text);
        text = String.format("Cast: %s", movie.getCast());
        System.out.println(text);
        if (movie.numReview() > 1) text = String.format("Overall Rating: %,.1f", movie.avgRating());
        else text = "Overall Rating: NA";
        System.out.println(text);
    }

    private void viewReviews(Movie movie) {
        String text;
        if (movie.numReview() > 1) text = String.format("\nOverall Rating: %,.1f", movie.avgRating());
        else text = "\nOverall Rating: NA";
        System.out.println(text);
        System.out.println("\n_____Reviews_____\n");
        ArrayList<Review> reviewList = movie.getReviewList();
        for (Review review : reviewList) {
            text = String.format("Rating: %d\n", review.getReviewRating());
            System.out.println(text);
            text = String.format("Review: %s\n", review.getReviewContent());
            System.out.println(text);
        }
    }
    
    private void newReview(Movie movie) {
        int rating;
        System.out.println();
        System.out.print("\nRate the new movie from 1-5: ");
        if (sc.hasNextInt()) {
            rating = sc.nextInt();
        }
        else {
            System.out.println("Please enter an integer from 1-5!\n");
            sc.nextLine();
            return;
        }
        if (rating > 5 || rating < 1) {
            System.out.println("Please enter an integer from 1-5!\n");
            return;
        }
        System.out.print("\nReview content: ");
        String content = sc.nextLine();
        movie.addReview(rating, content);
        System.out.println("Review has been added!");
    }

    private Showing showtimes(Movie movie) {
        ShowingStorage storage = new ShowingStorage();
        ArrayList<Showing> showingList = storage.read();
        ArrayList<Showing> movieShowing = new ArrayList<>();
        ArrayList<LocalDate> dateShowing = new ArrayList<>();
        ArrayList<Showing> timeShowing = new ArrayList<>();
        showingList.sort(Comparator.comparing(Showing::getDate));
        for (Showing show : showingList){
            if (movie.getMovieTitle() == show.getMovieTitle()) movieShowing.add(show);
        }
        for (Showing show : movieShowing){
            if (dateShowing.contains(show.getDate()) == false) dateShowing.add(show.getDate());
        }    

        while(true){
            System.out.println("\n_____Dates_____");
            for (int i = 0; i < dateShowing.size(); i++) {
                String formattedDate = dateShowing.get(i).format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
                String text = String.format("%d. %s", i+1, formattedDate);
                System.out.println(text);
            }
            System.out.println("\n0. Return\n");      
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice == 0) return null;
                if (choice < 0 || choice > dateShowing.size()){
                    System.out.println("Invalid Input!\n");
                    continue;
                }
                LocalDate date = dateShowing.get(choice-1);
                for (Showing show : movieShowing){
                    if (show.getDate() == date) timeShowing.add(show);
                }
                timeShowing.sort(Comparator.comparing(Showing::getTime));
                boolean quit = false;
                while(!quit) {
                    System.out.println("\n_____Timings_____");
                    for (int i = 0; i < timeShowing.size(); i++) {
                        String formattedTime = timeShowing.get(i).getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
                        String text = String.format("%d. %s", i+1, formattedTime);
                        System.out.println(text);
                    }
                    System.out.println("\n0. Return\n");      
                    System.out.print("Enter choice: ");
                    if (sc.hasNextInt()) {
                        choice = sc.nextInt();
                        if (choice == 0) {
                            quit = true;
                            continue;
                        }
                        if (choice < 0 || choice > timeShowing.size()){
                            System.out.println("Invalid Input!\n");
                            continue;
                        }
                        System.out.println("\n___Seating Availability___");
                        return timeShowing.get(choice-1);
                    }
                    else {
                        System.out.println("Please enter an integer!\n");
                        sc.nextLine();
                    }
                }
            }
            else {
                System.out.println("Please enter an integer!\n");
                sc.nextLine();
            }   
        }
    }
}
