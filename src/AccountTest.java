import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AccountTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        Account account1 = new Account(1001, "John Smith", 500);
        executor.execute(account1);

        Account account2 = new Account(1234, "Akino Kashima", 800);
        executor.execute(account2);

        Account account3 = new Account(2871, "Yusuke Kuroki", 200);
        executor.execute(account3);

        Account account4 = new Account(3571, "Katie Monahan", 300);
        executor.execute(account4);


        Transaction transaction1 = new Transaction(account1,"withdraw", 800 );
        executor.execute(transaction1);

        Transaction transaction2 = new Transaction(account1,"deposit", 0);
        executor.execute(transaction2);

        Transaction transaction3 = new Transaction(account1,"withdraw", 500);
        executor.execute(transaction3);

        Transaction transaction4 = new Transaction(account1,"deposit", 700);
        executor.execute(transaction4);



    }

}




