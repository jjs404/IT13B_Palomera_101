import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PRACTICE {
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("C:\\Users\\Palomera\\OneDrive\\Desktop\\PALOMERA_PRACTICE.txt");
      myWriter.write("I Love YOU!\nGwapa ko!\nBuotan si Ma'am");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
