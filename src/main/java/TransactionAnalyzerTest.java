import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", 100.0, "Дохід", "Income"),
                new Transaction("2023-01-02", -50.0, "Витрата", "Expense"),
                new Transaction("2023-01-03", 150.0, "Дохід", "Income")
        );

        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("01-02-2023", 50.0, "Дохід", "Income"),
                new Transaction("15-02-2023", -20.0, "Витрата", "Expense"),
                new Transaction("05-03-2023", 100.0, "Дохід", "Income")
        );

        int countFeb = TransactionAnalyzer.countTransactionsByMonth(transactions, "02-2023");
        int countMar = TransactionAnalyzer.countTransactionsByMonth(transactions, "03-2023");

        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testGetTop10Expenses() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-12-05", -7850, "Сільпо", "Продукти"),
                new Transaction("2023-12-07", -1200, "Аптека", "Медицина"),
                new Transaction("2024-01-20", -8800, "Подарунки", "Розваги"),
                new Transaction("2024-01-30", -9100, "Інші витрати", "Різне"),
                new Transaction("2024-01-18", -750, "Кав'ярня", "Розваги")
        );

        List<Transaction> topExpenses = TransactionAnalyzer.getTopNExpenses(transactions, 10);

        Assertions.assertNotNull(topExpenses, "Список найбільших витрат не повинен бути null");
        Assertions.assertEquals(5, topExpenses.size(), "Список найбільших витрат повинен містити 5 елементів");

        for (int i = 1; i < topExpenses.size(); i++) {
            Assertions.assertTrue(topExpenses.get(i - 1).getAmount() <= topExpenses.get(i).getAmount(),
                    "Список витрат повинен бути відсортований за спаданням");
        }
    }
}
