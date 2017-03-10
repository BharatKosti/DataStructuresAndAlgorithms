package week1;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by bharatkosti on 1/24/17.
 */
public class Fibonacci {

    public static void main(String[] args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        Long n = sc.nextLong();
        List<BigInteger> bigIntegers = fibRec(n, new ArrayList<>(), 0);
        for(BigInteger b : bigIntegers){
            System.out.println(b);
        }
    }

    public static List<BigInteger> fibRec(Long n,List<BigInteger> fibSequence,int index){
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
}
