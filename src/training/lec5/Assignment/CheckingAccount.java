package training.lec5.Assignment;

public class CheckingAccount extends Account {

    private double transferFeeRate = 0.05;

    public CheckingAccount(int accountNo, String accountName, String accountPass) {
        super(accountNo, accountName, accountPass, true);
    }

    public double getTransferFee(double amount) {
        if (amount > 1000) {
            return 50;
        } else {
            return amount * transferFeeRate;
        }
    }
}
