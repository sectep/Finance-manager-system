package personalFinanceManager.src;

import java.io.*;
import java.util.ArrayList;

public class TransactionReader {
    static int data;
    static String lineArray;
    static ArrayList<Integer> list = new ArrayList<>();

    // method, which reads the data from a file.
    public static void readData() {
        try (DataInputStream in = new DataInputStream(
                new FileInputStream("personalFinanceManager/data/transactions.bin"))) {
            while ((data = in.readInt()) != -1) {
                System.out.println(data + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Unexpected behavour has happaned in readData method: " + exc);
        }
    }
}
