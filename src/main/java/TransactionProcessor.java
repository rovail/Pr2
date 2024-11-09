import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionProcessor {
    public static List<Transaction> processTransactions(List<String[]> rawData) {
        List<Transaction> transactions = new ArrayList<>();
        for (String[] row : rawData) {
            if (row.length >= 2) {
                String date = row[0];
                double amount = Double.parseDouble(row[1]);
                String description = row.length > 2 ? row[2] : null;

                String category = amount >= 0 ? "Дохід" : "Витрата";

                transactions.add(new Transaction(date, amount, description, category));
            } else {
                System.out.println("Недостатньо даних у рядку: " + Arrays.toString(row));
            }
        }
        return transactions;
    }
}
