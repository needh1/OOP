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
                        AdminUI admin = new AdminUI();
                        admin.adminUI();
                        break;
                    case 2:
                        MoviegoerUI moviegoer = new MoviegoerUI();
                        moviegoer.movieGoerUI();
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
        String username = sc.next();

        AdminStorage storage = new AdminStorage();
        ArrayList<Admin> adminList = storage.read();
        for(Admin admin : adminList){
            if(admin.getUsername() == username){
                System.out.println("Username already exists.");
                return;
            }
        }
        System.out.print("Please enter password: ");
        String password = sc.next();
        Admin newAdmin = new Admin(username, password);

        
        storage.writeObject(newAdmin);
    }
}