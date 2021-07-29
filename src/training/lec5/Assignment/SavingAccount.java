package training.lec5.Assignment;

public class SavingAccount extends Account {
    private double interest = 1.15;

    public SavingAccount(int accountNo, String accountName, String accountPass, boolean isChecking) {
        super(accountNo, accountName, accountPass, false);
    }

    public double returnBalanceInOneYear() {
        return balance * interest;
    }
}
