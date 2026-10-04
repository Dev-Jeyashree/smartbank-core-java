package model;

public class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(
            String accountNumber,
            String holderName,
            double balance) {

        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {

        return getBalance() * INTEREST_RATE;
    }
}