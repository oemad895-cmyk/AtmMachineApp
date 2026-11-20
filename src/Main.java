import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int Pin;
        int CorrectPin = 1234;
        int TotalAttempts = 3;
        int Attempts = 0;
        double IntitalBalance = 2500.75;
        int DepositCount = 0;
        int WithdrawAmount = 0;


        Boolean Islogged = false;

        Scanner scan = new Scanner(System.in);

        while (Attempts < 3) {
            Pin = scan.nextInt();

            if (Pin == CorrectPin) {
                Islogged = true;
                System.out.println("Logged successfully");
                System.out.println("Your initial balance is " + IntitalBalance);
                break;

            } else {
                Attempts++;

                if (Attempts == 3) {
                    System.out.println("Your account has been locked.");
                } else {
                    System.out.println("Wrong PIN. Try again.");
                    System.out.println("Remaining attempts: " + (TotalAttempts - Attempts));
                }
            }
        }
        if (Islogged) {
            System.out.println("Choose from the menu");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Check Balance " + "" + IntitalBalance);
                    break;
                case 2:
                    double DepositAmount = scan.nextDouble();
                    if (DepositAmount > 0) {
                        IntitalBalance += DepositAmount;
                        DepositCount++;
                        System.out.println("Current Balance " + IntitalBalance);
                        System.out.println(" Total deposits: "  + DepositCount );
                    } else {
                        System.out.println("Invalid Amount");
                    }
                    break;
                case 3:
                    double WithDrawdAmount = scan.nextDouble();
                if (WithDrawdAmount > 0 && WithDrawdAmount <= IntitalBalance) {
                    IntitalBalance -= WithDrawdAmount;
                    WithdrawAmount++;
                    System.out.println("Total withdraws: " + WithdrawAmount );
                    System.out.println("Current balance: " + IntitalBalance);
                    if (IntitalBalance == 0) {
                        System.out.println("Warning: Your account is empty.");
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                    break;

                case 4:
                    if (IntitalBalance >= 5000) {
                        System.out.println("VIP Customer");

                    } else if (IntitalBalance > 1000 && IntitalBalance < 4999.99) {
                        System.out.println("Regular Customer");
                    } else {
                        System.out.println("Low Balance");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}

