import java.util.List;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance) {
        System.out.print("========================================\n");
        System.out.printf("Сумарний баланс: %.2f грн\n", totalBalance);
        System.out.print("========================================\n");
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.printf("Кількість транзакцій за %s: %d\n", monthYear, count);
        System.out.print("========================================\n");
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction transaction : topExpenses) {
            System.out.printf("%s: %.2f грн\n", transaction.getCategory(), transaction.getAmount());
        }
        System.out.print("========================================\n");
    }

    public static void printMinExpense(Transaction minExpense) {
        if (minExpense != null) {
            System.out.printf("Мінімальна витрата: %.2f грн на дату %s\n", minExpense.getAmount(), minExpense.getDate());
        }
        System.out.print("========================================\n");
    }

    public static void printMaxExpense(Transaction maxExpense) {
        if (maxExpense != null) {
            System.out.printf("Максимальна витрата: %.2f грн на дату %s\n", maxExpense.getAmount(), maxExpense.getDate());
        }
        System.out.print("========================================\n");
    }

    public static void printCategoryExpenses(double totalExpenses, double totalIncome) {
        System.out.print("Сумарні витрати по категоріях:\n");
        System.out.printf("Витрата: %.2f грн\n", totalExpenses);
        System.out.printf("Дохід: %.2f грн\n", totalIncome);
        System.out.print("========================================\n");
    }
}
