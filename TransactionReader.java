package personalFinanceManager.src;

import java.io.*;
import java.util.ArrayList;

// a class, which manages the input stream.
class TransactionReader {
    static int index;
    static String data, date, money;
    static String lineArray;
    static ArrayList<String> lists = new ArrayList<>();
    static ArrayList<String> rangeLists = new ArrayList<>();

    // method, which reads the data from file to array.
    public static void readToArray() {
        lists.clear(); // clear the array from a previous session.

        try (BufferedReader in = new BufferedReader(
                new FileReader("personalFinanceManager/data/transactions.txt"))) {

            while ((data = in.readLine()) != null) {
                lists.add(data);
            }
        } catch (IOException exc) {
            System.out.println("Unexpected behavour has happaned in readData method: " + exc);
        }
    }

    // method, which shows transaction history from a particular date.
    public static void showFrom(String firstMonth) {
        rewriteArray(firstMonth);
        displayDates(rangeLists);
    }

    // method, which shows transaction history in a particular range.
    public static void showRange(String firstMonth, String secondMonth) {
        rewriteArray(firstMonth, secondMonth);
        displayDates(rangeLists);
    }

    // method, which shows transactions history.
    public static void showData() {
        readToArray();
        displayDates(lists);
    }

    // method, which writes the data from given range to array.
    private static void rewriteArray(String firstMonth, String secondMonth) {
        rangeLists.clear();
        try {
            if (monthExits(firstMonth) && monthExits(secondMonth)) {
                int start = getPossition(firstMonth); // get the position of first month.
                int end = getPossition(secondMonth) + 1; // get the position of second month.

                // examine through lists array in a particular range.
                for (int i = start; i <= end; i++)
                    rangeLists.add(lists.get(i));

                return;
            }
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }

    // method, which writes the data from given date to array.
    private static void rewriteArray(String firstMonth) {
        rangeLists.clear(); // clear the array of the possible previous session.

        try {
            if (monthExits(firstMonth)) {
                int start = getPossition(firstMonth); // get the position of first month.

                // examine through lists array from a given date.
                for (int i = start; i < lists.size(); i++)
                    rangeLists.add(lists.get(i));

            }
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }

    // method, which returns the index of date in lists array.
    private static int getPossition(String month) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).startsWith("date: ") && lists.get(i).substring(6).equals(month))
                return i;
        }

        return -1;
    }

    // method, which displays the array, given from this class.
    private static void displayDates(ArrayList<String> array) {

        System.out.println("===Spendings==");
        // examine through array.
        for (String list : array) {
            if (list.startsWith("date: ")) {
                date = list.substring(6);
            } else if (list.startsWith("money: ")) {
                money = list.substring(7);
                System.out.println(date + ": $" + money); // display the infromation after given date.
            }
        }

        System.out.println();
    }

    // method, which checks if given date is already written in our database.
    private static boolean monthExits(String month) {
        readToArray();

        // examine through array.
        for (String list : lists) {

            // check, if line starts with "date: " and equals to the given month.
            if (list.startsWith("date: ") && list.substring(6).equals(month))
                return true;
        }

        System.out.println(month + " doesn't exist in our database.");
        return false;
    }
}
