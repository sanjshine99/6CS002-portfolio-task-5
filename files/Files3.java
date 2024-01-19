package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/******************************************************************************
 * This code shows how to process lines of a text file containing the word
 * "along"
 * using both sequential and parallel streams.
 ******************************************************************************/

public class Files3 {

    public static void main(String[] args) throws IOException {
        // Path to the text file
        String filePath = "data/paragraph.txt";

        // Read and process lines containing "along" sequentially
        long sequentialStartTime = System.nanoTime();
        processSequentially(filePath, "along");
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = TimeUnit.NANOSECONDS.toMillis(sequentialEndTime - sequentialStartTime);

        System.out.println("Sequential processing time: " + sequentialDuration + " ms");

        // Read and process lines containing "along" in parallel
        long parallelStartTime = System.nanoTime();
        processInParallel(filePath, "along");
        long parallelEndTime = System.nanoTime();
        long parallelDuration = TimeUnit.NANOSECONDS.toMillis(parallelEndTime - parallelStartTime);

        System.out.println("Parallel processing time: " + parallelDuration + " ms");
    }

    private static void processSequentially(String filePath, String keyword) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Sequential Processing:");
            reader.lines().filter(line -> line.contains(keyword)).forEach(System.out::println);
        }
    }

    private static void processInParallel(String filePath, String keyword) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Parallel Processing:");
            Stream<String> lines = reader.lines().parallel();
            lines.filter(line -> line.contains(keyword)).forEach(System.out::println);
        }
    }
}
