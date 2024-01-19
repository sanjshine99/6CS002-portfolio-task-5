package grocery;

import java.nio.file.*;
import java.util.*;

/******************************************************************************
 * This version introduces the use of Predicates. A predicate is a boolean
 * valued function. Here, we use a lambda to implement a predicate that filters
 * out items from the grocery list that do not include the letter 'e'.
 ******************************************************************************/

public class GroceryExperiment9 {

    public void run() {
        // Read grocery list from a file
        List<String> groceryList = readGroceryListFromFile("data/groceryList.txt");

        // Filter items containing the letter 'e'
        groceryList.stream().filter(item -> item.contains("e"))
                .forEach(item -> System.out.println(item));
    }

    private List<String> readGroceryListFromFile(String fileName) {
        List<String> groceryList = new ArrayList<>();
        try {
            // Read all lines from the file and add to the list
            groceryList = Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            System.err.println("Error reading the grocery list file: " + e.getMessage());
        }
        return groceryList;
    }

    public static void main(String[] args) {
        new GroceryExperiment9().run();
    }
}
