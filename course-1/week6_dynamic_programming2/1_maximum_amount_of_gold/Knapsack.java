import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int weight;
        int result[][] = new int[W + 1][w.length + 1];

        for (int i = 0; i <= w.length; i++) {
            result[0][i] = 0;
        }
        for (int j = 0; j <= W; j++) {
            result[j][0] = 0;
        }

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                result[j][i] = result[j][i - 1];
                if (w[i - 1] <= j) {
                    weight = result[j - w[i - 1]][i - 1] + w[i - 1];
                    if (weight > result[j][i]) {
                        result[j][i] = weight;
                    }
                }
            }
        }
        return result[W][w.length];
    }


    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int W, n;
            W = scanner.nextInt();
            n = scanner.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = scanner.nextInt();
            }
            System.out.println(optimalWeight(W, w));
        }
    }


