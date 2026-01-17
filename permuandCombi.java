import java.util.*;

public class permuandCombi {

    static int facto(int a){
        if (a == 0 || a == 1){
            return 1;
        }else{
            return a * facto(a-1);
        }
    }

    static int permu(int n, int r){
        return facto(n)/(facto(n-r));
    }

    static int combi(int n, int r){
        return facto(n)/(facto(n-r) * facto(r));
    }



    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number (n): ");
        int n = input.nextInt();
        System.out.print("Please enter a number (r): ");
        int r = input.nextInt();
        int num = facto(n);
        System.out.println("Factorial of "+ n + " is " + num);
        int num1 = facto(r);
        System.out.println("Factorial of "+ r + " is " + num1);

        int permuta = permu(n,r);
        System.out.println(n + "P" + r + " = " + permuta);
        int combina = combi(n,r);
        System.out.println(n + "C" + r + " = " + combina);

        input.close();
    }
    
}
