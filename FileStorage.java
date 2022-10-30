import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class FileStorage
{
  //Reads entire file into an array
  public ArrayList<String> readFile(String file_name){
    ArrayList<String> entries = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file_name));
      int index = 0;
      String line = reader.readLine();
      while(line != null){
        entries.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error occurred(Reading from file).");
      e.printStackTrace();
    }
    return entries;
  }
  
  //Overwrites file
  public void writeFile(String file_name, ArrayList<String> contents){
    try {
      FileWriter writer = new FileWriter(file_name);
      writer.write(contents[0]);
      for(int i = 1; i < contents.length; i++){
        writer.write("\n" + contents[i]);
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Error occurred(Writing to file).");
      e.printStackTrace();
    }
  }

  // Adds an object into file
  public void addObject(String file_name, String contents){
    try {
      FileWriter writer = new FileWriter(file_name, true);
      writer.write("\n" + contents);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error occurred(Writing to file).");
      e.printStackTrace();
    }
  }
}
