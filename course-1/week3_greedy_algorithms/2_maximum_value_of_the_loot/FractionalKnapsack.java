import java.util.Scanner;

public class FractionalKnapsack {


    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        //write your code here
        //?? got NaN in IntelliJ 
        for (int i = 0; i < values.length; i++){
            if(capacity != 0){
                int maxIndex = getIndexOfMaxUnitValue(values, weights);
                int a = Math.min(weights[maxIndex], capacity);
                value += a * (double) values[maxIndex] / weights[maxIndex];
                weights[maxIndex] -= a;
                capacity -= a;
            }
        }
        return value;


        /*
        //?? got NaN in IntelliJ for
        3 50
        60 20
        100 50
        120 30

        for (int i = 0; i < values.length; i++){
            if (capacity == 0)
                return value;

            int maxIndex = getIndexOfMaxUnitValue(values, weights);
            int a = Math.min(weights[maxIndex], capacity);
            value += a * (double) values[maxIndex] / weights[maxIndex];
            weights[maxIndex] -= a;
            capacity -= a;
        }
        return value;
        */


        /*
        // 注：while (capacity != 0) 可能无法跳出循环 
        // time limit exceeded  
        // 比如 已经装了所有东西，但背包还是空的
        // capacity != 0 &&  重量之和 != 0
        while (capacity != 0){
            int maxIndex = getIndexOfMaxUnitValue(values, weights);
            double a = Math.min(weights[maxIndex], capacity);
            value += a * (double) values[maxIndex] / weights[maxIndex];
            weights[maxIndex] -= a;
            capacity -= a;
       }
        return value;
         */



    }

    private static int getIndexOfMaxUnitValue(int[] values, int[] weights) {
        int maxIndex = 0;
        double maxUnitValue = 0;

        for (int i = 0; i < weights.length; i++){
            if (weights[i] > 0 && (double) values[i] / weights[i] > maxUnitValue) {
                maxUnitValue = (double) values[i] / weights[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
