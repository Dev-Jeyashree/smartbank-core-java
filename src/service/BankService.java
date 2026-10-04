package service;

import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import model.Account;
import model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class BankService implements TransactionService {

    private Map<String, Account> accounts;

    public BankService() {

        accounts = new HashMap<>();
    }

    // ==============================
    // CREATE ACCOUNT
    // ==============================

    public void createAccount(Account account) {

        if (accounts.containsKey(account.getAccountNumber())) {

            System.out.println(
                    "Account number already exists."
            );

            return;
        }

        accounts.put(
                account.getAccountNumber(),
                account
        );

        System.out.println(
                "Account created successfully!"
        );
    }

    // ==============================
    // FIND ACCOUNT
    // ==============================

    public Account findAccount(
            String accountNumber)
            throws AccountNotFoundException {

        Account account =
                accounts.get(accountNumber);

        if (account == null) {

            throw new AccountNotFoundException(
                    "Account not found: "
                            + accountNumber
            );
        }

        return account;
    }

    // ==============================
    // DISPLAY ALL ACCOUNTS
    // ==============================

    public void displayAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println(
                    "No accounts available."
            );

            return;
        }

        accounts.values()
                .forEach(System.out::println);
    }

    // ==============================
    // DEPOSIT
    // ==============================

    @Override
    public void deposit(
            Account account,
            double amount)
            throws InvalidAmountException {

        validateAmount(amount);

        account.depositAmount(amount);

        account.addTransaction(
                new Transaction(
                        "DEPOSIT",
                        amount
                )
        );

        System.out.println(
                "Amount deposited successfully."
        );
    }

    // ==============================
    // WITHDRAW
    // ==============================

    @Override
    public void withdraw(
            Account account,
            double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        validateAmount(amount);

        if (amount > account.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        account.withdrawAmount(amount);

        account.addTransaction(
                new Transaction(
                        "WITHDRAW",
                        amount
                )
        );

        System.out.println(
                "Amount withdrawn successfully."
        );
    }

    // ==============================
    // TRANSFER
    // ==============================

    @Override
    public void transfer(
            Account sender,
            Account receiver,
            double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        validateAmount(amount);

        if (sender == receiver) {

            throw new InvalidAmountException(
                    "Sender and receiver cannot be the same account."
            );
        }

        if (amount > sender.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance in sender account."
            );
        }

        // Withdraw from sender

        sender.withdrawAmount(amount);

        sender.addTransaction(
                new Transaction(
                        "TRANSFER TO "
                                + receiver.getAccountNumber(),
                        amount
                )
        );

        // Deposit to receiver

        receiver.depositAmount(amount);

        receiver.addTransaction(
                new Transaction(
                        "TRANSFER FROM "
                                + sender.getAccountNumber(),
                        amount
                )
        );

        System.out.println(
                "Transfer successful!"
        );
    }

    // ==============================
    // DELETE ACCOUNT
    // ==============================

    public void deleteAccount(
            String accountNumber)
            throws AccountNotFoundException {

        if (!accounts.containsKey(accountNumber)) {

            throw new AccountNotFoundException(
                    "Account not found: "
                            + accountNumber
            );
        }

        accounts.remove(accountNumber);

        System.out.println(
                "Account deleted successfully."
        );
    }

    // ==============================
    // SEARCH ACCOUNT
    // ==============================

    public void searchByHolderName(
            String name) {

        accounts.values()
                .stream()
                .filter(account ->
                        account.getHolderName()
                                .equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    // ==============================
    // TOTAL BANK BALANCE
    // ==============================

    public double getTotalBankBalance() {

        return accounts.values()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    // ==============================
    // ACCOUNT COUNT
    // ==============================

    public long getAccountCount() {

        return accounts.values()
                .stream()
                .count();
    }

    // ==============================
    // VALIDATE AMOUNT
    // ==============================

    private void validateAmount(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Amount must be greater than zero."
            );
        }
    }
}