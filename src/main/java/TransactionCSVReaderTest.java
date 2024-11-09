import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class TransactionCSVReaderTest {
    @Test
    public void testReadData() {
        List<String[]> data = TransactionCSVReader.readData("https://informer.com.ua/dut/java/pr2.csv");

        Assertions.assertNotNull(data, "Дані не повинні бути null");
        Assertions.assertFalse(data.isEmpty(), "Дані не повинні бути порожніми");
    }
}
