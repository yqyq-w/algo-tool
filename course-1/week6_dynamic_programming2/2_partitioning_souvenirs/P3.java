import java.util.*;
import java.io.*;

public class P3 {

    private static int partition(int[] A, int n) {
        //write your code here

        //Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);;
        //Arrays.sort(a, (n1, n2) -> n2 - n1);
        //A = Arrays.stream(a).mapToInt(Integer::valueOf).toArray();;

        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        for (int i : A) {
            if(i > sum / 3) {
                return 0;
            }
        }

        if (sum % 3 != 0 || A.length < 3) {
            return 0;
        }

        int count = 0;

       //    /*
        int result[][] = new int[sum/3 + 1][n + 1];
         for (int i = 0; i <= n; i++) {
             result[0][i] = 0;
         }
         for (int j = 0; j <= sum/3; j++) {
             result[j][0] = 0;
         }


         int weight;
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= sum/3; j++) {
                 result[j][i] = result[j][i - 1];
                 if (A[i - 1] <= j) {
                     weight = result[j - A[i - 1]][i - 1] + A[i - 1];
                     if (weight > result[j][i]) {
                         result[j][i] = weight;
                     }
                 }
                 if (result[j][i] == sum / 3) {
                     count++;
                 }
             }
         }

         //   */

         if (count < 3) {
             return 0;
         }


        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition(A, n));
    }
}

