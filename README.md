🏦 SmartBank – Core Java Banking Management System



SmartBank is a console-based banking management system developed using Core Java. The project demonstrates object-oriented programming, collections, exception handling, Java 8 features, date-time handling, and layered application design.



🚀 Features



Create Savings Account



Create Current Account



Display all accounts



Deposit money



Withdraw money



Transfer money between accounts



Check account balance



View transaction history



Search account by holder name



Delete account



Calculate account interest



Display bank statistics



Input validation



Custom exception handling



🛠️ Technologies Used



Java



Core Java



OOP



Collections Framework



Java 8 Stream API



Lambda Expressions



Exception Handling



Java Date-Time API



Git



GitHub



📂 Project Structure



smartbank-core-java/

│

├── src/

│   ├── model/

│   │   ├── Account.java

│   │   ├── SavingsAccount.java

│   │   ├── CurrentAccount.java

│   │   └── Transaction.java

│   │

│   ├── service/

│   │   ├── TransactionService.java

│   │   └── BankService.java

│   │

│   ├── exception/

│   │   ├── AccountNotFoundException.java

│   │   ├── InsufficientBalanceException.java

│   │   └── InvalidAmountException.java

│   │

│   └── Main.java

│

├── screenshots/

├── .gitignore

└── README.md



🧠 Core Java Concepts Demonstrated



Concept



Implementation



Encapsulation



Private fields and controlled methods



Abstraction



Abstract Account class



Inheritance



SavingsAccount and CurrentAccount



Polymorphism



calculateInterest()



Interface



TransactionService



Collections



HashMap, ArrayList



Exception Handling



Custom exceptions



Lambda Expressions



forEach()



Stream API



Account search and statistics



Date-Time API



LocalDateTime



🏗️ Architecture



&#x20;             SmartBank

&#x20;                 │

&#x20;         ┌───────┴────────┐

&#x20;         │                │

&#x20;      Model             Service

&#x20;         │                │

&#x20;     Account        BankService

&#x20;         │                │

&#x20;  ┌──────┴──────┐   TransactionService

&#x20;  │             │

Savings       Current

Account       Account

&#x20;         │

&#x20;         ↓

&#x20;    Transaction



▶️ How to Run



1\. Clone the repository



git clone https://github.com/YOUR\_USERNAME/smartbank-core-java.git



2\. Open the project



Open the project in IntelliJ IDEA, Eclipse, or VS Code.



3\. Compile the project



javac -d out src/model/\*.java src/exception/\*.java src/service/\*.java src/Main.java



4\. Run the application



java -cp out Main



💻 Sample Menu



================================

&#x20;         SMART BANK

================================

1\. Display All Accounts

2\. Create Account

3\. Deposit

4\. Withdraw

5\. Transfer Money

6\. Check Balance

7\. Transaction History

8\. Search Account

9\. Delete Account

10\. Bank Statistics

11\. Calculate Interest

12\. Exit

================================

Enter choice:



🔮 Future Enhancements



File-based data persistence



Customer login and PIN authentication



JDBC/MySQL database integration



JUnit testing



Transaction reports



Admin module



Spring Boot REST API



Web-based frontend



👩‍💻 Author



Jeyashree S



Java Full Stack Developer | Software Trainer



GitHub: https://github.com/Dev-Jeyashree



LinkedIn: https://linkedin.com/in/dev-jeyashree



⭐ If you find this project useful, consider giving the repository a star.

