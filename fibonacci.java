import java.util.Scanner;

public class fibonacci {

    public static int fibonaccis(int n){
        if (n == 0){
            return 0;
        }else if (n==1) {
            return 0;
        } 
        else if (n==2) {
            return 1;   
        }
        else{
            return fibonaccis(n-1) + fibonaccis(n-2);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner for reading input 
        System.out.print("Please enter the nth term of the fibonacci series: ");
        int n = scanner.nextInt();
        int fibonacciOfN = fibonaccis(n); // for the fibonacci series 
        System.out.println("The fibonacci " + n + "th term is : " + fibonacciOfN);


        int n1 = 0, n2 = 1;
        System.out.print("Fibonacci Series of the "+ n + "th term of the fibonacci series is : " + n1 + " " + n2);

        for (int i =3; i<=n; i++){
            int next = n1 + n2;
            System.out.print(" " + next);
            n1 = n2;
            n2 = next;
        }

        scanner.close(); // to close the scanner
    }
    }
    
