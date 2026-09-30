import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankAccount[] accounts = {
                new SavingsAccount("1001", "Иванов Иван", 100000, 8),
                new CreditAccount("2001", "Петров Петр", -50000, 150000),
                new SavingsAccount("1002", "Сидоров Алексей", 250000, 10),
                new CreditAccount("2002", "Смирнов Андрей", -30000, 100000),
                new SavingsAccount("1003", "Козлов Максим", 80000, 7)
        };

        System.out.println("=== Полиморфизм ===");

        for (BankAccount account : accounts) {
            System.out.println(account);
            System.out.printf(
                    "Проценты: %.2f руб.%n%n",
                    account.calculateInterest()
            );
        }

        System.out.println("=== Интерфейс AccountInfo ===");

        List<AccountInfo> accountInfos = new ArrayList<>();

        for (BankAccount account : accounts) {
            if (account instanceof AccountInfo) {
                accountInfos.add((AccountInfo) account);
            }
        }

        for (AccountInfo account : accountInfos) {
            System.out.println(account.getInfo());
        }
    }
}