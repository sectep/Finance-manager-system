package personalFinanceManager.src;

import java.util.Scanner;

// a class, which holds console-based interface.
public class ConsoleInterface {
    int option, money;
    String month, fMonth, sMonth;
    Scanner console = new Scanner(System.in);

    // method, which launches the application.
    public void launchApp() {
        displayInterface();

        // keep asking for option if user hasn't chose exit option.
        while (option != 5 && option != -1) {
            option = askOptions();

            if (option != -1 && option != 5)
                doOptions(option);
        }
    }

    // method, which displays the interface of the app.
    private void displayInterface() {
        System.out.println("1. Add transaction.");
        System.out.println("2. Show transactions.");
        System.out.println("3. Show transactions by period.");
        System.out.println("4. Show transactions by date.");
        System.out.println("5. Exit.");
    }

    // method, which asks to choose an option.
    private int askOptions() {
        System.out.print("Choose: ");

        // check, if next next input is an integer.
        if (console.hasNextInt()) {
            option = console.nextInt();
            console.nextLine();
            return option;
        }

        System.out.println("Invalid input type. An integer value is expected.");
        return -1;
    }

    // method, which processes the option, based on choice.
    private void doOptions(int what) {

        switch (what) {
            case 1:
                month = askDate();
                money = askMoney();
                System.out.println();
                TransactionWriter.writeData(month, money);
                break;
            case 2:
                System.out.println();
                TransactionReader.showData();
                break;
            case 3:
                askMonths();
                System.out.println();
                TransactionReader.showRange(fMonth, sMonth);
                break;
            case 4:
                month = askDate();
                System.out.println();
                TransactionReader.showFrom(month);
                break;
            case 5:
                System.out.println("Terminating the program.");
                break;
            default:
                System.out.println("Invalid input chose. An integer value is expected from 1 to 5.");
                break;
        }
    }

    // method, which asks for a month.
    private String askDate() {
        System.out.print("Please enter the date in DD.MM.YYYY format: ");
        return console.nextLine();

    }

    // method, which asks for a month.
    private int askMoney() {
        System.out.print("Please enter the total amount spent: ");
        if (console.hasNextInt()) {
            int money = console.nextInt();
            console.nextLine();
            return money;
        }

        return -1;
    }

    // method which asks for a period of time spending.
    private void askMonths() {
        fMonth = askFrirstDate();
        sMonth = askSecondDate();
        return;
    }

    // method, which asks for first information of time spending.
    private String askFrirstDate() {
        System.out.print("Please enter the first date in the format DD.MM.YYYY: ");
        return console.nextLine();
    }

    // method, which asks for second information of time spending.
    private String askSecondDate() {
        System.out.print("Please enter the second date in the format DD.MM.YYYY: ");
        return console.nextLine();
    }

}
