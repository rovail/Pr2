import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<String[]> rawData = TransactionCSVReader.readData(filePath);

        List<Transaction> transactions = TransactionProcessor.processTransactions(rawData);

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        String startDate = "01-01-2024";
        String endDate = "31-01-2024";

        Transaction minExpense = TransactionAnalyzer.getMinExpense(transactions, startDate, endDate);
        Transaction maxExpense = TransactionAnalyzer.getMaxExpense(transactions, startDate, endDate);

        TransactionReportGenerator.printMinExpense(minExpense);
        TransactionReportGenerator.printMaxExpense(maxExpense);

        String report = ExpenseReportGenerator.generateReport(transactions);
        System.out.println(report);
    }
}
