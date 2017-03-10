package week2;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        long result = 0;
        long[] sortedA = Arrays.stream(a).sorted().toArray();
        long[] sortedB = Arrays.stream(b).sorted().toArray();
        for (int i = 0; i < a.length; i++) {
            result += sortedA[i] * sortedB[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

