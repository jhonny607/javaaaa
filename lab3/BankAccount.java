public abstract class BankAccount {
    protected String accountNumber;
    protected String owner;
    protected double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    @Override
    public String toString() {
        return "Счет: " + accountNumber +
                ", владелец: " + owner +
                ", баланс: " + balance + " руб.";
    }
}