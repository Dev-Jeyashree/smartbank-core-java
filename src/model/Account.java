package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String holderName;
    private double balance;

    private List<Transaction> transactions;

    public Account(String accountNumber, String holderName, double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;

        transactions = new ArrayList<>();
    }

    // Getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Controlled balance operations

    protected void addBalance(double amount) {
        balance += amount;
    }

    protected void subtractBalance(double amount) {
        balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Used by BankService for transactions

    public void depositAmount(double amount) {
        addBalance(amount);
    }

    public void withdrawAmount(double amount) {
        subtractBalance(amount);
    }

    // Abstract method

    public abstract double calculateInterest();

    @Override
    public String toString() {

        return "Account Number: " + accountNumber
                + ", Holder: " + holderName
                + ", Balance: ₹" + balance;
    }
}