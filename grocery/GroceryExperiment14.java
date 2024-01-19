package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/******************************************************************************
 * This version uses a StreamBuilder to generate a Stream of grocery items
 * read from a file (grocery-list.txt).
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class GroceryExperiment14 {

    class GroceryListStreamBuilder {
        public Stream<String> build() {
            Stream.Builder<String> builder = Stream.builder();

            // Read grocery items from the file and add them to the stream
            try {
                Path filePath = Paths.get("data/groceryList.txt");
                Files.lines(filePath)
                        .forEach(builder::add);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return builder.build();
        }
    }

    public void run() {
        GroceryListStreamBuilder builder = new GroceryListStreamBuilder();
        Stream<String> groceryStream = builder.build();

        // Print each grocery item
        groceryStream.forEach(item -> System.out.println(item));
    }

    public static void main(String[] args) {
        new GroceryExperiment14().run();
    }
}
