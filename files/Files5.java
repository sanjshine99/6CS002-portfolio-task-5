package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/******************************************************************************
 * This program sorts the lines of a file so that the shortest lines are
 * output last using both sequential and parallel streams.
 ******************************************************************************/

public class Files5 {

    public static void main(String[] args) throws Exception {
        String filePath = "data/paragraph.txt"; // Updated file path

        // Sequential Stream
        long sequentialStartTime = System.nanoTime();
        processSequentially(filePath);
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = TimeUnit.NANOSECONDS.toMillis(sequentialEndTime - sequentialStartTime);
        System.out.println("Sequential Stream Time: " + sequentialDuration + " ms");

        // Parallel Stream
        long parallelStartTime = System.nanoTime();
        processInParallel(filePath);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = TimeUnit.NANOSECONDS.toMillis(parallelEndTime - parallelStartTime);
        System.out.println("Parallel Stream Time: " + parallelDuration + " ms");
    }

    private static void processSequentially(String filePath) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = r.lines().toList(); // Read lines into a List

            System.out.println("Sequential Stream:");
            lines.stream().sorted((a, b) -> Integer.compare(b.length(), a.length()))
                    .forEach(l -> System.out.println(l));
        }
    }

    private static void processInParallel(String filePath) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = r.lines().toList(); // Read lines into a List

            System.out.println("\nParallel Stream:");
            List<String> parallelResult = lines.parallelStream()
                    .sorted((a, b) -> Integer.compare(b.length(), a.length()))
                    .collect(Collectors.toList());
            parallelResult.forEach(l -> System.out.println(l));
        }
    }
}
