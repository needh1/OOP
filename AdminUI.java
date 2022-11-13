import java.util.ArrayList;
import java.util.Scanner;
/**
 * User interface for admin.
 */
public class AdminUI
{
    Scanner sc = new Scanner(System.in);

    /**
     * Method to display menu for admin to use.
     */
    public void adminUI(){
        boolean loggedIn = verify();
        while(loggedIn){
            System.out.println("\n_______Admin_______");
            System.out.println("1. Create/Update/Remove movie Listing\n"+
                                "2. Create/Update/Remove movie showings\n"+
                                "3. Configure system settings\n"+
                                "4. Create new admin account\n"+
                                "5. Return\n");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                switch(sc.nextInt()){
                    case 1:
                        CURListing curListing = new CURListing();
                        curListing.main();
                        break;
                    case 2:
                        CURShowing curShowing = new CURShowing();
                        curShowing.main();
                        break;
                    case 3:
                        ConfigureSystem configure = new ConfigureSystem();
                        configure.main();
                        break;
                    case 4:
                        registerAdmin();
                        break;
                    case 5:
                        loggedIn = false;
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
     * Verifies if user is a valid admin.
     * @return true if user enters a valid username and password, false otherwise.
     */
    private boolean verify(){
        System.out.print("Please enter username: ");
        String username = sc.next();
        System.out.print("Please enter password: ");
        String password = sc.next();
        sc.nextLine();

        AdminStorage storage = new AdminStorage();
        ArrayList<Admin> adminList = storage.read();
        for(Admin admin : adminList){
            if(admin.getUsername().equals(username)){
                if(admin.getPassword().equals(password)){
                    return true;
                }
                System.out.println("Wrong Password!");
                return false;
            }
        }
        System.out.println("Admin account does not exist!");
        return false;
    }

    /**
     * Registers a new admin account.
     * Can only be used by a valid admin.
     */
    private void registerAdmin(){
        System.out.println("\n_______Register admin account_______");
        System.out.print("Please enter new username: ");
        String username = sc.next();

        AdminStorage storage = new AdminStorage();
        ArrayList<Admin> adminList = storage.read();
        for(Admin admin : adminList){
            if(admin.getUsername().equals(username)){
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
