package grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/******************************************************************************
 * This program demonstrates the use of parallel and sequential streams to
 * process a grocery list stored in a text file.
 * 
 ******************************************************************************/

public class GroceryExperiment01 {
  public static void main(String[] args) {
    // Specify the path to the grocery list file
    String filePath = "data/groceryList.txt";

    try {
      // Read the lines from the file into a list
      List<String> groceryList = Files.lines(Paths.get(filePath))
          .collect(Collectors.toList());

      // Measure time for sequential stream
      long startTimeSeq = System.currentTimeMillis();
      System.out.println("Sequential Stream:");
      groceryList.stream().forEach(GroceryExperiment01::processItem);
      long endTimeSeq = System.currentTimeMillis();
      long elapsedTimeSeq = endTimeSeq - startTimeSeq;
      System.out.println("Time taken for sequential stream: " + elapsedTimeSeq + " milliseconds\n");

      // Measure time for parallel stream
      long startTimeParallel = System.currentTimeMillis();
      System.out.println("Parallel Stream:");
      groceryList.parallelStream().forEach(GroceryExperiment01::processItem);
      long endTimeParallel = System.currentTimeMillis();
      long elapsedTimeParallel = endTimeParallel - startTimeParallel;
      System.out.println("Time taken for parallel stream: " + elapsedTimeParallel + " milliseconds");

    } catch (IOException e) {
      // Handle file reading exception
      e.printStackTrace();
    }
  }

  private static void processItem(String item) {
    // Simulate some processing on each grocery item
    // Adjust this method based on your actual processing needs
    System.out.println(item);
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
