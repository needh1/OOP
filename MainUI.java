import java.util.Scanner;
/**
 * Main user interface for MOBLIMA
 */
public class MainUI
{
    Scanner sc = new Scanner(System.in);

    public void mainUI(){
        initializeSystem();

        boolean quit = false;
        while(!quit){
            System.out.println("\n_______Welcome to MOBLIMA_______");
            System.out.println("1. Admin Login\n"+
                                "2. Movie-goer Access\n"+
                                "3. Quit\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        AdminUI admin = new AdminUI();
                        admin.adminUI();
                        break;
                    case 2:
                        MoviegoerUI moviegoer = new MoviegoerUI();
                        moviegoer.moviegoerUI();
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
     * Initialise key storage classes.
     */
    private static void initializeSystem(){
        PriceStorage priceStore = new PriceStorage();
        if(priceStore.read().getSize() == 0){
            InitializePrices initPrice = new InitializePrices();
            initPrice.initialize();            
        }

        CineplexStorage cineplexStore = new CineplexStorage();
        if(cineplexStore.read().size() == 0){
            InitializeCineplex initCineplex = new InitializeCineplex();
            initCineplex.initialize();
        }

        AdminStorage adminStore = new AdminStorage();
        if(adminStore.read().size() == 0){
            Admin newAdmin = new Admin("default", "default");
            adminStore.writeObject(newAdmin);
        }
    }
}