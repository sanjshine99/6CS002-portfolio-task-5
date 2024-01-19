package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/******************************************************************************
 * This program counts the number of lines in a text file using both sequential
 * and parallel streams.
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class Files2 {

    public static void main(String[] args) throws IOException {
        // Path to the text file
        String filePath = "data/paragraph.txt";

        // Count lines sequentially
        long sequentialStartTime = System.nanoTime();
        long sequentialCount = countSequentially(filePath);
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = TimeUnit.NANOSECONDS.toMillis(sequentialEndTime - sequentialStartTime);

        System.out.println("Sequential processing time: " + sequentialDuration + " ms");
        System.out.println("Sequential line count: " + sequentialCount);

        // Count lines in parallel
        long parallelStartTime = System.nanoTime();
        long parallelCount = countInParallel(filePath);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = TimeUnit.NANOSECONDS.toMillis(parallelEndTime - parallelStartTime);

        System.out.println("Parallel processing time: " + parallelDuration + " ms");
        System.out.println("Parallel line count: " + parallelCount);
    }

    private static long countSequentially(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().count();
        }
    }

    private static long countInParallel(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Stream<String> lines = reader.lines().parallel();
            return lines.count();
        }
    }
}
