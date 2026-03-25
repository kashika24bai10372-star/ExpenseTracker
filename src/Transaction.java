public class Transaction {
    String type; // income or expense
    String category;
    double amount;

    public Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return type + " | " + category + " | ₹" + amount;
    }
}
    