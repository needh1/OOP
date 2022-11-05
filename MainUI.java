import java.util.Scanner;


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
                                "3. New Admin account"+
                                "4. Quit");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        adminUI();
                        break;
                    case 2:
                        movieGoerUI();
                        break;
                    case 3:
                        registerAdmin();
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


    public void adminUI(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n_______Admin_______");
            System.out.println("1. Create/Update/Remove movie Listing\n"+
                                "2. Create/Update/Remove movie showings\n"+
                                "3. Configure system settings\n"+
                                "4. Return\n");
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


    public void movieGoerUI(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n_______Movie-goer_______");
            System.out.println("1. Search/List movies\n"+
                                "2. View movie details\n"+
                                "3. Check seat availability and selection of seat\n"+
                                "4. Book and purchase ticket\n"+
                                "5. View booking history\n"+
                                "6. List Top 5 movie ranking\n"+
                                "7. Return\n");
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
                        break;
                    case 6:
                        break;
                    case 7:
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
    }

    public void registerAdmin(){
        System.out.println("\n_______Register admin account_______");
        System.out.print("Please enter new username: ");
        String username = sc.nextLine();
        System.out.print("Please enter password: ");
        String password = sc.nextLine();
        Admin newAdmin = new Admin(username, password);

        AdminStorage storage = new AdminStorage();
        storage.writeObject(newAdmin);
    }
}