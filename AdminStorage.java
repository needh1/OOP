import java.util.*;
import java.io.*;

/**
 * Represents a storage handler for admin accounts.
 * Used to store and retrieve admin account records.
 */
public class AdminStorage extends FileStorage
{
    /**
     * The file where admin account records will be stored in.
     */
    public final static String FILENAME = "admin.txt";

    /**
     * Adds the given admin account into the storage file.
     * @param o Admin account to be stored into the file.
     */
    public void writeObject(Object o) {
        if(o instanceof Admin){
            Admin admin = (Admin) o;
            ArrayList<Admin> allData = new ArrayList<Admin>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(admin);
                out.writeObject(allData);
                out.flush();
                out.close();
                System.out.println("Admin account created successfully!");
            } catch (IOException e) {
                System.out.println("Account creation unsuccessful.");
            }
        }
    }

    /**
     * Retrieves all the admin account records in the storage file.
     * @return {@link Admin} Returns list of admin accounts if found, else an empty list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Admin> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Admin> adminListing = (ArrayList<Admin>) ois.readObject();
            ois.close();
            return adminListing;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Admin>();
    }

    /**
     * Replaces the existing list of admin accounts with the given list.
     * @param data new list of admin accounts.
     */
    public void replaceExistingFile(ArrayList<Admin> data){
        File tempFile = new File(FILENAME);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            //
        }
    }
}