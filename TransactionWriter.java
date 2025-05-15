package personalFinanceManager.src;

import java.io.*;

// a class, which writes a file into a database
public class TransactionWriter {
    static String newline = System.getProperty("line.seperator");
    static int line;

    // method, which writes encrypted data into data/transactions.dat
    public static void writeData(int month, int money) {

        // first check, if the month already exists in out database.
        if (!monthExits(month) && month != -1 && money != -1) {

            // write data into a file.
            try (DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("personalFinanceManager/data/transactions.bin"))) {
                out.writeChars("M: ");
                out.writeInt(month);
                out.writeChars(newline);
                out.writeChars("$: ");
                out.writeInt(money);
                out.writeChars(newline);
                return;
            } catch (IOException exc) {
                System.out.println("Unexpected behavour has happaned in writeData method: " + exc);
            }
        }
    }

    // method, which cheks if particular month is already written in our database.
    private static boolean monthExits(int month) {
        try (DataInputStream in = new DataInputStream(
                new FileInputStream("personalFinanceManager/data/transactions.bin"))) {

            // read until the end.
            while ((line = in.readInt()) != -1) {

                System.out.println(month + " is already written in our database.");
                return true;
            }
        } catch (IOException exc) {
            System.out.println("Unexpected behavour has happaned in monthExists method: " + exc);
        }
        return false;
    }
}
