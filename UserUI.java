import java.util.Scanner;


public class UserUI
{
    Scanner sc = new Scanner(System.in);

    public void adminUI(){
        boolean quit = false;
        while(!quit){
            System.out.println("_______Admin_______");
            System.out.println("1. Create/Update/Remove movie Listing\n"+
                                "2. Create/Update/Remove movie showings\n"+
                                "3. Configure system settings\n"+
                                "4. Return");
            System.out.print("Enter choice: ");
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
                    System.out.println("Invalid choice\n\n");
            }
        }
    }

    public void visitorUI(){
        boolean quit = false;
        while(!quit){
            System.out.println("_______Movie-goer_______");
            System.out.println("1. Search/List movies\n"+
                                "2. View movie details\n"+
                                "3. Check seat availability and selection of seat/s\n"
                                "4. Book and purchase ticket\n"+
                                "5. View booking history\n"+
                                "6. List Top 5 movie ranking\n"+
                                "7. Return\n\n");
            System.out.print("Enter choice: ");
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
                    System.out.println("Invalid choice\n\n");
            }
        }
    }
}