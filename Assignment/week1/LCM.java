package week1;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  public static int gcd(int a, int b){

    if(b==0){
      return a;
    }
    else{
      return gcd(b,a%b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println((new Long(a)*new Long(b))/gcd(a, b));
  }
}
