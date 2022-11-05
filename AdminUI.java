import java.util.ArrayList;
import java.util.Scanner;

public class AdminUI
{
    Scanner sc = new Scanner(System.in);


    public void adminUI(){
        boolean loggedIn = verify();
        while(loggedIn){
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

    public boolean verify(){
        System.out.print("Please enter username: ");
        String username = sc.next();
        System.out.print("Please enter password: ");
        String password = sc.next();

        AdminStorage storage = new AdminStorage();
        ArrayList<Admin> adminList = storage.read();
        for(Admin admin : adminList){
            if(admin.getUsername() == username){
                if(admin.getPassword() == password){
                    return true;
                }
                System.out.println("Wrong Password!");
                return false;
            }
        }
        System.out.println("Admin account does not exist!");
        return false;
    }
}