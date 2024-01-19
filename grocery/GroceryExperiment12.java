package grocery;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/******************************************************************************
 * This version reads a grocery list from a file and removes the letter 'e'
 * from each item using a Function.
 ******************************************************************************/

public class GroceryExperiment12 {
    class ERemover implements Function<String, String> {
        public String apply(String name) {
            return name.replaceAll("e", "");
        }
    }

    public void run() {
        // Read the grocery list from a file
        List<String> groceryList;
        try {
            groceryList = Files.lines(Paths.get("data/groceryList.txt"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error reading the grocery list from the file.");
            e.printStackTrace();
            return;
        }

        // Apply the ERemover function to each item in the grocery list
        List<String> modifiedList = groceryList.stream()
                .map(new ERemover())
                .collect(Collectors.toList());

        // Print the modified grocery list
        modifiedList.forEach(item -> System.out.println(item));
    }

    public static void main(String[] args) {
        new GroceryExperiment12().run();
    }
}
