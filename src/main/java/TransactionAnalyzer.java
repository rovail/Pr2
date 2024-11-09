import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        return (int) transactions.stream()
                .filter(transaction -> {
                    LocalDate date = LocalDate.parse(transaction.getDate(), DATE_FORMATTER);
                    String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
                    return transactionMonthYear.equals(monthYear);
                })
                .count();
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Transaction> getTopExpenses(List<Transaction> transactions, int n) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static List<Transaction> getTopNExpenses(List<Transaction> transactions, int n) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static Transaction getMinExpense(List<Transaction> transactions, String startDate, String endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMATTER);
                    return (date.isEqual(LocalDate.parse(startDate, DATE_FORMATTER)) || date.isAfter(LocalDate.parse(startDate, DATE_FORMATTER))) &&
                            (date.isEqual(LocalDate.parse(endDate, DATE_FORMATTER)) || date.isBefore(LocalDate.parse(endDate, DATE_FORMATTER)));
                })
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);
    }

    public static Transaction getMaxExpense(List<Transaction> transactions, String startDate, String endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMATTER);
                    return (date.isEqual(LocalDate.parse(startDate, DATE_FORMATTER)) || date.isAfter(LocalDate.parse(startDate, DATE_FORMATTER))) &&
                            (date.isEqual(LocalDate.parse(endDate, DATE_FORMATTER)) || date.isBefore(LocalDate.parse(endDate, DATE_FORMATTER)));
                })
                .min(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);
    }
}
