/*
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
*/



import java.util.*;

public class LCM {
    //  lmc =  (a * b) / gcd
    private static long gcd_euclid(long a, long b) {
        if (a < 1 || b > 2 * Math.pow(10,9))
            return -1;
        if(b == 0)
            return a;
        return gcd_euclid(b, Math.abs(a % b));
    }

    private static long lcm(int a, int b) {
        return (long) a * b / gcd_euclid(a, b);

     /*
        for (long l = 1; l <= (long) a * b; ++l)
            if ((l * a) % b == 0)
                return l * a;
        return (long) a * b;
        */
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
