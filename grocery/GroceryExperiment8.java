package grocery;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/******************************************************************************
 * This version uses a stream then a parallel stream to process the grocery
 * list.
 * It reads the data from a file, and then prints the items in serial and
 * parallel
 * streams. Execution times are measured for both serial and parallel streams.
 * Note: Ensure the file path is correct and the file exists.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class GroceryExperiment8 {

    public void run() {
        try {
            // Read grocery list from the file
            List<String> groceryList = Files.readAllLines(Paths.get("data/groceryList.txt"));

            // Serial Stream
            System.out.println("Serial names\n---------");
            long startSerial = System.currentTimeMillis();
            groceryList.stream().forEach(item -> System.out.println(item));
            long endSerial = System.currentTimeMillis();
            System.out.println("Serial execution time: " + (endSerial - startSerial) + " milliseconds");

            // Parallel Stream
            System.out.println("\nParallel names\n---------");
            long startParallel = System.currentTimeMillis();
            groceryList.parallelStream().forEach(item -> System.out.println(item));
            long endParallel = System.currentTimeMillis();
            System.out.println("Parallel execution time: " + (endParallel - startParallel) + " milliseconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GroceryExperiment8().run();
    }
}
