
import java.util.Scanner;

interface BankingOperations {

    void createAccount(String AccHolderName, double initDeposit, int pin);

    boolean withdraw(double amount, int pin);

    void deposit(double amount, int AccNumber);

    void checkBalance(int pin);

    void printDetails(int pin);
}

abstract class Account implements BankingOperations {

    protected String AccHolderName;
    protected double balance;
    protected int AccNumber;
    protected int pin;

    public Account() {
        this.AccNumber = generateAccNumber();
    }

    protected abstract int generateAccNumber();
}

class BankAccount extends Account {

    public void createAccount(String AccHolderName, double initDeposit, int pin) {
        this.AccHolderName = AccHolderName;
        this.balance = initDeposit;
        this.pin = pin;
    }

    public boolean withdraw(double amount, int pin) {
        if (this.pin == pin) {
            if (balance >= amount) {
                System.out.println("Rs." + amount + " Withdrawn Successfully");
                return true;
            } else {
                System.out.println("Insufficient balance");
                return false;
            }
        } else {
            System.out.println("Invalid Pin");
            return false;
        }
    }

    public void deposit(double amount, int AccNumber) {
        if (this.AccNumber == AccNumber) {
            this.balance += amount;
            System.out.println("Rs." + amount + " Deposited Successfully to Account: " + this.AccNumber);
            return;
        } else {
            System.out.println("Invalid Account Number");
        }
    }

    public void checkBalance(int pin) {
        if (this.pin == pin) {
            System.out.println("Account Holder: " + this.AccHolderName);
            System.out.println("Account Number: " + this.AccNumber);
            System.out.println("Balance: Rs." + this.balance);
            return;
        } else {
            System.out.println("Invalid Pin Try Again");
            return;
        }
    }

    public void printDetails(int pin1) {
        if (this.pin == pin1) {
            System.out.println("Account Holder: " + this.AccHolderName);
            System.out.println("Account Number: " + this.AccNumber);
            System.out.println("Balance: Rs." + this.balance);
            return;
        } else {
            System.out.println("Invalid Pin Try Again");
            return;
        }
    }

    public int generateAccNumber() {

        return (int) (Math.random() * 100000);
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\nWelcome to Alliance Bank\n");
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        BankAccount obj = new BankAccount();

        while (run) {

            System.out.println("How can We Help You?\nSelect options 1,2,3,4,5,6");
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Print Details\n6. Exit");
            System.out.print("Enter a Number: ");
            int choice = sc.nextInt();
            int pin1;

            // obj.AccHolderName = "hdhdhd";
            // obj.createAccount("3222",2222,1111);
            // obj.checkBalance(1111);
            switch (choice) {
                case 1:
                    String accHolder;
                    double deposit;
                    System.out.print("Enter the Account holder Name: ");
                    accHolder = sc.next();
                    System.out.print("Enter the initial Deposit amount: ");
                    deposit = sc.nextDouble();
                    System.out.println("Set the PIN Number (a Four Digit Number)");
                    int pin2;
                    pin1 = sc.nextInt();
                    if (!(pin1 > 999 && pin1 < 10000)) {
                        System.out.println("Enter a valid Pin");
                    } else {
                        System.out.print("Enter a confirm Pin: ");
                        pin2 = sc.nextInt();
                        if (pin1 == pin2) {
                            obj.createAccount(accHolder, deposit, pin1);
                        } else {
                            System.out.println("Enter a same pin");
                        }
                        System.out.println("Account Created Successfully");
                    }
                    break;

                case 5:

                    // obj.checkBalance(pin1);
                    System.out.print("Enter Account Pin: ");
                    pin1 = sc.nextInt();
                    obj.printDetails(pin1);
                    break;

                case 6:
                    System.out.println("Press 1 to Exit or anyother Key to continue");
                    int val = sc.nextInt();
                    if (val == 1) {
                        run = false;
                    }
                    break;

                default:
                    break;
            }
        }
    }

}
