import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ExpenseReportGeneratorTest {
    @Test
    public void testGenerateReport() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-12-05", -7850, "Сільпо", "Продукти"),
                new Transaction("2023-12-07", -1200, "Аптека", "Медицина"),
                new Transaction("2024-01-20", -8800, "Подарунки", "Розваги"),
                new Transaction("2024-01-30", -9100, "Інші витрати", "Різне"),
                new Transaction("2024-01-18", -750, "Кав'ярня", "Розваги")
        );

        String report = ExpenseReportGenerator.generateReport(transactions);

        Assertions.assertNotNull(report, "Звіт не повинен бути null");
        Assertions.assertTrue(report.contains("Сумарні витрати по категоріях"), "Звіт повинен містити заголовок для категорій");
        Assertions.assertTrue(report.contains("Сумарні витрати по місяцях"), "Звіт повинен містити заголовок для місяців");
    }
}
