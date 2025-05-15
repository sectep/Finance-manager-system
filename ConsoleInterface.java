package personalFinanceManager.src;

import java.util.Scanner;

// a console-based interface.
public class ConsoleInterface {
    int option, month, money;
    Scanner console = new Scanner(System.in);

    // method, which launches the application.
    public void launchApp() {
        displayInterface();

        option = askOptions();
        doOptions(option);

    }

    // method, which displays the interface of the app.
    private void displayInterface() {
        System.out.println("1. Add transaction");
        System.out.println("2. Show the history of transactions");
        System.out.println("3. Show the spendings");
        System.out.println("4. Exit");
    }

    // method, which asks to choose an option.
    private int askOptions() {
        System.out.print("Choose: ");

        if (console.hasNextInt()) {
            return console.nextInt();
        }

        System.out.println("Write an integer value!");
        return -1;
    }

    // method, which processes the option, based on choice.
    private void doOptions(int what) {
        System.out.println();

        switch (what) {
            case 1:
                month = askMonth();
                money = askMoney();
                TransactionWriter.writeData(month, money);
                break;
            case 2:
                TransactionReader.readData();
                break;
            case 3:
                break;
            case 4:
                System.out.println("Terminating the program.");
                break;
            default:
                System.out.println("Invalid  input option.Please write an integer value (1-4)!");
                break;
        }
    }

    // method, which asks for a month.
    private int askMonth() {
        System.out.print("Write a date: ");
        if (console.hasNextInt()) {
            return console.nextInt();
        }

        return -1;
    }

    // method, which asks for a month.
    private int askMoney() {
        System.out.print("Write a total value spended: ");
        if (console.hasNextInt()) {
            return console.nextInt();
        }

        return -1;
    }

}
