import java.util.*;

public abstract class FileStorage
{
  public abstract void writeFile(Object o);
  public abstract ArrayList<Object> readFile();
}
