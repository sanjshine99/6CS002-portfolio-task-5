package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/******************************************************************************
 * In this code, the array is converted to a List so that advantages of the
 * Collections API may be used later.
 * 
 ******************************************************************************/

public class GroceryExperiment3 {
    public static void main(String[] args) {
        // Read grocery list from file
        Path groceryListPath = Paths.get("data/groceryList.txt");
        try {
            List<String> groceryList = Files.readAllLines(groceryListPath);

            System.out.println(groceryList.getClass());

            for (String item : groceryList) {
                System.out.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
