package week2;

import java.util.Scanner;

public class Change {
    private static int getChange(int m,int noOfCoins) {
        if(m>=10){
            return getChange(m%10,noOfCoins+m/10);
        }
        else if(m>=5){
            return getChange(m%5,noOfCoins+m/5);
        }
        else if(m>0){
            return getChange(m%1,noOfCoins+m/1);
        }
        else {
            return noOfCoins;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m,0));

    }
}

