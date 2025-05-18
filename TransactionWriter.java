package personalFinanceManager.src;

import java.io.*;

// a class, which writes a file into a database.
public class TransactionWriter {
    static String line; // allocate the line from 'transactions.txt' file.

    // method, which writes data into 'transactions.txt' file.
    public static void writeData(String month, int money) {

        // first check, if the month already exists in our database and if the type is
        // valid.
        if (!monthExits(month) && month != null && money != -1) {

            // write data into a file.
            try (BufferedWriter out = new BufferedWriter(
                    new FileWriter("personalFinanceManager/data/transactions.txt", true))) {
                out.write("date: " + month + "\n");
                out.write("money: " + money + "\n");
                return;
            } catch (IOException exc) {
                System.out.println("An unexpected error has occurred: " + exc);
            }
        }
    }

    // method, which checks if given date is already written in our database.
    private static boolean monthExits(String month) {
        try (BufferedReader in = new BufferedReader(
                new FileReader("personalFinanceManager/data/transactions.txt"))) {

            // read until the end.
            while ((line = in.readLine()) != null) {
                if (line.startsWith("date: ") && line.substring(6).equals(month)) {
                    return true;
                }
            }
        } catch (IOException exc) {
            System.out.println("An unexpected error has occurred: " + exc);
        }

        System.out.println(month + " is already written in our database.");
        return false;
    }
}
