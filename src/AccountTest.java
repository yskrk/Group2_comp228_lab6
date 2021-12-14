
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

    public static void main(String[] args) {
        String name = "";
        double balance = 110.0;
        String transactionType = "";
        double amount = 0.0;
        Boolean isStayTransaction = true;
        Boolean isValidTransaction = false;
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        LinkedList<Transaction> transactions = new LinkedList<Transaction>();
        Scanner scanner = new Scanner(System.in);

        // account name here
        System.out.print("Input account name: ");
        name = scanner.next();

        // current balance here
        System.out.print("Input account's balance: ");
        try {
            balance = Double.parseDouble(scanner.next());

        } catch (NumberFormatException e) {
            System.out.println("Invalid value was inputted. balance is set as " + balance);
        }

        // create account
        Account account = new Account(name, balance);

        System.out.println("------------------------------");

        // loop while user enter 'execute'
        while (isStayTransaction) {
            System.out.print("Enter deposit, withdraw or execute: ");
            transactionType = scanner.next();

            switch (transactionType.toLowerCase()) {
                case "deposit":
                case "withdraw":
                    System.out.print("Enter amount of " + transactionType.toLowerCase() + ": ");
                    try {
                        amount = Double.parseDouble(scanner.next());
                        isValidTransaction = true;

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid value.");
                        isValidTransaction = false;
                    }
                    break;
                case "execute":
                    System.out.println("Execute transactions...");
                    isStayTransaction = !isStayTransaction;
                    break;
                default :
                    System.out.println("Unknown transaction.");
            }

            if (isStayTransaction && isValidTransaction) {
                // create transaction
                Transaction transaction = new Transaction(account, transactionType, amount);

                // save to arraylist (or linkedlist)
                transactions.add(transaction);

                isValidTransaction = false;
            }
        }

        System.out.println("------------------------------");

        // show result on output
        ExecutorService es = Executors.newFixedThreadPool(transactions.size());

        for (Transaction t : transactions) {
            t.run();
        }

        System.out.println("------------------------------");
        System.out.println("Finish transactions Thank you " + name + "!");
    }
}




