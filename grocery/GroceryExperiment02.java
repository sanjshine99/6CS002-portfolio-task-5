package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/******************************************************************************
 * This program uses a foreach loop which is less error-prone as it eliminates
 * the need for a loop control variable.
 ******************************************************************************/

public class GroceryExperiment02 {
  public static void main(String[] args) {
    // Read grocery list from file
    Path groceryListPath = Paths.get("data/groceryList.txt");
    try {
      Files.lines(groceryListPath)
          .forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
