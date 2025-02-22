
import java.util.Scanner;

interface banker {

    void createAccount(String name, double initialDeposit);

    void deposit(double amount);

    void withdraw(double amount);

    void checkBalance();
}

abstract class account implements banker {

    protected string name;
    protected double balance;
    protected int accountNumber;
    protected int pin;

    public account() {
        this.accountNumber = generateaccountNumber();
    }

    abstract int generateaccountNumber();

}

class bankaccount extends account {

    public void createAccount(String name, double initialDeposit, int pin) {
        this.name = name;
        this.balance = initialDeposit;
        this.pin = pin;
    }

    public boolean withdraw(int amount, int pin) {
        if (this.pin == pin) {
            if (this.balance >= amount) {
                this.balance -= amount;
                system.out.println("Rs.W" + amount
                "ithdrawal successful");
                return true;
            } else {
                System.out.println("Insufficient balance");
                return false;
            }
        } else {
            System.out.println("Invalid pin");
            return false;
        }
    }

    public void deposit(double amount, int accountNumber) {
        if (this.accountNumber == accountNumber) {
            this.balance += amount;
            System.out.println("Rs.W" + amount + "deposited successfully");
        } else {
            System.out.println("Invalid account number");
        }
    }

    public void checkBalance(int pin) {
        if (this.pin == pin) {
            System.out.println("Name:" + this.name);
            System.out.println("account number:" + this.accountNumber);
            System.out.println("Your balance is Rs." + this.balance);
        } else {
            System.out.println("Invalid pin");
        }
    }

    public void printdetails() {
        if (this.pin == pin) {
            System.out.println("Name:" + this.name);
            System.out.println("Account number:" + this.accountNumber);
            System.out.println("Balance:" + this.balance);
        } else {
            System.out.println("Invalid pin");
        }
    }

    public int generateaccountNumber() {
        return (int) (Math.random() * 10000);
    }
}

public class banker {

    public static void main(String[] args) {
        scanner sc = new scanner(System.in);
        bankaccount b = new bankaccount();
        while (true) {
            System.out.println("1.Create account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check balance");
            System.out.println("5.Print details");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the initial deposit:");
                    double initialDeposit = sc.nextDouble();
                    System.out.println("Enter the pin:");
                    int pin = sc.nextInt();
                    b.createAccount(name, initialDeposit, pin);
                    break;
                case 2:
                    System.out.println("Enter the account number:");
                    int accountNumber = sc.nextInt();
                    System.out.println("Enter the amount to be deposited:");
                    double amount = sc.nextDouble();
                    b.deposit(amount, accountNumber);
                    break;
                case 3:
                    System.out.println("Enter the amount to be withdrawn:");
                    double amount = sc.nextDouble();
                    System.out.println("Enter the pin:");
                    int pin = sc.nextInt();
                    b.withdraw(amount, pin);
                    break;
                case 4:
                    System.out.println("Enter the pin:");
                    int pin = sc.nextInt();
                    b.checkBalance(pin);
                    break;
                case 5:
                    System.out.println("Enter the pin:");
                    int pin = sc.nextInt();
                    b.printdetails(pin);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
