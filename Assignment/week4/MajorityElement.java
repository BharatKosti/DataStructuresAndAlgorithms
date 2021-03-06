//package week4;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        /*if (left == right) {*/
        /*    return -1;*/
        /*}*/
        /*if (left + 1 == right) {*/
        /*    return a[left];*/
        /*}*/
        /**/
        /*return -1;*/
        int[] aSorted = Arrays.stream(a).sorted().toArray();
        int count =0;
        int target = a.length/2;
        for(int i=0;i<aSorted.length-1;i++){
            if(aSorted[i]==aSorted[i+1]){
                   count=count+1;
                   if(count==target){
                       return aSorted[i];
                   }
            }
            else{
                count = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

