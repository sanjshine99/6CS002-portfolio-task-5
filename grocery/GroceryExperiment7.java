package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

/******************************************************************************
 * This version reads a grocery list from a file and uses an anonymous inner
 * class to print each item.
 * 
 ******************************************************************************/

public class GroceryExperiment7 {

    public void run() {
        // Load grocery list from file
        List<String> groceryList;
        try {
            groceryList = Files.readAllLines(Paths.get("data/groceryList.txt"));
        } catch (IOException e) {
            System.err.println("Error reading the grocery list file: " + e.getMessage());
            return;
        }

        // Print each item using an anonymous inner class
        groceryList.forEach(new Consumer<String>() {
            public void accept(String item) {
                System.out.println(item);
            }
        });
    }

    public static void main(String[] args) {
        new GroceryExperiment7().run();
    }
}
