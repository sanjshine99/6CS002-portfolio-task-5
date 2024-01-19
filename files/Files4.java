package files;

import java.io.*;

/******************************************************************************
 * This program uses both sequential and parallel streams to convert a text file
 * to upper case.
 * 
 ******************************************************************************/

public class Files4 {

    public static void main(String[] args) throws Exception {
        String filePath = "data/paragraph.txt";

        // Sequential Processing
        long sequentialStartTime = System.nanoTime();
        processSequentially(filePath);
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = (sequentialEndTime - sequentialStartTime) / 1_000_000; // convert to milliseconds

        System.out.println("Sequential processing time: " + sequentialDuration + " ms");

        // Parallel Processing
        long parallelStartTime = System.nanoTime();
        processInParallel(filePath);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = (parallelEndTime - parallelStartTime) / 1_000_000; // convert to milliseconds

        System.out.println("Parallel processing time: " + parallelDuration + " ms");
    }

    private static void processSequentially(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Sequential Processing:");
            reader.lines()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
    }

    private static void processInParallel(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Parallel Processing:");
            reader.lines()
                    .parallel()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
    }
}
