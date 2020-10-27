/*
import java.util.Scanner;


public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
*/

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {

        if (n < 0 || n > 45) {
            return -1;
        }

        long[] fib_arr = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                fib_arr[i] = i;
            } else {
                fib_arr[i] = fib_arr[i - 1] + fib_arr[i - 2];
            }
        }

        return fib_arr[n];

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}