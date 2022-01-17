import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Admin {
    private String movie;
    private String date;
    private String theaterName;
    private int price;

    public Admin(String movie, String date, String theaterName, int price) {

        this.movie = movie;
        this.date = date;
        this.theaterName = theaterName;
        this.price = price;

        try {
            PrintWriter printMovie = new PrintWriter(new FileOutputStream("movies.txt", true));
            printMovie.println(movie);
            printMovie.println(date);
            printMovie.println(theaterName);
            printMovie.println(price);
            // printMovie.println(food);
            printMovie.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
