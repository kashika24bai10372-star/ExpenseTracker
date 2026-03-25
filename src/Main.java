import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. Filter by Category");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String icat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double iamt = sc.nextDouble();
                    manager.addTransaction("income", icat, iamt);
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String ecat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double eamt = sc.nextDouble();
                    manager.addTransaction("expense", ecat, eamt);
                    break;

                case 3:
                    manager.viewTransactions();
                    break;

                case 4:
                    System.out.println("Balance: ₹" + manager.getBalance());
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    manager.filterByCategory(cat);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}