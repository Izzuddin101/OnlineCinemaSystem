public class Client {
    private static String movieName;
    private static String movieDate;
    private static String theaterName;
    private static int moviePrice;

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setMoviePrice(String moviePrice) {
        this.moviePrice = Integer.parseInt(moviePrice);
    }

    public static String getMovieName() {
        return movieName;
    }

    public static String getMovieDate() {
        return movieDate;
    }

    public static String getTheaterName() {
        return theaterName;
    }

    public static int getMoviePrice() {
        return moviePrice;
    }
}
