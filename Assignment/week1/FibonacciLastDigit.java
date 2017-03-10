package week1;

import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = fibRecLastDigit(n);
        System.out.println(c);
    }

    private static int fibRecLastDigit(int n){

        if(n<2){
            return n;
        }
        int previous = 0;
        int current = 1;
        int sum =0;
        for(int i =n;i>=2;i--){
            sum = (previous + current)%10;
            previous = current;
            current = sum;
        }
        return sum;

        /*if(n==0){
            return previous;
        }
        else if(n==1){
            return current;
        }
        else{
            return fibRecLastDigit(n-1,current,(previous + current)%10);
        }*/
    }
}

