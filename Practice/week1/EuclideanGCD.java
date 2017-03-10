package week1;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by bharatkosti on 1/25/17.
 */
public class EuclideanGCD {

    public static void main(String[] args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        System.out.println(" Enter the numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b));

    }

    public static int gcd(int a, int b){

        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}
