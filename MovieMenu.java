import java.time.LocalDate;
import java.time.LocalDateTime;
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
                        Showing showTime = showtimes(movie);
                        if(showTime != null){
                            showTime.getSeating().printLayout();
                        }
                        sc.nextLine();
                        break;
                    case 4:
                        Showing showBooking = showtimes(movie);
                        if(showBooking != null){
                            booking(showBooking);
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
        text = String.format("Movie rating: %s", movie.getMovieRating());
        System.out.println(text);
        text = String.format("Showing status: %s", movie.getStatus());
        System.out.println(text);
        text = String.format("Sypnosis: %s", movie.getSynopsis());
        System.out.println(text);
        text = String.format("Director: %s", movie.getDirector());
        System.out.println(text);
        text = String.format("Cast: %s", movie.getCast());
        System.out.println(text);
        if (movie.numReview() > 1) text = String.format("Overall Rating: %.1f", movie.avgRating());
        else text = "Overall Rating: NA";
        System.out.println(text);
    }

    private void viewReviews(Movie movie) {
        String text;
        if (movie.numReview() > 1) text = String.format("\nOverall Rating: %.1f", movie.avgRating());
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
        MovieStorage storage = new MovieStorage();
        ArrayList<Movie> movieList = storage.read();
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
        sc.nextLine();
        System.out.print("\nReview content: ");
        String content = sc.nextLine();
        for (Movie chosen : movieList) {
            if (chosen == movie) {
                chosen.addReview(rating, content);
            } 
        }
        storage.replaceExistingFile(movieList);
        System.out.println("Review has been added!");
        
    }

    private Showing showtimes(Movie movie) {
        ShowingStorage storage = new ShowingStorage();
        ArrayList<Showing> showingList = storage.read();
        ArrayList<Showing> movieShowing = new ArrayList<Showing>();
        ArrayList<LocalDate> dateShowing = new ArrayList<>();
        ArrayList<Showing> timeShowing = new ArrayList<>();
        showingList.sort(Comparator.comparing(Showing::getDate));
        for (Showing show : showingList){
            if (movie.getMovieTitle().equals(show.getMovieTitle())) movieShowing.add(show);
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
                timeShowing = new ArrayList<>();
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
    
    private void booking(Showing showtimes) {
        HolidayStorage storage = new HolidayStorage();
        ArrayList<Holiday> holidayList = storage.read();
        MovieStorage storage2 = new MovieStorage();
        ArrayList<Movie> movieList = storage2.read();
        PriceStorage storage3 = new PriceStorage();
        Price priceList = storage3.read();
        showtimes.getSeating().printLayout();
        sc.nextLine();
        while(true){
            System.out.print("Choose seat to book (integers 'RowColumn'): ");
            String text = sc.nextLine();

            try{
                int code = Integer.parseInt(text);
                if(code/10 > showtimes.getSeating().getRow() || code%10 > showtimes.getSeating().getColumn() || code/10 <= 0 || code%10 <= 0){
                    System.out.println("Invalid seat number!");
                    continue;
                }
                if(showtimes.getSeating().getSeat(code).occupied()){
                    System.out.println("Seat is occupied.");
                    continue;
                }
                System.out.println("\n_____Cost of Ticket_____");
                LocalDate date = showtimes.getDate();
                boolean isHoliday = false;
                MovieType movieType = null;
                CinemaType cinemaType = showtimes.getSeating().getType();
                for(Holiday holiday: holidayList){
                    if(date == holiday.getHolidayDate()){
                        isHoliday = true;
                    }
                }
                for (Movie movie: movieList) {
                    if (showtimes.getMovieTitle() == movie.getMovieTitle()) {
                        movieType = movie.getType();
                    }
                }
                System.out.println("Price of ticket:");
                double price1, price2, price3;
                if (isHoliday || date.getDayOfWeek().name() == "SATURDAY" || date.getDayOfWeek().name() == "SUNDAY") {
                    if (movieType == MovieType._2D) {
                        if (cinemaType == CinemaType.STANDARD) {
                            price1 = priceList.getPrice(PricingType.WEEKEND_2D_STANDARD);
                        }
                        else {
                            price1 = priceList.getPrice(PricingType.WEEKEND_2D_PREMIUM);
                        }
                    }
                    else {
                        if (cinemaType == CinemaType.STANDARD) {
                            price1 = priceList.getPrice(PricingType.WEEKEND_3D_STANDARD);
                        }
                        else {
                            price1 = priceList.getPrice(PricingType.WEEKEND_3D_PREMIUM);
                        }
                    }
                    while (true) {
                        text = String.format("1. Weekend/Holiday: $%.2f", price1);
                        System.out.println(text);
                        System.out.println("2. Return");
                        System.out.print("\nEnter choice: ");
                        if (sc.hasNextInt()) {
                            switch(sc.nextInt()){
                                case 1:
                                    purchase(showtimes, code, price1);
                                    return;
                                case 2:
                                    return;
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
                else {
                    if (movieType == MovieType._2D) {
                        if (cinemaType == CinemaType.STANDARD) {
                            while (true) {
                                price1 = priceList.getPrice(PricingType.NORMAL_2D_STANDARD);
                                text = String.format("1. Normal: $%.2f", price1);
                                System.out.println(text);
                                price2 = priceList.getPrice(PricingType.STUDENT_2D_STANDARD);
                                text = String.format("2. Student: $%.2f", price2);
                                System.out.println(text);
                                price3 = priceList.getPrice(PricingType.SENIOR_2D_STANDARD);
                                text = String.format("3. Senior: $%.2f", price3);
                                System.out.println(text);
                                System.out.println("4. Return");
                                System.out.print("\nEnter choice: ");
                                if (sc.hasNextInt()) {
                                    switch(sc.nextInt()){
                                        case 1:
                                            purchase(showtimes, code, price1);
                                            return;
                                        case 2:
                                            purchase(showtimes, code, price2);
                                            return;
                                        case 3:
                                            purchase(showtimes, code, price3);
                                            return;
                                        case 4:
                                            return;
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
                        else {
                            while (true) {
                                price1 = priceList.getPrice(PricingType.NORMAL_2D_PREMIUM);
                                text = String.format("1. Normal: $%.2f", price1);
                                System.out.println(text);
                                price2 = priceList.getPrice(PricingType.STUDENT_2D_PREMIUM);
                                text = String.format("2. Student: $%.2f", price2);
                                System.out.println(text);
                                price3 = priceList.getPrice(PricingType.SENIOR_2D_PREMIUM);
                                text = String.format("3. Senior: $%.2f", price3);
                                System.out.println(text);
                                System.out.println("4. Return");
                                System.out.print("\nEnter choice: ");
                                if (sc.hasNextInt()) {
                                    switch(sc.nextInt()){
                                        case 1:
                                            purchase(showtimes, code, price1);
                                            return;
                                        case 2:
                                            purchase(showtimes, code, price2);
                                            return;
                                        case 3:
                                            purchase(showtimes, code, price3);
                                            return;
                                        case 4:
                                            return;
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
                    }
                    else {
                        if (cinemaType == CinemaType.STANDARD) {
                            while (true) {
                                price1 = priceList.getPrice(PricingType.NORMAL_3D_STANDARD);
                                text = String.format("1. Normal: $%.2f", price1);
                                System.out.println(text);
                                price2 = priceList.getPrice(PricingType.STUDENT_3D_STANDARD);
                                text = String.format("2. Student: $%.2f", price2);
                                System.out.println(text);
                                price3 = priceList.getPrice(PricingType.SENIOR_3D_STANDARD);
                                text = String.format("3. Senior: $%.2f", price3);
                                System.out.println(text);
                                System.out.println("4. Return");
                                System.out.print("\nEnter choice: ");
                                if (sc.hasNextInt()) {
                                    switch(sc.nextInt()){
                                        case 1:
                                            purchase(showtimes, code, price1);
                                            return;
                                        case 2:
                                            purchase(showtimes, code, price2);
                                            return;
                                        case 3:
                                            purchase(showtimes, code, price3);
                                            return;
                                        case 4:
                                            return;
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
                        else {
                            while (true) {
                                price1 = priceList.getPrice(PricingType.NORMAL_3D_PREMIUM);
                                text = String.format("1. Normal: $%.2f", price1);
                                System.out.println(text);
                                price2 = priceList.getPrice(PricingType.STUDENT_3D_PREMIUM);
                                text = String.format("2. Student: $%.2f", price2);
                                System.out.println(text);
                                price3 = priceList.getPrice(PricingType.SENIOR_3D_PREMIUM);
                                text = String.format("3. Senior: $%.2f", price3);
                                System.out.println(text);
                                System.out.println("4. Return");
                                System.out.print("\nEnter choice: ");
                                if (sc.hasNextInt()) {
                                    switch(sc.nextInt()){
                                        case 1:
                                            purchase(showtimes, code, price1);
                                            return;
                                        case 2:
                                            purchase(showtimes, code, price2);
                                            return;
                                        case 3:
                                            purchase(showtimes, code, price3);
                                            return;
                                        case 4:
                                            return;
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
                    }
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Please enter an integer!\n");
            }
        }
        
    }

    private void purchase(Showing showtimes, int seat, double price) {
        BookingStorage storage1 = new BookingStorage();
        MovieStorage storage2 = new MovieStorage();
        ShowingStorage storage3 = new ShowingStorage();
        ArrayList<Showing> showingList = storage3.read();
        ArrayList<Movie> movieList = storage2.read();
        System.out.println("\n____Ticket Purchase____");
        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("\nEmail Address: ");
        String email = sc.nextLine();
        int number;
        while (true) {
            System.out.print("\nPhone Number: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                break;
            }
            else {
                System.out.println("Please enter an integer!\n");
                sc.nextLine();
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();  
        String formatted = now.format(dtf);
        String id = showtimes.getSeating().getCode() + formatted;  
        Booking newBooking = new Booking(name, email, id, number, price, showtimes, seat);
        storage1.writeObject(newBooking);     
        showtimes.getSeating().assignSeat(seat);
        for (Movie movie: movieList) {
            if (showtimes.getMovieTitle() == movie.getMovieTitle()) {
                movie.incTicketSales();
            }
        }
        for(int i = 0; i < showingList.size(); i++){
            if(showingList.get(i).getShowingID().equals(showtimes.getShowingID())){
                showingList.set(i, showtimes);
                break;
            }
        }
        storage2.replaceExistingFile(movieList);
        storage3.replaceExistingFile(showingList);
        System.out.println("Booking and purchase is successful!");
    }

}