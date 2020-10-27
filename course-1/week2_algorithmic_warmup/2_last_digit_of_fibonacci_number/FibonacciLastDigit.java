/*
mport java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
*/


import java.util.*;
import java.lang.Math;
// import static java.lang.Math.*;
// pow()

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {

       if (n < 0 || n > Math.pow(10, 7)) {
           return -1;
       }

        int[] fib_mod = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                fib_mod[i] = i;
            } else {
                fib_mod[i] = (fib_mod[i - 1] + fib_mod[i - 2]) % 10;
            }
        }

         return fib_mod[n] ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
