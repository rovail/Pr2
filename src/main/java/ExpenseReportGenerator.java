import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseReportGenerator {
    private List<Transaction> transactions;

    public ExpenseReportGenerator(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static String generateReport(List<Transaction> transactions) {
        Map<String, Double> categoryTotals = new HashMap<>();
        Map<String, Double> monthlyTotals = new HashMap<>();

        for (Transaction transaction : transactions) {
            String category = transaction.getCategory();
            double amount = transaction.getAmount();

            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);

            // Изменение формата даты для включения года
            String monthYear = transaction.getDate().substring(0, 10);
            monthlyTotals.put(monthYear, monthlyTotals.getOrDefault(monthYear, 0.0) + amount);
        }

        StringBuilder report = new StringBuilder();
        report.append("========================================\n");
        report.append("Сумарні витрати по категоріях:\n");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            report.append(String.format("%-20s: %,.2f грн\n", entry.getKey(), entry.getValue()));
        }

        report.append("\n========================================\n");
        report.append("Сумарні витрати по місяцях:\n");
        for (Map.Entry<String, Double> entry : monthlyTotals.entrySet()) {
            report.append(String.format("%-20s: %,.2f грн\n", entry.getKey(), entry.getValue()));
        }
        report.append("========================================\n");

        return report.toString();
    }

}

