package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/******************************************************************************
 * This version introduces the use of a Function. A function takes a parameter
 * and returns a result. In this case, all occurrences of the lowercase letter e
 * are removed from the grocery items read from a file.
 * 
 * Note: Make sure to create a "grocery-list.txt" file with the desired items.
 ******************************************************************************/

public class GroceryExperiment11 {

    public void run() {
        // Specify the path to the grocery list file
        String filePath = "data/groceryList.txt";

        try {
            // Read lines from the file into a List
            List<String> groceryItems = Files.readAllLines(Paths.get(filePath));

            // Process each grocery item using stream and remove 'e'
            groceryItems.stream()
                    .map(item -> item.replaceAll("e", ""))
                    .forEach(item -> System.out.println(item));

        } catch (IOException e) {
            // Handle potential IO exception (e.g., file not found)
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new GroceryExperiment11().run();
    }
}
