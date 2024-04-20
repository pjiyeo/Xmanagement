package bankservice;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

public class AdminService {
    private BankService bankService;
    private final static double INITIAL_BANK_BALANCE = 1000000000; // 1 billion KRW
    private double bankBalance = INITIAL_BANK_BALANCE;
    private List<Transaction> dailyTransactions;

    public AdminService(BankService bankService) {
        this.bankService = bankService;
        this.dailyTransactions = new ArrayList<>();
    }

    // Method to simulate transaction logging
    public void logTransaction(Transaction transaction) {
        dailyTransactions.add(transaction);
        updateBalance(transaction);
    }

    private void updateBalance(Transaction transaction) {
        if (transaction.getType().equals("deposit")) {
            bankBalance += transaction.getAmount();
        } else if (transaction.getType().equals("withdraw") || transaction.getType().equals("transfer")) {
            bankBalance -= transaction.getAmount();
        }
    }

    public void generateDailyReport() {
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Seoul"));
        if (now.isBefore(LocalTime.of(18, 0))) {
            System.out.println("보고서는 6시 이후에만 열람 가능합니다.");
            return;
        }

        int totalCustomers = bankService.getTotalAccountCount();
        int individualCustomers = bankService.getIndividualAccountCount();
        int corporateCustomers = bankService.getCorporateAccountCount();

        System.out.println("『보고서』");
        System.out.println("전체 고객 수: " + totalCustomers);
        System.out.println("개인 고객 수: " + individualCustomers);
        System.out.println("법인 고객 수: " + corporateCustomers);
        System.out.println("은행 잔고: " + bankBalance);

        System.out.println("【거래내역】");
        for (Transaction transaction : dailyTransactions) {
            System.out.println(transaction);
        }

        // Reset transactions for the next day
        dailyTransactions.clear();
    }
}

class Transaction {
    private String type; // "deposit", "withdraw", "transfer"
    private double amount;
    private String details;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Details: " + details;
    }
}

