import java.util.*;
import java.io.*;


public class AdminStorage extends FileStorage
{
    public final static String FILENAME = "admin.txt";

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
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Admin> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Admin> adminListing = (ArrayList<Admin>) ois.readObject();
            ois.close();
            return adminListing;
        } catch (ClassNotFoundException e) {
            System.out.println("Object does not exist.");
        } catch (IOException e){
            System.out.println("File does not exist.");
        }
        return new ArrayList<Admin>();
    }
}
