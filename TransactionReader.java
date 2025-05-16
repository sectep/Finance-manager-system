package personalFinanceManager.src;

import java.io.*;
import java.util.ArrayList;

public class TransactionReader {
    static int index;
    static String data;
    static String lineArray;
    static ArrayList<String> lists = new ArrayList<>();
    static ArrayList<String> rangeLists = new ArrayList<>();

    // method, which reads the data from a file.
    public static void readToArray() {
        try (BufferedReader in = new BufferedReader(
                new FileReader("personalFinanceManager/data/transactions.txt"))) {
            while ((data = in.readLine()) != null) {
                lists.add(data);
            }
        } catch (IOException exc) {
            System.out.println("Unexpected behavour has happaned in readData method: " + exc);
        }
    }

    // method, which reads the data from given range.
    public static void rewriteArray(String firstMonth, String secondMonth) {
        readToArray();

        if (monthExits(firstMonth) && monthExits(secondMonth)) {
            // read the lists array.
            for (int i = 0; i < lists.size(); i++) {
                if (!(i < get1Possition(firstMonth) && i > get2Possition(secondMonth)))
                    rangeLists.add(lists.get(i));
            }
            return;
        }

    }

    // method, which returns the index of first month.
    private static int get1Possition(String firstMonth) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).startsWith("date: ") && lists.get(i).substring(6).equals(firstMonth)) {
                index = i;
            }
        }
        return index;
    }

    // method, which returns the index of second month.
    private static int get2Possition(String secondtMonth) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).startsWith("date: ") && lists.get(i).substring(6).equals(secondtMonth)) {
                index = i;
            }

        }
        return index;
    }

    // method, which shows the data from transactions.txt.
    public static void showData() {
        readToArray();
        for (String list : lists) {
            System.out.println(list);
        }
    }

    // method, which cheks if particular month is already written in our database.
    private static boolean monthExits(String month) {
        for (String list : lists) {
            if (list.startsWith("date: ") && list.substring(6).equals(month)) {
                return true;
            }
        }

        return false;
    }
}
