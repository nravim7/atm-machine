package atm;

import java.util.Scanner;

public class ATM {

    private double balance;
    private final int pin = 12345;

    public ATM() {
        welcome();
    }

    Scanner sc = new Scanner(System.in);
    public void welcome() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        if (this.pin == sc.nextInt()) {
            menu();
        } else {
            System.out.println("Invalid pin");
                welcome();
        }
    }

    private void menu() {
        System.out.println("Press 1 for balance, 2 for withdraw money, " +
                "3 for deposit, 4 for exit");

        switch (sc.nextInt()) {
            case 1 -> fetchBalance();
            case 2 -> withDraw();
            case 3 -> deposit();
            case 4 -> exitAtm();
            default -> System.out.println("Invalid key");
        }
    }

    private void exitAtm() {
        System.out.println("Thank you for visiting us!!!");
    }

    private void deposit() {
        System.out.println("Enter amount to deposit");
        double amount = sc.nextDouble();
        this.balance += amount;
        System.out.println("$" + amount + " is credited, Remaining is $" + this.balance);
        menu();
    }

    private void withDraw() {
        System.out.println("Enter amount to with draw");
        double amount = sc.nextDouble();
        if (this.balance - amount < 0) {
            System.out.println("Insufficient balance");
        } else {
           this.balance -= amount;
            System.out.println("$" + amount + " is debited, Remaining is $" + this.balance);
        }
        menu();
    }

    private void fetchBalance() {
        System.out.println("Account balance is $" + this.balance);
        menu();
    }
}
