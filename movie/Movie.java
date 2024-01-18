package movie;

/******************************************************************************
 * This class represents details of a movie, including various attributes
 * such as name, rating, genre, year, etc. The class implements the Comparable
 * interface, allowing instances to be compared based on their names.
 ******************************************************************************/

public class Movie implements Comparable<Movie> {
    private int id;
    private String name;
    private String rating;
    private String genre;
    private int year;
    private String released;
    private double score;
    private double votes;
    private String director;
    private String writer;
    private String star;
    private String country;
    private double budget;
    private double gross;
    private String company;
    private double runtime;

    public Movie(int id, String name, String rating, String genre, int year, String released, double score,
            double votes, String director, String writer, String star, String country, double budget, double gross,
            String company, double runtime) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.released = released;
        this.score = score;
        this.votes = votes;
        this.director = director;
        this.writer = writer;
        this.star = star;
        this.country = country;
        this.budget = budget;
        this.gross = gross;
        this.company = company;
        this.runtime = runtime;
    }

    public String toString() {
        return String.format("%-30s%-20s%15.2f%15.2f", name, genre, budget, gross);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public int compareTo(Movie m) {
        return this.name.compareTo(m.name);
    }
}
