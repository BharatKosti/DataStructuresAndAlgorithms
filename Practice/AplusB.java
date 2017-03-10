import java.util.Scanner;

class AplusB {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    if(0<=a && a<=9 && 0<=b && b<=9){
      System.out.println((a + b));
    }
    else {
      throw new IllegalArgumentException("");
    }
  }
}