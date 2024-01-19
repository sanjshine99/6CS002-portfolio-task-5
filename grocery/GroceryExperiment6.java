package grocery;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

/******************************************************************************
 * This version reads a grocery list from a file and prints each item using a
 * custom StringPrintConsumer. It demonstrates reading from a file and applying
 * functional programming concepts.
 ******************************************************************************/

public class GroceryExperiment6 {
    // Custom consumer for printing strings
    class StringPrintConsumer implements Consumer<String> {
        public void accept(String str) {
            System.out.println(str);
        }
    }

    // Method to read grocery list from a file and process it
    public void run() {
        // Specify the path to the grocery list file
        Path filePath = Paths.get("data/groceryList.txt");

        try {
            // Read all lines from the file into a list
            List<String> groceryList = Files.readAllLines(filePath);

            // Create a consumer instance
            StringPrintConsumer stringPrintConsumer = new StringPrintConsumer();

            // Print each item in the grocery list using the consumer
            groceryList.forEach(stringPrintConsumer);
        } catch (Exception e) {
            // Handle any exceptions, e.g., file not found or IO error
            System.err.println("Error reading the grocery list: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new GroceryExperiment6().run();
    }
}
