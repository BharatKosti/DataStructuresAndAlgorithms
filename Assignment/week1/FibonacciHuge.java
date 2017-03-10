package week1;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    private static long findPisanoPeriod(long n, long m) {

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
            if(patternRepeatAt(previous,current)){
                return i+1;
            }
        }

        return m;
    }

    private static BigInteger fibRec(Long n){
        if(n<2){
            return BigInteger.valueOf(n);
        }
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger sum =BigInteger.ZERO;
        for(long i =n;i>=2;i--){
            sum = (previous.add(current));
            previous = current;
            current = sum;
        }
        return sum;
    }

    private static boolean patternRepeatAt(long previous,long current){
        return previous==0 && current==1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        if (n >= 2){
            long fibonacciHugeNaive = findPisanoPeriod(n, m);
            long x = n;
            if(m!=fibonacciHugeNaive){
                x = n % fibonacciHugeNaive;
            }
            BigInteger bigIntegers = fibRec(x);
            BigInteger[] x1 = bigIntegers.divideAndRemainder(BigInteger.valueOf(m));
            System.out.println(x1[1]);
        }
        else{
            System.out.println(n);
        }
    }
}

