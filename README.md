# Personal Finance Manager

This is a simple console-based application for managing personal finances. It allows users to add transactions, view all transactions, view transactions within a specific period, and view transactions from a specific date.

## Features

* **Add transaction:** Allows the user to input a date (in DD.MM.YYYY format) and the amount spent for that transaction. This data is stored in a text file.
* **Show transactions:** Displays a history of all recorded transactions with their dates and amounts.
* **Show transactions by period:** Prompts the user for a start and end date (in DD.MM.YYYY format) and displays all transactions within that date range.
* **Show transactions by date:** Asks the user for a specific date (in DD.MM.YYYY format) and shows all transactions recorded on or after that date.
* **Exit:** Terminates the application.

## How to Run

1.  Save the provided Java code into the following directory structure:
    ```
    personalFinanceManager/src/
    ```
    Ensure you have the following files within this structure:
    * `ConsoleInterface.java`
    * `Main.java`
    * `TransactionReader.java`
    * `TransactionWriter.java`
2.  Create a directory named `data` inside the `personalFinanceManager` directory:
    ```
    personalFinanceManager/data/
    ```
3.  Inside the `data` directory, create an empty text file named `transactions.txt`:
    ```
    personalFinanceManager/data/transactions.txt
    ```
4.  Compile the Java source files. Open a terminal or command prompt, navigate to the `personalFinanceManager` directory, and run the following command:
    ```bash
    javac src/*.java
    ```
5.  Run the application from the `personalFinanceManager/src` directory:
    ```bash
    java personalFinanceManager.src.Main
    ```
    Alternatively, if your classpath is correctly configured, you might be able to run it from the `personalFinanceManager` directory:
    ```bash
    java personalFinanceManager.src.ConsoleInterface
    ```

## Code Structure

The project consists of the following Java classes:

* `ConsoleInterface.java`: Handles the console-based user interface, displaying options and taking user input.
* `Main.java`: The entry point of the application, which creates and launches the `ConsoleInterface`.
* `TransactionReader.java`: Responsible for reading transaction data from the `transactions.txt` file and displaying it based on different criteria (all, by period, by date).
* `TransactionWriter.java`: Handles writing new transaction data (date and amount) to the `transactions.txt` file.

# Personal Finance Manager

This is a simple console-based application for managing personal finances. It allows users to add transactions, view all transactions, view transactions within a specific period, and view transactions from a specific date.

## Features

* **Add transaction:** Allows the user to input a date (in DD.MM.YYYY format) and the amount spent for that transaction. This data is stored in a text file.
* **Show transactions:** Displays a history of all recorded transactions with their dates and amounts.
* **Show transactions by period:** Prompts the user for a start and end date (in DD.MM.YYYY format) and displays all transactions within that date range.
* **Show transactions by date:** Asks the user for a specific date (in DD.MM.YYYY format) and shows all transactions recorded on or after that date.
* **Exit:** Terminates the application.

## How to Run

1.  Save the provided Java code into the following directory structure:
    ```
    personalFinanceManager/src/
    ```
    Ensure you have the following files within this structure:
    * `ConsoleInterface.java`
    * `Main.java`
    * `TransactionReader.java`
    * `TransactionWriter.java`
2.  Create a directory named `data` inside the `personalFinanceManager` directory:
    ```
    personalFinanceManager/data/
    ```
3.  Inside the `data` directory, create an empty text file named `transactions.txt`:
    ```
    personalFinanceManager/data/transactions.txt
    ```
4.  Compile the Java source files. Open a terminal or command prompt, navigate to the `personalFinanceManager` directory, and run the following command:
    ```bash
    javac src/*.java
    ```
5.  Run the application from the `personalFinanceManager/src` directory:
    ```bash
    java personalFinanceManager.src.Main
    ```
    Alternatively, if your classpath is correctly configured, you might be able to run it from the `personalFinanceManager` directory:
    ```bash
    java personalFinanceManager.src.ConsoleInterface
    ```

## Code Structure

The project consists of the following Java classes:

* `ConsoleInterface.java`: Handles the console-based user interface, displaying options and taking user input.
* `Main.java`: The entry point of the application, which creates and launches the `ConsoleInterface`.
* `TransactionReader.java`: Responsible for reading transaction data from the `transactions.txt` file and displaying it based on different criteria (all, by period, by date).
* `TransactionWriter.java`: Handles writing new transaction data (date and amount) to the `transactions.txt` file.

## Data Storage

Transaction data is stored in a simple text file named `transactions.txt` located in the `personalFinanceManager/data/` directory. Each transaction occupies two lines: the first line contains the date in the format `date: DD.MM.YYYY`, and the second line contains the amount spent in the format `money: amount`.


## Notes

* The application relies on user input in the specified format (DD.MM.YYYY for dates). Incorrect input might lead to errors.
* The data is stored in a plain text file, which is suitable for simple use cases but might not be robust for handling large amounts of data or concurrent access.
