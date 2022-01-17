import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Theater {
    private String theaterName;
    private int theaterRows;
    private int theaterColumns;
    //  Arrays.deepToString(my2DArray).split(" ]");

    // System.out.println(Arrays.deepToString(my2DArray));

    public Theater(String theaterName, int theaterRows, int theaterColumns) {
        this.theaterName = theaterName;
        this.theaterRows = theaterRows;
        this.theaterColumns = theaterColumns;

        try {
            PrintWriter printTheatersNames = new PrintWriter(new FileOutputStream("theaters.txt", true));
            printTheatersNames.println(theaterName);
            printTheatersNames.close();

            PrintWriter printTheater = new PrintWriter(new FileOutputStream(theaterName + ".txt"));
            // printTheater.println(theaterName);
            int rowsCounter = 1;
            int[][] my2DArray = new int[theaterRows][theaterColumns];
            printTheater.print("  |");
            for (int i = 0; i < theaterColumns; i++) {
                printTheater.print(" " + (i + 1));
            }
            System.out.print("\n");
            for (int[] row : my2DArray) {
                printTheater.print("\n" + rowsCounter + " | ");
                rowsCounter++;
                // printTheater.println();
                for (int y : row) {
                    printTheater.print(y + " ");
                }
            }
            printTheater.close();

            System.out.println();
            System.out.println("Your theater has been added successfully");
            System.out.println("- Enter  1 to show theaters");
            System.out.println("- Enter  2 to go to Admin Panel");
            System.out.println("- Enter  0 to go to the Main Panel");
            System.out.println("- Enter -1 to go to End the program");
            System.out.println("--------------------");
            System.out.println("");
            System.out.print("Select Option: ");
            Scanner theaterScan = new Scanner(System.in);
            int theaterOption = theaterScan.nextInt();
            //   printMovie.close();
            switch (theaterOption) {
                case 1 -> {
                    Main.showTheaters();
                }
                case 2 -> {
                    Main.adminoptions();
                }
                case 0 -> {
                    String[] args = {};
                    Main.main(args);
                }
                case -1 -> {
                    System.exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void printTheater(int rows, int columns) {
        //   int[][] my2DArray = new int[rows][columns];

        //int[][] my2DArray = new int[10][20];
        //  Arrays.deepToString(my2DArray).split(" ]");
//        for (int[] row : my2DArray){
//            for (int y : row){
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }
        // System.out.println(Arrays.deepToString(my2DArray));

    }
}
