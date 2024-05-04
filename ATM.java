import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw funds from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
            return false;
        }
    }

    // Method to check the balance of the account
    public double checkBalance() {
        return balance;
    }
}

// ATM class represents the ATM machine
public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle user options
    public void handleOption(int option) {
        switch (option) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Please take your cash.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Current balance: " + bankAccount.checkBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Main method to run the ATM
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.handleOption(choice);
        }
    }
}
