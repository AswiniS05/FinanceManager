public class Transaction {

    private String type;       // Income or Expense
    private String category;
    private double amount;

    public Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String toFileString() {
        return type + "," + category + "," + amount;
    }

    public static Transaction fromFileString(String line) {
        String[] parts = line.split(",");
        return new Transaction(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    @Override
    public String toString() {
        return type + " | " + category + " | ₹" + amount;
    }
}
