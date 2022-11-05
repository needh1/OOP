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
                        break;
                    case 2:
                        break;
                    case 3:
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
}
