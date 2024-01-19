package grocery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * This version uses a Supplier to generate grocery items from a file.
 * The grocery list is read from the "grocery-list.txt" file.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 */
public class GroceryExperiment13 {

    class GrocerySupplier implements Supplier<String> {
        private String[] groceries;
        private int nextIndex;

        public GrocerySupplier(String filePath) {
            // Initialize the grocery list from the file
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                groceries = reader.lines().toArray(String[]::new);
            } catch (IOException e) {
                e.printStackTrace();
            }

            nextIndex = 0;
        }

        public String get() {
            if (nextIndex < groceries.length) {
                return groceries[nextIndex++];
            }
            return null;
        }
    }

    public void run() {
        // Provide the path to your grocery list file
        String groceryListFilePath = "data/groceryList.txt";

        // Create a GrocerySupplier instance
        GrocerySupplier grocerySupplier = new GrocerySupplier(groceryListFilePath);

        // Print a few items from the grocery list
        System.out.println(grocerySupplier.get());
        System.out.println(grocerySupplier.get());
        System.out.println(grocerySupplier.get());
        System.out.println(grocerySupplier.get());
    }

    public static void main(String[] args) {
        new GroceryExperiment13().run();
    }
}
