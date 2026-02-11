import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Personal Finance Manager =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addTransaction(manager, scanner, "Income");
                    break;

                case 2:
                    addTransaction(manager, scanner, "Expense");
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + manager.getBalance());
                    break;

                case 4:
                    manager.getTransactions().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void addTransaction(FinanceManager manager, Scanner scanner, String type) {
        scanner.nextLine();  // consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        manager.addTransaction(type, category, amount);
        System.out.println(type + " added successfully!");
    }
}
