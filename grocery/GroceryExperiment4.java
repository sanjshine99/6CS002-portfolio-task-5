package grocery;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/******************************************************************************
 * In this code, the array is converted to a List and the methods available to
 * are listed using reflection. Note this is an immutable list, so methods
 * such as add, which are defined in the List interface, are not available. To
 * prove this, try adding a name to the list (uncomment the code below).
 ******************************************************************************/

public class GroceryExperiment4 {
    public static void main(String[] args) {
        // Read grocery list from file
        Path groceryListPath = Paths.get("data/groceryList.txt");
        try {
            List<String> groceryList = Files.readAllLines(groceryListPath);
            List<String> immutableList = Collections.unmodifiableList(groceryList);

            System.out.println(immutableList.getClass());

            for (Method m : immutableList.getClass().getDeclaredMethods()) {
                System.out.println(m.getName());
            }
            // Uncommenting the line below will result in a runtime error
            // immutableList.add("new item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
