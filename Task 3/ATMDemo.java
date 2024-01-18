import java.util.Scanner;

class BankAccount {
   private int balance;

   public BankAccount(int initialBalance) {
       balance = initialBalance;
   }

   public int getBalance() {
       return balance;
   }

   public void withdraw(int amount) {
       if (amount > balance) {
           System.out.println("Insufficient balance");
       } else {
           balance -= amount;
           System.out.println("Withdrawal successful. New balance: " + balance);
       }
   }

   public void deposit(int amount) {
       balance += amount;
       System.out.println("Deposit successful. New balance: " + balance);
   }
}

class ATM {
   private BankAccount account;

   public ATM(BankAccount account) {
       this.account = account;
   }

   public void start() {
       Scanner scanner = new Scanner(System.in);

       while (true) {
           System.out.println("\nATM Menu:");
           System.out.println("1. Check Balance");
           System.out.println("2. Withdraw");
           System.out.println("3. Deposit");
           System.out.println("4. Exit");

           System.out.print("Enter your choice: ");
           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   System.out.println("Your balance is: " + account.getBalance());
                   break;
               case 2:
                   System.out.print("Enter amount to withdraw: ");
                   int amount = scanner.nextInt();
                   account.withdraw(amount);
                   break;
               case 3:
                   System.out.print("Enter amount to deposit: ");
                   amount = scanner.nextInt();
                   account.deposit(amount);
                   break;
               case 4:
                   System.out.println("Thank you for using the ATM.");
                   return;
               default:
                   System.out.println("Invalid choice. Please try again.");
           }
       }
   }
}

public class ATMDemo {
   public static void main(String[] args) {
       BankAccount account = new BankAccount(10000); // Initial balance
       ATM atm = new ATM(account);
       atm.start();
   }
}
