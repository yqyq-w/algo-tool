import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] coins) {
        //write your code here
        int[] minNumCoins = new int[money + 1];
        minNumCoins[0] = 0;

        int currentNum = 0;
        for (int m = 1; m <= money; m++) {
            minNumCoins[m] = 1001;
            for (int coin : coins) {
                if (m >= coin) {
                    currentNum = minNumCoins[m - coin] + 1;
                    if (currentNum < minNumCoins[m]) {
                        minNumCoins[m] = currentNum;
                    }
                }
            }
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = {1, 3, 4};
        System.out.println(getChange(m, coins));

    }
}

