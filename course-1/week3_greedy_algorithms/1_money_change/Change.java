import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        /*
        int count = 0;
        int current_remain = m;
        int[] coins = {10, 5, 1};

        for (int i : coins){
            count += (current_remain / i);
            current_remain %= i;
        }
        return count;
        */

        return   m / 10 + m % 10 / 5 + m % 10 % 5;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

