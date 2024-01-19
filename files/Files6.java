package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/******************************************************************************
 * This program prints the contents of a file on a single line using both
 * sequential and parallel streams.
 * 
 ******************************************************************************/

public class Files6 {

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
            String result = reader.lines().reduce("", String::concat);
            System.out.println(result);
        }
    }

    private static void processInParallel(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Parallel Processing:");
            Stream<String> lines = reader.lines().parallel();
            String result = lines.reduce("", String::concat);
            System.out.println(result);
        }
    }
}
