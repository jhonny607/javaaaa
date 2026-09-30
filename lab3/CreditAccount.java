public class CreditAccount extends BankAccount implements AccountInfo {
    private double creditLimit;

    public CreditAccount(String accountNumber, String owner,
                         double balance, double creditLimit) {
        super(accountNumber, owner, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public double calculateInterest() {
        double usedCredit = 0;

        if (balance < 0) {
            usedCredit = -balance;
        }

        return usedCredit * 0.05;
    }

    @Override
    public String getInfo() {
        return "Кредитный счет " + accountNumber +
                ", кредитный лимит: " + creditLimit + " руб.";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", тип: кредитный" +
                ", лимит: " + creditLimit + " руб.";
    }
}