/*
import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
*/


import java.util.*;
import java.lang.Math;

public class GCD {
    private static int gcd_euclid(int a, int b) {

        if (a < 1 || b > 2 * Math.pow(10,9)) {
            return -1;
        }
        
        /*
        // Max time used: 0.46/1.50, max memory used: 27688960/536870912.
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        */

        if(b == 0) {
            return a;
        }
        return gcd_euclid(b, Math.abs(a % b));
        // Max time used: 0.09/1.50, max memory used: 28372992/536870912.


    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_euclid(a, b));
    }
}





