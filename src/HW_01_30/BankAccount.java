package HW_01_30;
public class BankAccount {
    private String owner;
    private double balance;
    private double withdrawalLimit;

    public BankAccount(String owner, double initialBalance, double withdrawalLimit) {
        this.owner = owner;
        this.balance = initialBalance;
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > withdrawalLimit) {
            throw new IllegalArgumentException("Exceeded withdrawal limit.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    public double getInterestDue() {
        if (balance < 1000) {
            return balance * 0.01;  // 1% interest for balances below $1000
        } else if (balance < 5000) {
            return balance * 0.02;  // 2% interest for balances $1000 - $4999
        } else {
            return balance * 0.03;  // 3% interest for balances $5000+
        }
    }
}
