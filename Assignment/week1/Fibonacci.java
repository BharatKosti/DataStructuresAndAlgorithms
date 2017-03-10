package week1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static List<BigInteger> fibRec(Long n, List<BigInteger> fibSequence, int index){
    if(index>n){
      return fibSequence;
    }
    if(index<2){
      fibSequence.add(BigInteger.valueOf(index));
      return fibRec(n,fibSequence,index+1);
    }
    else{
      fibSequence.add(fibSequence.get(index-1).add(fibSequence.get(index-2)));
      return fibRec(n,fibSequence,index+1);
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    List<BigInteger> bigIntegers = fibRec(new Long(n), new ArrayList<>(), 0);
    System.out.println(bigIntegers.get(n));
  }
}
