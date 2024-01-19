package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/******************************************************************************
 * This version moves from imperative style to declarative style programming.
 * The explicit loop is removed, and a lambda expression is used to implement
 * what was previously the body of a loop. A lambda expression is a function
 * that can be passed as a parameter and does not have a name. Here the lambda
 * implements the Consumer interface, which takes a single parameter and
 * produces no return value.
 ******************************************************************************/

public class GroceryExperiment5 {
    public static void main(String[] args) {
        // Read grocery list from file
        Path groceryListPath = Paths.get("data/groceryList.txt");
        try {
            List<String> groceryList = Files.readAllLines(groceryListPath);

            // Use forEach and lambda expression to print each item
            groceryList.forEach(item -> System.out.println(item));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
