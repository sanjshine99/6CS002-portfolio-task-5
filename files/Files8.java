package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/******************************************************************************
 * This example uses a collector to combine all the lines of a file into a
 * list and demonstrates both sequential and parallel processing.
 ******************************************************************************/

public class Files8 {

    public static void main(String[] args) throws IOException {
        // Path to the text file
        String filePath = "data/paragraph.txt";

        // Read and process lines sequentially
        long sequentialStartTime = System.nanoTime();
        processSequentially(filePath);
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = TimeUnit.NANOSECONDS.toMillis(sequentialEndTime - sequentialStartTime);

        System.out.println("Sequential processing time: " + sequentialDuration + " ms");

        // Read and process lines in parallel
        long parallelStartTime = System.nanoTime();
        processInParallel(filePath);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = TimeUnit.NANOSECONDS.toMillis(parallelEndTime - parallelStartTime);

        System.out.println("Parallel processing time: " + parallelDuration + " ms");
    }

    private static void processSequentially(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Sequential Processing:");
            List<String> lines = reader.lines().collect(Collectors.toList());
            lines.forEach(System.out::println);
        }
    }

    private static void processInParallel(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Parallel Processing:");
            Stream<String> lines = reader.lines().parallel();
            List<String> parallelLines = lines.collect(Collectors.toList());
            parallelLines.forEach(System.out::println);
        }
    }
}
