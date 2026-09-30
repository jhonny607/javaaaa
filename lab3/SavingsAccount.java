public class SavingsAccount extends BankAccount implements AccountInfo {
    private double interestRate;

    public SavingsAccount(String accountNumber, String owner,
                          double balance, double interestRate) {
        super(accountNumber, owner, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    @Override
    public String getInfo() {
        return "Сберегательный счет " + accountNumber +
                ", процентная ставка: " + interestRate + "%";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", тип: сберегательный" +
                ", ставка: " + interestRate + "%";
    }
}