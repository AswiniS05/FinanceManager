import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {

    private List<Transaction> transactions;
    private double balance;
    private final String FILE_NAME = "transactions.txt";

    public FinanceManager() {
        transactions = new ArrayList<>();
        loadFromFile();
    }

    public void addTransaction(String type, String category, double amount) {
        Transaction transaction = new Transaction(type, category, amount);
        transactions.add(transaction);

        if (type.equalsIgnoreCase("Income")) {
            balance += amount;
        } else {
            balance -= amount;
        }

        saveToFile();
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Transaction t : transactions) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Transaction t = Transaction.fromFileString(line);
                transactions.add(t);

                if (t.getType().equalsIgnoreCase("Income")) {
                    balance += t.getAmount();
                } else {
                    balance -= t.getAmount();
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }
}
