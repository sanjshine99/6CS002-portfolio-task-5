package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

/******************************************************************************
 * This program demonstrates using Optional String.
 ******************************************************************************/

public class Files7 {

    public static void main(String[] args) throws Exception {
        String filePath = "data/paragraph.txt";

        // Sequential Stream
        try (BufferedReader sequentialReader = new BufferedReader(new FileReader(filePath))) {
            Optional<String> sequentialResult = sequentialReader.lines()
                    .reduce((left, right) -> left.concat(" ".concat(right)));

            sequentialResult.ifPresentOrElse(
                    value -> System.out.println("Sequential Result: " + value),
                    () -> System.out.println("Sequential Result not present"));
        }

        // Parallel Stream
        try (BufferedReader parallelReader = new BufferedReader(new FileReader(filePath))) {
            Optional<String> parallelResult = parallelReader.lines().parallel()
                    .reduce((left, right) -> left.concat(" ".concat(right)));

            parallelResult.ifPresentOrElse(
                    value -> System.out.println("Parallel Result: " + value),
                    () -> System.out.println("Parallel Result not present"));
        }
    }
}
