public class Account extends Thread {

    private String accountName;
    private double balance;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    // Withdraw transaction
    public synchronized void withdraw(double withdrawAmount) {
        System.out.println("Account Name : " + accountName + "\nWithdrawal Amount : $" + withdrawAmount);
        try {
            if (balance >= withdrawAmount) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                balance = balance - withdrawAmount;
                System.out.println("Account Name : " + accountName + "\nCurrent balance : $" + balance + "\n");
            } else {
                System.out.println("The account holder does not have enough balance.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deposit transaction
    public synchronized void deposit(double depositAmount) {
        System.out.println("Account Name : $" + accountName + "\nDeposit Amount : $" + depositAmount);
        try {
            if (depositAmount > 0) {
                try {
                    Thread.sleep(500);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                balance += depositAmount;
                System.out.println("Account Name : " + accountName + "\nCurrent balance : $" + balance + "\n");
            } else {
                System.out.println("Please check the deposit amount. \n");
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
