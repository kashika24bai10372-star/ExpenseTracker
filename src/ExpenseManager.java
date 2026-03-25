import java.util.*;
import java.io.*;

public class ExpenseManager {
    private List<Transaction> transactions = new ArrayList<>();
    private final String FILE_NAME = "data.txt";

    public ExpenseManager() {
        loadFromFile();
    }

    public void addTransaction(String type, String category, double amount) {
        transactions.add(new Transaction(type, category, amount));
        saveToFile();
        System.out.println("Saving to: " + new File(FILE_NAME).getAbsolutePath());
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("income")) {
                balance += t.amount;
            } else {
                balance -= t.amount;
            }
        }

        return balance;
    }

    public void filterByCategory(String category) {
        for (Transaction t : transactions) {
            if (t.category.equalsIgnoreCase(category)) {
                System.out.println(t);
            }
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Transaction t : transactions) {
                writer.println(t.type + "," + t.category + "," + t.amount);
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                transactions.add(new Transaction(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
}