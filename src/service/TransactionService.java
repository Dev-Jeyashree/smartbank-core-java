package service;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import model.Account;

public interface TransactionService {

    void deposit(
            Account account,
            double amount)
            throws InvalidAmountException;

    void withdraw(
            Account account,
            double amount)
            throws InvalidAmountException,
            InsufficientBalanceException;

    void transfer(
            Account sender,
            Account receiver,
            double amount)
            throws InvalidAmountException,
            InsufficientBalanceException;
}