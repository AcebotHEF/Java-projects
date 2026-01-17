import java.util.Scanner;

public class simplebankapp {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double balance = 0;
        boolean isRunning = true;
        int choice; 

        // Display menu
        while (isRunning){
            System.out.println("__________________");
            System.out.println("BANKING PROGRAM");
            System.out.println("__________________");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("__________________");

            // Get and process the user choice
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance = Withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }
        
        System.out.println("_________________________________");
        System.out.println("Thank you! and Have a nice day!.");
        System.out.println("_________________________________");
        
        scanner.close();
    }
    static void showBalance(double balance){
        System.out.println("_________________________________");
        System.out.print("Your current balance is : ");
        System.out.printf("$%.2f \n", balance);
    }

    static double deposit(){
        double amount;
        System.out.println("_______________________________________");
        System.out.print("Enter the amount to be deposited: ");
        amount = scanner.nextDouble();
        if (amount < 0 ){
            System.out.println("Amount can't be negative");
            return 0;
        }else{
            System.out.println("____________________________________");
            System.out.print("You have successfully deposited: ");
            System.out.printf("$%.2f \n", amount);
            return amount;
        }
    }

    static double Withdraw(double balance){
        double amount;
        System.out.println("______________________________________");
        System.out.print("Enter the amount to be withdrawn: ");
        amount = scanner.nextDouble();
        if (amount > balance){
            System.out.println("INSUFFICIENT FUNDS");
            return 0;
        }
        else if(amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        }
        else{
            System.out.println("________________________________________");
            System.out.println("You have successfully withdraw $" + amount);
            balance -= amount;
            return balance;
        }
    }
}
