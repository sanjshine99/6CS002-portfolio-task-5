package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/******************************************************************************
 * This version introduces the use of Predicates. A predicate is a boolean
 * valued function. Here we use a lambda to implement a predicate that filters
 * out names that do not include an 'e' character.
 ******************************************************************************/

public class GroceryExperiment10 {

    public void run() {
        try {
            // Read grocery items from the file
            List<String> groceryList = readGroceryListFromFile("data/groceryList.txt");

            // Print items containing the letter 'e'
            groceryList.stream()
                    .filter(item -> item.contains("e"))
                    .forEach(item -> System.out.println(item));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readGroceryListFromFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllLines(filePath);
    }

    public static void main(String[] args) {
        new GroceryExperiment10().run();
    }
}
