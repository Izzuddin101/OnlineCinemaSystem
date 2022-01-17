import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Payment extends CurrentUser {
    private String food = null;
    private boolean isStudent;
    private int numberOfTickets;
    // private String food;

    public void setFood(String food) {
        this.food = food;
    }

    public Payment(boolean isStudent, int numberOfTickets) {
        this.isStudent = isStudent;
        this.numberOfTickets = numberOfTickets;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void MakePayment() {
        System.out.println("");
        System.out.println("Golden Screen Cinema | Payment Page");
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.println("- Name: " + CurrentUser.getName() + " | ID: " + CurrentUser.getID());
        System.out.println("- User Name: " + CurrentUser.getUserName());
        System.out.println("- Movie Name: " + Client.getMovieName());
        System.out.println("- Movie Date: " + Client.getMovieDate());
        System.out.println("- Theater Name: " + Client.getTheaterName());
        System.out.println("-------------------------------------");
        System.out.println();
        calculateTheBill();


    }

    public void calculateTheBill() {
        double finalTotal;
        if (isStudent) {
            finalTotal = (Client.getMoviePrice() * numberOfTickets) * 0.70;
            System.out.println("- Movie Price: " + Client.getMoviePrice() + " | "
                    + "Number of tickets: " + numberOfTickets + " \n- sub total = " + (Client.getMoviePrice() * numberOfTickets));
            if (food != null) {
                System.out.println("- Food And Beverage: " + food + " | " +
                        "Price: 30");
                finalTotal += 30;
            }

            System.out.println("Student Discount applied, Final total = " + finalTotal);

        } else {
            finalTotal = (Client.getMoviePrice() * numberOfTickets);
            System.out.println("- Movie Price: " + Client.getMoviePrice() + " | "
                    + "Number of tickets: " + numberOfTickets + " \n- sub total = " + (Client.getMoviePrice() * numberOfTickets));
            if (food != null) {
                System.out.println("- Food And Beverage: " + food + " | " +
                        "Price: 30");
                finalTotal += 30;
            }
            System.out.println("Couldn't found any Discount, Final total = " + finalTotal);
        }

        printTheBooking(finalTotal);

    }

    public void printTheBooking(double finalTotal) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(getUserName() + "Booking.txt", true));
            writer.println(Client.getMovieName());
            writer.println(Client.getMovieDate());
            writer.println(Client.getTheaterName());
            writer.println(food);
            writer.println(finalTotal);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
