package grocery;

import java.time.Duration;
import java.time.LocalDate;
import java.util.function.Supplier;

/******************************************************************************
 * This example demonstrates the use of a supplier for capturing the current
 * date and includes sequential and parallel data processing with time
 * measurement.
 * Suppliers can be used in real-time applications for capturing various data.
 ******************************************************************************/

public class GroceryExperiment16 {
    public static void main(String[] args) {
        // Capture the current date using a supplier
        Supplier<LocalDate> dateSupplier = LocalDate::now;

        // Perform sequential data processing and measure the time
        long sequentialStartTime = System.nanoTime();
        processSequentially(dateSupplier);
        long sequentialEndTime = System.nanoTime();
        long sequentialDuration = Duration.ofNanos(sequentialEndTime - sequentialStartTime).toMillis();

        // Perform parallel data processing and measure the time
        long parallelStartTime = System.nanoTime();
        processInParallel(dateSupplier);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = Duration.ofNanos(parallelEndTime - parallelStartTime).toMillis();

        // Display the time taken for each stream
        System.out.printf("Sequential processing time: %d ms%n", sequentialDuration);
        System.out.printf("Parallel processing time: %d ms%n", parallelDuration);
    }

    private static void processSequentially(Supplier<LocalDate> dateSupplier) {
        // Perform sequential processing
        System.out.println("Sequential processing:");
        LocalDate currentDate = dateSupplier.get();
        System.out.println("Today is " + currentDate);
    }

    private static void processInParallel(Supplier<LocalDate> dateSupplier) {
        // Perform parallel processing (in this case, there's only one element)
        System.out.println("Parallel processing:");
        LocalDate currentDate = dateSupplier.get();
        System.out.println("Today is " + currentDate);
    }
}
