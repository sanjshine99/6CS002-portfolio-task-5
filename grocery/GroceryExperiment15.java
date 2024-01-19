package grocery;

import java.util.function.Function;
import java.util.stream.IntStream;

/******************************************************************************
 * This program demonstrates functional programming by implementing a functional
 * interface. It calculates the reciprocal of integers from 1 to 10 and prints
 * the results.
 * 
 ******************************************************************************/

public class GroceryExperiment15 {
    public static void main(String[] args) {
        // Define a functional interface for reciprocal calculation
        Function<Integer, Double> reciprocal = new Function<Integer, Double>() {
            public Double apply(Integer n) {
                return 1.0 / n;
            }
        };

        // Calculate and print the reciprocal of 10
        System.out.println("Reciprocal of 10: " + reciprocal.apply(10));

        // Generate a stream of integers from 1 to 9
        IntStream denominators = IntStream.range(1, 10);

        // Calculate and print the reciprocals of integers from 1 to 9
        denominators.mapToDouble(n -> 1.0 / n)
                .forEach(x -> System.out.println("Reciprocal of " + (int) (1 / x) + ": " + x));
    }
}
