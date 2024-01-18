package movie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/******************************************************************************
 * This class demonstrates the use of functional programming to transform and
 * collect movie names in uppercase. The movie dataset is processed using Java
 * streams and lambda expressions.
 ******************************************************************************/

public class Movie7 {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie(1, "The Shining", "R", "Drama", 1980, "June 13, 1980 (United States)", 8.4, 927000.0,
                        "Stanley Kubrick", "Stephen King", "Jack Nicholson", "United Kingdom", 19000000.0, 46998772.0,
                        "Warner Bros.", 146.0),
                new Movie(2, "The Blue Lagoon", "R", "Adventure", 1980, "July 2, 1980 (United States)", 5.8, 65000.0,
                        "Randal Kleiser", "Henry De Vere Stacpoole", "Brooke Shields", "United States", 4500000.0,
                        58853106.0, "Columbia Pictures", 104.0),
                new Movie(3, "Star Wars Back", "PG", "Action", 1980,
                        "June 20, 1980 (United States)", 8.7, 1200000.0, "Irvin Kershner", "Leigh Brackett",
                        "Mark Hamill", "United States", 18000000.0, 538375067.0, "Lucasfilm", 124.0),
                new Movie(4, "Airplane!", "PG", "Comedy", 1980, "July 2, 1980 (United States)", 7.7, 221000.0,
                        "Jim Abrahams", "Jim Abrahams", "Robert Hays", "United States", 3500000.0, 83453539.0,
                        "Paramount Pictures", 88.0),
                new Movie(5, "Caddyshack", "R", "Comedy", 1980, "July 25, 1980 (United States)", 7.3, 108000.0,
                        "Harold Ramis", "Brian Doyle-Murray", "Chevy Chase", "United States", 6000000.0, 39846344.0,
                        "Orion Pictures", 98.0),
                new Movie(6, "Friday the 13th", "R", "Horror", 1980, "May 9, 1980 (United States)", 6.4, 123000.0,
                        "Sean S. Cunningham", "Victor Miller", "Betsy Palmer", "United States", 550000.0, 39754601.0,
                        "Paramount Pictures", 95.0),
                new Movie(7, "The Blues Brothers", "R", "Action", 1980, "June 20, 1980 (United States)", 7.9, 188000.0,
                        "John Landis", "Dan Aykroyd", "John Belushi", "United States", 27000000.0, 115229890.0,
                        "Universal Pictures", 133.0),
                new Movie(8, "Raging Bull", "R", "Biography", 1980, "December 19, 1980 (United States)", 8.2, 330000.0,
                        "Martin Scorsese", "Jake LaMotta", "Robert De Niro", "United States", 18000000.0, 23402427.0,
                        "Chartoff-Winkler Productions", 129.0),
                new Movie(9, "Superman II", "PG", "Action", 1980, "June 19, 1981 (United States)", 6.8, 101000.0,
                        "Richard Lester", "Jerry Siegel", "Gene Hackman", "United States", 54000000.0, 108185706.0,
                        "Dovemead Films", 127.0),
                new Movie(10, "The Long Riders", "R", "Biography", 1980, "May 16, 1980 (United States)", 7.0, 10000.0,
                        "Walter Hill", "Bill Bryden", "David Carradine", "United States", 10000000.0, 15795189.0,
                        "United Artists", 100.0));

        // Transform and collect movie names in uppercase using functional programming
        List<String> uppercasedNames = movies.stream()
                .map(Movie::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Print the uppercased names
        uppercasedNames.forEach(System.out::println);
    }
}
