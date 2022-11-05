import java.util.*;
import java.io.*;


public class TicketStorage extends FileStorage
{
    public final static String FILENAME = "tickets.txt";

    public void writeObject(Object o) {
        if(o instanceof Ticket){
            Ticket ticket = (Ticket) o;
            ArrayList<Ticket> allData = new ArrayList<Ticket>();
            File file = new File(FILENAME);
            if (file.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(ticket);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Ticket> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Ticket> ticketList = (ArrayList<Ticket>) ois.readObject();
            ois.close();
            return ticketList;
        } catch (ClassNotFoundException e) {

        } catch (IOException e){

        }
        return new ArrayList<Ticket>();
    }

    public void replaceExistingFile(ArrayList<Ticket> data){
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
