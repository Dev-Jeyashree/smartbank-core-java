import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        BankService bank =
                new BankService();

        // ==============================
        // SAMPLE ACCOUNTS
        // ==============================

        Account account1 =
                new SavingsAccount(
                        "SB1001",
                        "Jeyashree",
                        10000
                );

        Account account2 =
                new SavingsAccount(
                        "SB1002",
                        "Anitha",
                        15000
                );

        Account account3 =
                new CurrentAccount(
                        "CA1001",
                        "Priya",
                        25000
                );

        bank.createAccount(account1);
        bank.createAccount(account2);
        bank.createAccount(account3);

        // ==============================
        // MENU
        // ==============================

        while (true) {

            System.out.println();
            System.out.println(
                    "================================"
            );

            System.out.println(
                    "          SMART BANK"
            );

            System.out.println(
                    "================================"
            );

            System.out.println(
                    "1. Display All Accounts"
            );

            System.out.println(
                    "2. Create Account"
            );

            System.out.println(
                    "3. Deposit"
            );

            System.out.println(
                    "4. Withdraw"
            );

            System.out.println(
                    "5. Transfer Money"
            );

            System.out.println(
                    "6. Check Balance"
            );

            System.out.println(
                    "7. Transaction History"
            );

            System.out.println(
                    "8. Search Account"
            );

            System.out.println(
                    "9. Delete Account"
            );

            System.out.println(
                    "10. Bank Statistics"
            );

            System.out.println(
                    "11. Calculate Interest"
            );

            System.out.println(
                    "12. Exit"
            );

            System.out.println(
                    "================================"
            );

            System.out.print(
                    "Enter choice: "
            );

            int choice;

            try {

                choice =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                continue;
            }

            try {

                switch (choice) {

                    // =====================================
                    // DISPLAY ACCOUNTS
                    // =====================================

                    case 1:

                        bank.displayAllAccounts();

                        break;

                    // =====================================
                    // CREATE ACCOUNT
                    // =====================================

                    case 2:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String accountNumber =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Holder Name: "
                        );

                        String holderName =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Initial Balance: "
                        );

                        double initialBalance =
                                Double.parseDouble(
                                        scanner.nextLine()
                                );

                        if (initialBalance < 0) {

                            System.out.println(
                                    "Balance cannot be negative."
                            );

                            break;
                        }

                        System.out.println();

                        System.out.println(
                                "1. Savings Account"
                        );

                        System.out.println(
                                "2. Current Account"
                        );

                        System.out.print(
                                "Select Account Type: "
                        );

                        int type =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        Account newAccount;

                        if (type == 1) {

                            newAccount =
                                    new SavingsAccount(
                                            accountNumber,
                                            holderName,
                                            initialBalance
                                    );

                        } else if (type == 2) {

                            newAccount =
                                    new CurrentAccount(
                                            accountNumber,
                                            holderName,
                                            initialBalance
                                    );

                        } else {

                            System.out.println(
                                    "Invalid account type."
                            );

                            break;
                        }

                        bank.createAccount(newAccount);

                        break;

                    // =====================================
                    // DEPOSIT
                    // =====================================

                    case 3:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String depositAccount =
                                scanner.nextLine();

                        Account depositTarget =
                                bank.findAccount(
                                        depositAccount
                                );

                        System.out.print(
                                "Enter Deposit Amount: "
                        );

                        double depositAmount =
                                Double.parseDouble(
                                        scanner.nextLine()
                                );

                        bank.deposit(
                                depositTarget,
                                depositAmount
                        );

                        break;

                    // =====================================
                    // WITHDRAW
                    // =====================================

                    case 4:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String withdrawAccount =
                                scanner.nextLine();

                        Account withdrawTarget =
                                bank.findAccount(
                                        withdrawAccount
                                );

                        System.out.print(
                                "Enter Withdrawal Amount: "
                        );

                        double withdrawAmount =
                                Double.parseDouble(
                                        scanner.nextLine()
                                );

                        bank.withdraw(
                                withdrawTarget,
                                withdrawAmount
                        );

                        break;

                    // =====================================
                    // TRANSFER
                    // =====================================

                    case 5:

                        System.out.print(
                                "Enter Sender Account Number: "
                        );

                        String senderNumber =
                                scanner.nextLine();

                        Account sender =
                                bank.findAccount(
                                        senderNumber
                                );

                        System.out.print(
                                "Enter Receiver Account Number: "
                        );

                        String receiverNumber =
                                scanner.nextLine();

                        Account receiver =
                                bank.findAccount(
                                        receiverNumber
                                );

                        System.out.print(
                                "Enter Transfer Amount: "
                        );

                        double transferAmount =
                                Double.parseDouble(
                                        scanner.nextLine()
                                );

                        bank.transfer(
                                sender,
                                receiver,
                                transferAmount
                        );

                        break;

                    // =====================================
                    // CHECK BALANCE
                    // =====================================

                    case 6:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String balanceAccount =
                                scanner.nextLine();

                        Account balanceTarget =
                                bank.findAccount(
                                        balanceAccount
                                );

                        System.out.println(
                                "Account Holder: "
                                        + balanceTarget
                                        .getHolderName()
                        );

                        System.out.println(
                                "Current Balance: ₹"
                                        + balanceTarget
                                        .getBalance()
                        );

                        break;

                    // =====================================
                    // TRANSACTION HISTORY
                    // =====================================

                    case 7:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String transactionAccount =
                                scanner.nextLine();

                        Account transactionTarget =
                                bank.findAccount(
                                        transactionAccount
                                );

                        if (transactionTarget
                                .getTransactions()
                                .isEmpty()) {

                            System.out.println(
                                    "No transactions found."
                            );

                        } else {

                            System.out.println(
                                    "\nTransaction History"
                            );

                            System.out.println(
                                    "--------------------------------"
                            );

                            transactionTarget
                                    .getTransactions()
                                    .forEach(
                                            System.out::println
                                    );
                        }

                        break;

                    // =====================================
                    // SEARCH ACCOUNT
                    // =====================================

                    case 8:

                        System.out.print(
                                "Enter Holder Name: "
                        );

                        String searchName =
                                scanner.nextLine();

                        bank.searchByHolderName(
                                searchName
                        );

                        break;

                    // =====================================
                    // DELETE ACCOUNT
                    // =====================================

                    case 9:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String deleteNumber =
                                scanner.nextLine();

                        bank.deleteAccount(
                                deleteNumber
                        );

                        break;

                    // =====================================
                    // BANK STATISTICS
                    // =====================================

                    case 10:

                        System.out.println(
                                "\n===== BANK STATISTICS ====="
                        );

                        System.out.println(
                                "Total Accounts: "
                                        + bank.getAccountCount()
                        );

                        System.out.println(
                                "Total Bank Balance: ₹"
                                        + bank.getTotalBankBalance()
                        );

                        break;

                    // =====================================
                    // INTEREST
                    // =====================================

                    case 11:

                        System.out.print(
                                "Enter Account Number: "
                        );

                        String interestNumber =
                                scanner.nextLine();

                        Account interestAccount =
                                bank.findAccount(
                                        interestNumber
                                );

                        double interest =
                                interestAccount
                                        .calculateInterest();

                        System.out.println(
                                "Calculated Interest: ₹"
                                        + interest
                        );

                        break;

                    // =====================================
                    // EXIT
                    // =====================================

                    case 12:

                        System.out.println(
                                "\nThank you for using SmartBank!"
                        );

                        scanner.close();

                        return;

                    // =====================================
                    // INVALID CHOICE
                    // =====================================

                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (
                    AccountNotFoundException |
                    InvalidAmountException |
                    InsufficientBalanceException |
                    NumberFormatException e
            ) {

                System.out.println(
                        "\nERROR: "
                                + e.getMessage()
                );
            }
        }
    }
}