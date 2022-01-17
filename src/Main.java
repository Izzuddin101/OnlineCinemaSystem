import java.io.*;
import java.util.Scanner;

public class Main {
    private static Object OutputStreamWriter;

    //    CurrentUser currentUser = new CurrentUser();
    // String mbbb = "ggggg";
    public static void main(String[] args) {
        String registerSaveFile = null;
        System.out.println("");
        System.out.println("Golden Screen Cinema | Main Page");
        System.out.println("--------------------------------");
        System.out.println("");

        File loginAdmin = new File("registerAdmin.txt");
        File loginCustomer = new File("registerCustomer.txt");
        if (loginAdmin.exists() || loginCustomer.exists()) {
            System.out.println("- Press  1 to Log in");
        }
        System.out.println("- Press  2 to Sign up");
        System.out.println("- Press -1 to Exit");
        System.out.println("--------------------");
        System.out.println("");
        System.out.print("Select Option: ");
        Scanner welcomeScanner = new Scanner(System.in);
        int welcomeScannerInput = welcomeScanner.nextInt();
        switch (welcomeScannerInput) {
            case -1 -> {
                System.exit(0);
            }
            case 1 -> {
                System.out.println("Log in is selected");
                login();
            }
            case 2 -> {
                System.out.println("Sign up is selected");
                register();
            }
            default -> System.out.println("Invalid, please enter a correct option");
        }
    }

    public static void registerAdmin(String fileName, String name, String email, String password) {
        try {

            PrintWriter registerWriter = new PrintWriter(new FileOutputStream(fileName, true));
            registerWriter.println(name);
            registerWriter.println(email);
            registerWriter.println(password);
            int IDCounter = 0;


            boolean counterFile = new File("counter.txt").exists();
            if (counterFile) {
                Scanner counterScanner = new Scanner(new FileInputStream("counter.txt"));
                int getCountScanner = counterScanner.nextInt();
                PrintWriter createCounter = new PrintWriter(new FileOutputStream("counter.txt"));
                registerWriter.println(getCountScanner);
                createCounter.println(getCountScanner + 1);

                //  IDCounter = 0;
                counterScanner.close();
                createCounter.close();


//                if (counterScanner.isEmpty()){
//                    searchLogin = loginSearchinput.nextLine();
//                }

            } else {
                PrintWriter createCounter = new PrintWriter(new FileOutputStream("counter.txt"));
                createCounter.println(0);
                registerWriter.println(IDCounter);
                createCounter.close();
            }
            IDCounter += 1;
            registerWriter.close();
            System.out.println("");
            System.out.println("Golden Screen Cinema | register Page");
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Your account has created successfully");
            System.out.println("Enter  1 to log in");
            System.out.println("Enter  0 to go to the main page");
            System.out.println("Enter -1 to exit");
            System.out.println();
            System.out.print("Selected option: ");
            Scanner login = new Scanner(System.in);
            int loginScanner = login.nextInt();
            switch (loginScanner) {
                case 0 -> {
                    String[] args = {};
                    Main.main(args);
                }

                case -1 -> {
                    System.exit(0);
                }
            }
            if (loginScanner == 1) {
                login();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void login() {
        System.out.println("");
        System.out.println("Golden Screen Cinema | Log in Page");
        System.out.println("----------------------------------");
        Scanner welcomeScanner = new Scanner(System.in);
        System.out.println("");
        System.out.print("Please Enter your email: ");
        String userEmailScanner = welcomeScanner.next();
        System.out.print("Please Enter your password: ");
        String usernamePassword = welcomeScanner.next();
        System.out.print("Are you an Admin? (y/n): ");
        String AdminScanner = welcomeScanner.next();
        String finleInputRegister = null;
        if (AdminScanner.equals("y")) {
            CurrentUser.setIsAdmin(true);
            finleInputRegister = "registerAdmin.txt";
            // System.out.print("Enter your ID number: ");
            //  int ID = welcomeScanner.nextInt();
        } else if (AdminScanner.equals("n")) {
            CurrentUser.setIsAdmin(false);
            finleInputRegister = "registerCustomer.txt";
        }

        try {
            assert finleInputRegister != null;
            Scanner loginSearchinput = new Scanner(new FileInputStream(finleInputRegister));
//            String searchLogin = loginSearchinput.nextLine();
            String searchLogin = loginSearchinput.nextLine();
            while (loginSearchinput.hasNextLine()) {
                if (!loginSearchinput.hasNextLine()) {
                    break;
                    //   loginSearchinput.close();
                }

                //  loginSearchinput.nextLine();

                if (searchLogin.isEmpty()) {
                    searchLogin = loginSearchinput.nextLine();
                }
                // searchLogin = loginSearchinput.nextLine();
                if (userEmailScanner.equals(searchLogin)) {

                    CurrentUser.setUserName(userEmailScanner);
                    searchLogin = loginSearchinput.nextLine();
                    if (usernamePassword.equals(searchLogin)) {
                        // CurrentUser currentUser = new CurrentUser();
                        CurrentUser.setPassword(usernamePassword);
                        //  loginSearchinput.nextLine();
                        CurrentUser.setName(loginSearchinput.nextLine());
                        CurrentUser.setID(loginSearchinput.nextLine());
                        //  loginSearchinput.close();
                        //   System.out.println(currentUser.getName() + " " + currentUser.getUserName() + " " + currentUser.getPassword() + " " + currentUser.getID());
                        System.out.println("");
                        System.out.println("Golden Screen Cinema | Log in Page");
                        System.out.println("----------------------------------");
                        System.out.println("");
                        System.out.println("Welcome, You have logged in successfully");
                        // boolean booleanTrue = true;
                        if (Boolean.TRUE.equals(CurrentUser.getIsAdmin())) {
                            System.out.println("- Enter  1 to go to admin panel");
                        } else if (Boolean.FALSE.equals(CurrentUser.getIsAdmin())) {
                            System.out.println("- Enter  1 to go to movie panel");
                            File bookingFile = new File(userEmailScanner + "Booking.txt");
                            if (bookingFile.exists()) {
                                System.out.println("- Enter  2 to see your booking");
                            }

                        }

                        System.out.println("- Enter  0 to go to the main page");
                        System.out.println("- Enter -1 to exit");
                        System.out.println("--------------------");
                        System.out.println("");
                        System.out.print("Select Option: ");
                        Scanner adminPanlScan = new Scanner(System.in);
                        int myAdminPanlScan = adminPanlScan.nextInt();
                        switch (myAdminPanlScan) {
                            case 0 -> {
                                String[] args = {};
                                Main.main(args);
                            }
                            case -1 -> {
                                System.exit(0);
                            }
                            case 2 -> {
                                showBooking(userEmailScanner);
                            }
                        }
                        if (myAdminPanlScan == 1) {
                            if (Boolean.TRUE.equals(CurrentUser.getIsAdmin())) {
                                adminoptions();
                            } else if (Boolean.FALSE.equals(CurrentUser.getIsAdmin())) {
                                bookMovie();
                            }

                            break;
                        }


                    }
//                    else {
//                        System.out.println("We have found your email, yet the password is incorrect. ");
//                        System.out.print("Please Enter your password: ");
//                        usernamePassword = welcomeScanner.next();
//                    }
                } else {
                    searchLogin = loginSearchinput.nextLine();
                    searchLogin = loginSearchinput.nextLine();
                    //   searchLogin = loginSearchinput.nextLine();
                    // searchLogin = loginSearchinput.nextLine();
                    //    searchLogin = loginSearchinput.nextLine();
                    //  loginSearchinput.nextLine();
                    //  System.out.println("can't be fined");
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void register() {
        Scanner welcomeScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Golden Screen Cinema | Sign Up Page");
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("Please enter your first name: ");
        String usernameScanner = welcomeScanner.next();
        System.out.print("Please Enter your email address: ");
        String userEmailScanner = welcomeScanner.next();
        System.out.print("Please Enter your password: ");
        String usernamePassword = welcomeScanner.next();
        System.out.print("Will this be Admin account? (y/n): ");
        String AdminScanner = welcomeScanner.next();
        String registerSaveFile = null;
        if (AdminScanner.equals("y")) {

            // System.out.print("please Enter your ID number: ");
            //  int ID = welcomeScanner.nextInt();
            registerSaveFile = "registerAdmin.txt";
        } else if (AdminScanner.equals("n")) {
            registerSaveFile = "registerCustomer.txt";
        }
        registerAdmin(registerSaveFile, userEmailScanner, usernamePassword, usernameScanner);
    }

    public static void adminoptions() {
//        System.out.println("------------");
        System.out.println("Golden Screen Cinema | Admin Options Page");
        System.out.println("-----------------------------------------");
        System.out.println("");
        // System.out.println("Here you can add a movie, determine its number of seats, its price, and finally determine the type of food that will be available");
        System.out.println("- Enter  1 to add a theater");
        System.out.println("- Enter  2 to add a show");
        System.out.println("- Enter  3 to remove a show");
        File moviesFile = new File("movies.txt");
        if (moviesFile.exists()) {
            System.out.println("- Enter  4 to display shows");
        }
        File theatersFile = new File("theaters.txt");
        if (theatersFile.exists()) {
            System.out.println("- Enter  5 to display theaters");
        }
        System.out.println("- Enter  0 to go to the Main Page");
        System.out.println("- Enter -1 to exit");
        System.out.println("");
        System.out.print("- Option chosen: ");
        Scanner enterScan = new Scanner(System.in);
        int enterScanInput = enterScan.nextInt();

        switch (enterScanInput) {
            case 1 -> {
                addTheater();
            }
            case 4 -> {
                showMovies();
            }
            case 3 -> {
                removeMovies();
            }
            case 5 -> {
                showTheaters();
            }
            case 0 -> {
                String[] args = {};
                Main.main(args);
            }
            case -1 -> {
                System.exit(0);
            }

        }

//        switch (enterScanInput) {
//            case 2: showMovies();
//            break;
//        }
        if (enterScanInput == 2) {
            Scanner enterMovie = new Scanner(System.in);
            Scanner enterMovie2 = new Scanner(System.in);
            System.out.println("");
            System.out.println("Golden Screen Cinema | Add movie Page");
            System.out.println("-------------------------------------");
            System.out.println("");
            System.out.print("Enter the name of the movie: ");
            String enterScanName = enterMovie.nextLine();
            System.out.print("Enter the date of the show: ");
            String enterScanDate = enterMovie.nextLine();
            showTheaters();
            System.out.println();
            System.out.println("----------------------------");
            System.out.print("Enter the number of theater: ");
            int enterScanSeats = enterMovie.nextInt();
            System.out.print("Enter the price of the movie: ");
            int enterScanPrice = enterMovie.nextInt();
            //  System.out.print("Enter the food option: ");
            // String enterScanOption = enterMovie2.nextLine();
            //  enterMovie.close(); enterMovie2.close();
            String theaterName = null;
            try {
                int showTheatersScannerCounter = 1;
                Scanner showTheatersScanner = new Scanner(new FileInputStream("theaters.txt"));
                String showTheaters = showTheatersScanner.nextLine();
                while (showTheatersScanner.hasNextLine()) {

                    if (enterScanSeats == showTheatersScannerCounter) {
                        theaterName = showTheatersScanner.nextLine();
                        break;
                    }
                    showTheatersScannerCounter++;
                    showTheaters = showTheatersScanner.nextLine();

                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
            Admin addMovie = new Admin(enterScanName, enterScanDate, theaterName, enterScanPrice);


        }
    }

    public static void showMovies() {

        int showCounter = 1;
        try {
            // PrintWriter showMovies = new PrintWriter(new FileOutputStream("movies.txt"));
            Scanner showMovies = new Scanner(new FileInputStream("movies.txt"));
            String showMoviesIN = showMovies.nextLine();
            System.out.println("Golden Screen Cinema | Movies Page");
            System.out.println("----------------------------------");
            //  System.out.println("");
//            showMovies.has
            int linesCounter = 1;
            while (showMovies.hasNextLine()) {
                if (showMoviesIN.isEmpty()) {
                    showMoviesIN = showMovies.nextLine();
                }
                showMoviesIN = showMovies.nextLine();
                linesCounter++;
            }
            showMovies.reset();

            //   System.out.println(linesCounter +"COUNTER");
            Scanner showMovies2 = new Scanner(new FileInputStream("movies.txt"));
            String showMoviesIN2 = showMovies2.nextLine();

            while (linesCounter / 4 >= 1) {
                if (showMoviesIN2.isEmpty()) {
                    showMoviesIN2 = showMovies2.nextLine();
                }

                System.out.println("");
                System.out.println("- Show Number: " + showCounter);
                System.out.println("- Show Name: " + showMoviesIN2);
                showMoviesIN2 = showMovies2.nextLine();
                linesCounter -= 1;
                System.out.println("- Show Date: " + showMoviesIN2);
                showMoviesIN2 = showMovies2.nextLine();
                linesCounter -= 1;
                showMoviesIN2 = showMovies2.nextLine();
                linesCounter -= 1;
                if (linesCounter / 4 >= 1)
                    showMoviesIN2 = showMovies2.nextLine();
                linesCounter -= 1;

                showCounter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }


    public static void removeMovies() {
        showMovies();
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.print("- Choose a number to delete it: ");
        Scanner newScann = new Scanner(System.in);
        int movieRemove = newScann.nextInt();
        newScann.close();
        try {
            Scanner removeScanner = new Scanner(new FileInputStream("movies.txt"));
            PrintWriter removePrintWriter = new PrintWriter(new FileOutputStream("moviesT.txt"));
            String removeScannerNext = removeScanner.nextLine();
            // String printWriterNext = removePrintWriter.
            //   removeScanner.nextLine();
            int removeCounter = 1;
            while (removeScanner.hasNextLine()) {
                if (removeCounter == movieRemove) {
                    removeScannerNext = removeScanner.nextLine();
                    removeScannerNext = removeScanner.nextLine();
                    removeScannerNext = removeScanner.nextLine();
                    removeScannerNext = removeScanner.nextLine();

                }
                removeCounter++;
                removePrintWriter.println(removeScanner.nextLine());
                System.out.println();
            }
            removeScanner.close();
            removePrintWriter.close();

            File inputFile = new File("movies.txt");
            File tempFile = new File("moviesT.txt");
            //  inputFile.renameTo("mmmmmmmm.txt");
            //     inputFile.delete();
            //    tempFile.renameTo("movies.txt");
            removeScanner.close();
            removePrintWriter.close();
            System.gc();
            // inputFile.deleteOnExit();

            inputFile.delete();
            tempFile.renameTo(inputFile);
            // inputFile.delete();
            // tempFile.delete();


            // removePrintWriter.de
            // File f = new File(".txt");

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


//        } catch (FileNotFoundException e){
//            System.out.println(e);
//        }


    }

    public static void addTheater() {
        Scanner enterMovie = new Scanner(System.in);
        Scanner enterMovie2 = new Scanner(System.in);
        System.out.println("Golden Screen Cinema | Add Theaters Page");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.print("- Enter the name of the theater: ");
        String theaterName = enterMovie.nextLine();
        System.out.print("- Enter the number of rows that the theater has: ");
        int theaterRows = enterMovie.nextInt();
        System.out.print("- Enter the number of columns that the theater has: ");
        int theaterColumns = enterMovie.nextInt();
        Theater addnewTheater = new Theater(theaterName, theaterRows, theaterColumns);

    }

    public static void bookMovie() {
        showMovies();
        System.out.println();
        System.out.print("Select the booking by number: ");
        Scanner selectMovie = new Scanner(System.in);
        int selectmovieBynumber = selectMovie.nextInt();

        String selectSeatByRowIn = null;
        int selectSeatByColumnIn = 0;
        int selectSeatByColumnInEnd = 0;

        try {
            Scanner selectMovieScanner = new Scanner(new FileInputStream("movies.txt"));
            String selectMovieScannerString = selectMovieScanner.nextLine();
            if (selectmovieBynumber == 1) {
                System.out.println(selectMovieScannerString);
            } else {

                for (int j = 1; j < selectmovieBynumber; j++) {
                    selectMovieScannerString = selectMovieScanner.nextLine();
                    selectMovieScannerString = selectMovieScanner.nextLine();
                    selectMovieScannerString = selectMovieScanner.nextLine();
                    selectMovieScannerString = selectMovieScanner.nextLine();
                }
            }

            String clientMovieName = selectMovieScannerString;
            selectMovieScannerString = selectMovieScanner.nextLine();
            String clientMovieDate = selectMovieScannerString;
            selectMovieScannerString = selectMovieScanner.nextLine();
            String clientMovieTheater = selectMovieScannerString;
            selectMovieScannerString = selectMovieScanner.nextLine();
            String clientMoviePrice = selectMovieScannerString;

            Client client = new Client();
            client.setMovieName(clientMovieName);
            client.setMovieDate(clientMovieDate);
            client.setTheaterName(clientMovieTheater);
            client.setMoviePrice(clientMoviePrice);

            //    System.out.println(Client.getMovieName() + " " + client.getMovieDate() + " " + client.getTheaterName() + " " + client.getMoviePrice());

            System.out.println("");
            System.out.println("Golden Screen Cinema | Booking Page");
            System.out.println("-----------------------------------");
            System.out.println("");
            try {
                Scanner selectSeat = new Scanner(new FileInputStream(clientMovieTheater + ".txt"));
                String selectSeatOut = selectSeat.nextLine();
                //  selectSeatOut = selectSeat.nextLine();
                while (selectSeat.hasNextLine()) {
                    System.out.println(selectSeatOut);
                    selectSeatOut = selectSeat.nextLine();
                }
                selectSeat.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
            System.out.println();
            System.out.print("- Enter the number of tickets: ");
            Scanner numberOfTickets = new Scanner(System.in);
            int enterThenumberofTickets = numberOfTickets.nextInt();


            if (enterThenumberofTickets == 1) {
                //  System.out.println("- Select a seat");
                System.out.print("- Enter row number: ");
                Scanner selectSeatByRow = new Scanner(System.in);
                selectSeatByRowIn = selectSeatByRow.nextLine();
                //  selectSeatByRow.close();

                System.out.print("- Enter column number: ");
                Scanner selectSeatByColumn = new Scanner(System.in);
                selectSeatByColumnIn = selectSeatByRow.nextInt();
                // selectSeatByColumn.close();

            } else if (enterThenumberofTickets > 1) {
                // System.out.println("- Select seats");
                System.out.print("- Enter row number: ");
                Scanner selectSeatByRow = new Scanner(System.in);
                selectSeatByRowIn = selectSeatByRow.nextLine();
                // selectSeatByRow.close();

                System.out.print("- Enter column Start: ");
                Scanner selectSeatByColumn = new Scanner(System.in);
                selectSeatByColumnIn = selectSeatByRow.nextInt();
                // selectSeatByColumn.close();

                System.out.print("- Enter column End: ");
                Scanner selectSeatByColumnEnd = new Scanner(System.in);
                selectSeatByColumnInEnd = selectSeatByColumnEnd.nextInt();
                //   selectSeatByColumnEnd.close();
            }
            boolean isStudent = false;
            System.out.print("Are you Student? (y/n): ");
            Scanner isStudentScanner = new Scanner(System.in);
            String isStudentScannerIN = isStudentScanner.nextLine();
            isStudent = (isStudentScannerIN.equals("y"));


//            System.out.println("- Select a seat");
//            System.out.println("- Enter row number: ");
//            Scanner selectSeatByRow = new Scanner(System.in);
//            String selectSeatByRowIn = selectSeatByRow.nextLine();
//
//            System.out.println("- Enter column number: ");
//            Scanner selectSeatByColumn = new Scanner(System.in);
//            int selectSeatByColumnIn = selectSeatByRow.nextInt();


            Scanner selectSeat = new Scanner(new FileInputStream(clientMovieTheater + ".txt"));
            String selectSeatOut = selectSeat.nextLine();
            int selectSeatCounter = 0;
            while (selectSeat.hasNextLine()) {
                assert selectSeatByRowIn != null;
                if (Integer.parseInt(selectSeatByRowIn) == selectSeatCounter) {
                    String changedLine = selectSeatOut;
                    int beginIndex = 0;
                    int endIndex = 0;
                    if (enterThenumberofTickets == 1) {
                        beginIndex = (selectSeatByColumnIn * 2) + 2;
                    } else if (enterThenumberofTickets > 1) {
                        beginIndex = (selectSeatByColumnIn * 2) + 2;
                        endIndex = (selectSeatByColumnInEnd * 2) + 2;
                    }

                    //  changedLine = changedLine.substring(beginIndex,beginIndex+1);
                    StringBuilder removedChar = new StringBuilder(changedLine);

                    if (enterThenumberofTickets > 1) {
                        int multiSeatsCounter = 0;
                        for (int i = 0; i <= selectSeatByColumnInEnd - selectSeatByColumnIn; i++) {

                            removedChar.setCharAt((beginIndex + multiSeatsCounter), '1');
                            multiSeatsCounter += 2;
                        }
                        if (selectSeatByColumnIn != 1) {
                            removedChar.setCharAt(beginIndex - 2, 'X');
                        }
                        if (!(endIndex + 2 >= removedChar.length())) {
                            removedChar.setCharAt(endIndex + 2, 'X');
                        }

                        //  removedChar.setCharAt(beginIndex - 2, 'X');
                        // removedChar.setCharAt(endIndex + 2, 'X');

                    } else if (enterThenumberofTickets == 1) {
                        removedChar.setCharAt(beginIndex, '1');
                        if (selectSeatByColumnIn != 1) {
                            removedChar.setCharAt(beginIndex - 2, 'X');
                        }
                        if (!(beginIndex + 2 >= removedChar.length())) {
                            removedChar.setCharAt(beginIndex + 2, 'X');
                        }

                    }

                    System.out.println(removedChar);
                    selectSeatOut = selectSeat.nextLine();
                    selectSeatCounter++;
                } else {
                    System.out.println(selectSeatOut);
                    selectSeatCounter++;
                    selectSeatOut = selectSeat.nextLine();
                }
            }

            System.out.println("");
            System.out.println("Golden Screen Cinema | Booking Page");
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("- Your booking has been arranged successfully");
            //   System.out.println();
            // System.out.println("-------------------------------");
            System.out.println("- Enter 1 to add Food/Beverages");
            System.out.println("- Enter 2 to go to the Payment Page");
            System.out.println();
            System.out.print("Select Option: ");
            Scanner foodScanner = new Scanner(System.in);
            int foodScannerIn = foodScanner.nextInt();
            //   foodScanner.close();
            switch (foodScannerIn) {
                case 1 -> {
                    addFood(isStudent, enterThenumberofTickets);
                }
                case 2 -> {
                    Payment myPayment = new Payment(isStudent, enterThenumberofTickets);
                    myPayment.MakePayment();
                }
            }

//            System.out.println("- Press 2 to Sign up");
//            System.out.println("- Press -1 to Exit");
//            System.out.println("--------------------");
//            System.out.println("");

//            for (int i=1; i<selectmovieBynumber; i++){
//                selectmovieBynumber = selectMovie.nextInt();
//                //selectMovieScannerString = selectMovieScanner.nextLine();
//            }
            // System.out.println(selectMovieScannerString);
//            if (selectmovieBynumber == 0) {
//
//            }

//            int removeCounter = 1;
//            while (removeScanner.hasNextLine()){
//                if (removeCounter == movieRemove){
//                    removeScannerNext = removeScanner.nextLine();
//                    removeScannerNext = removeScanner.nextLine();
//                    removeScannerNext = removeScanner.nextLine();
//                    removeScannerNext = removeScanner.nextLine();
//
//                }
//                removeCounter++;
//                removePrintWriter.println(removeScanner.nextLine());
//                System.out.println();
//            }
//            removeScanner.close(); removePrintWriter.close();
//
//            File inputFile = new File("movies.txt");
//            File tempFile = new File("moviesT.txt");
//
//
//
//
//
//            // removePrintWriter.de
//            // File f = new File(".txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }

    public static void showTheaters() {
        try {
            Scanner showTheatersScanner = new Scanner(new FileInputStream("theaters.txt"));
            String showTheaters;
            int theaternumber = 1;
            while (showTheatersScanner.hasNextLine()) {
                showTheaters = showTheatersScanner.nextLine();
                System.out.println("- " + theaternumber + ": " + showTheaters);
                theaternumber++;
                // System.out.println("- Theater name: " + showTheaters);
                //  showTheaters = showTheatersScanner.nextLine();
//                if (!showTheatersScanner.hasNextLine()){
//                    System.out.println("- " + theaternumber + ": " + showTheaters);
//                  //  System.out.println("- Theater number: " + theaternumber);
//                    theaternumber++;
//                  //  System.out.println("- Theater name: " + showTheaters);
//                }
                // System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
//        System.out.println("Golden Screen Cinema | Admin Options Page");
//        System.out.println("-----------------------------------------");
//        System.out.println("");

        // System.out.println("Here you can add a movie, determine its number of seats, its price, and finally determine the type of food that will be available");
        System.out.println("------------------------------");
        System.out.println("- Enter  1 to go to Admin Options");
        System.out.println("- Enter  0 to add a the Main Page");
        System.out.println("- Enter -1 to End the Program");
        System.out.print("- Selected option: ");
        Scanner showTheaterNav = new Scanner(System.in);
        int showTheaterNavIN = showTheaterNav.nextInt();

        switch (showTheaterNavIN) {
            case 1 -> {
                adminoptions();
            }
            case 0 -> {
                String[] args = {};
                Main.main(args);
            }
            case -1 -> {
                System.exit(0);
            }
        }

    }

    public static void addFood(boolean isStudent, int enterThenumberofTickets) {
        //    Scanner needFoodScanner = new Scanner(System.in);
        Scanner needFoodScan = new Scanner(System.in);
        System.out.print("- please write what you need with the movie: ");
        //  String needFoodScannerIn = needFoodScanner.nextLine();
        String need = needFoodScan.nextLine();
        System.out.println("Done, your order has been recorded");
        Payment myPayment = new Payment(isStudent, enterThenumberofTickets);
        myPayment.setFood(need);
        myPayment.MakePayment();


    }

    public static void showBooking(String userName) {
        try {
            Scanner showBookingScan = new Scanner(new FileInputStream(userName + "Booking.txt"));
            String showNextBooking = showBookingScan.nextLine();
            int bookingCounter = 1;
            System.out.println("Golden Screen Cinema | booking Page");
            System.out.println("----------------------------------");
            System.out.println("");
            while (showBookingScan.hasNextLine()) {
                System.out.println("- Booking number: " + bookingCounter);
                bookingCounter++;
                System.out.println("- Movie Name: " + showNextBooking);
                showNextBooking = showBookingScan.nextLine();
                System.out.println("- Movie Date: " + showNextBooking);
                showNextBooking = showBookingScan.nextLine();
                System.out.println("- THeater Name: " + showNextBooking);
                showNextBooking = showBookingScan.nextLine();
                System.out.println("- Food and Beverage: " + showNextBooking);
                showNextBooking = showBookingScan.nextLine();
                System.out.println("- The Final Price: " + showNextBooking);
                if (showBookingScan.hasNextLine()) {
                    System.out.println();
                    showNextBooking = showBookingScan.nextLine();
                }
            }
            showBookingScan.close();
//                if (showBookingScan.hasNextLine()){
//                    showNextBooking = showBookingScan.nextLine();
//                }
            System.out.println("");
            System.out.println("----------------------------------");

            System.out.println("- Enter  1 to remove Booking");
            System.out.println("- Enter  0 to go to the Main Page");
            System.out.println("- Enter -1 to End the Program");
            System.out.println();
            System.out.print("- Selected Option: ");

            Scanner showBookingScanner = new Scanner(System.in);
            int showBookingOptions = showBookingScanner.nextInt();

            switch (showBookingOptions) {
                case 1 -> {
                    removeBooking(showBookingOptions, userName);
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

    public static void removeBooking(int showBookingOptions, String userName) {
        System.out.println("Golden Screen Cinema | remove booking Page");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.print("Enter the number of the movie: ");
        Scanner toRemoveScan = new Scanner(System.in);
        int toremoveScanIN = toRemoveScan.nextInt();

        try {
            Scanner removeBookingScanner = new Scanner(new FileInputStream(userName + "Booking.txt"));
            String removebookingString = null;

            PrintWriter addBookin = new PrintWriter(new FileOutputStream(userName + "BookingBeta.txt"));
            int removingFormula = (toremoveScanIN * 5) - 5;
            int removeCounter = 0;
            while (removeBookingScanner.hasNextLine()) {
//                if (removeBookingScanner.hasNextLine()){
//                    addBookin.println(removebookingString);
//                    removebookingString = removeBookingScanner.nextLine();
//                    removeCounter++;
//                }
                if (removeCounter != removingFormula && removeBookingScanner.hasNextLine()) {
                    removebookingString = removeBookingScanner.nextLine();
                    addBookin.println(removebookingString);
                    removeCounter++;
                } else if (removeCounter == removingFormula) {
                    removebookingString = removeBookingScanner.nextLine();
                    removebookingString = removeBookingScanner.nextLine();
                    removebookingString = removeBookingScanner.nextLine();
                    removebookingString = removeBookingScanner.nextLine();
                    removebookingString = removeBookingScanner.nextLine();
                    removeCounter++;
                }


            }
            if (!(removeBookingScanner.hasNextLine())) {
                addBookin.close();
            }

            File bookingFile = new File(userName + "Booking.txt");
            File bookingBetaFile = new File(userName + "BookingBeta.txt");
            removeBookingScanner.close();
            addBookin.close();
            toRemoveScan.close();

            System.gc();
            //     System.gc();
            bookingFile.delete();
            //    bookingFile.deleteOnExit();
            // bookingFile.renameTo(new File("aya.txt"));
            bookingBetaFile.renameTo(bookingFile);
            //  bookingBetaFile.delete();

            System.out.println("");
            System.out.println("Done, your booking has been removed!");
            System.out.println("-----------------------------------");
            System.out.println("- Enter  1 to show Booking");
            System.out.println("- Enter  0 to go to the Main Page");
            System.out.println("- Enter -1 to End the Program");
            System.out.println();
            System.out.print("- Selected Option: ");
            Scanner afterRemovingBookingScan = new Scanner(System.in);
            int afterRemovingChoice = afterRemovingBookingScan.nextInt();

            switch (afterRemovingChoice) {
                case 1 -> {
                    showBooking(userName);
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
//            if (showBookingOptions == 1){
//
//            }
    }


}
