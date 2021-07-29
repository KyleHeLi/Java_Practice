package training.lec5.Assignment;

public class Account {
    int accountNo;
    String accountName;
    String accountPass;
    boolean isChecking;
    double balance;

    public Account(int accountNo, String accountName, String accountPass, boolean isChecking) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.isChecking = isChecking;
        balance = 0;
    }

    public boolean isCheckingAcount() {
        return isChecking;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
