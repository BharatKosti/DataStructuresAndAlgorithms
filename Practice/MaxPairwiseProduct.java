import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(String[] numbers) {

        int n = numbers.length;
        List<BigInteger> bigIntegerList = Arrays.stream(numbers).map(number -> new BigInteger(number)).collect(Collectors.toList());

        int maxIndex1 = 0;
        for(int i = 0; i<bigIntegerList.size();i++){
            if(bigIntegerList.get(maxIndex1).compareTo(bigIntegerList.get(i))<0){
                maxIndex1 = i;
            }
        }

        int maxIndex2 =(maxIndex1==0)?1:0;

        for(int i =0;i<bigIntegerList.size();i++){
            if(maxIndex1!=i){
                if(bigIntegerList.get(maxIndex2).compareTo(bigIntegerList.get(i))<0){
                    maxIndex2=i;
                }
            }
        }
        return bigIntegerList.get(maxIndex1).multiply(bigIntegerList.get(maxIndex2));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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