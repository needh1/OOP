import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage
{
  public String[] readFile(String file_name){
    String[] entries = new String[999];
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file_name));
      int index = 0;
      String line = reader.readLine();
      while(line != null){
        entries[index++] = line;
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error occurred(Reading from file).");
      e.printStackTrace();
    }
    return entries;
  }
  
  public void writeFile(String file_name, String[] contents){
    try {
      FileWriter writer = new FileWriter(file_name, true);
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
}