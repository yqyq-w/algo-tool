import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0;
//      int currentDist = 0;

        int[] d = new int[stops.length + 2];
        d[0] = 0;
        d[d.length - 1] = dist;
        for (int i = 0; i <= stops.length - 1; i++) {
            d[i + 1] = stops[i];
        }

        while(currentRefill < d.length - 1) {
            int lastRefill = currentRefill;
            while(currentRefill < d.length - 1
                    && d[currentRefill + 1] - d[lastRefill] <= tank) {
                currentRefill += 1;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }

            if (currentRefill < d.length -1 ) {
                numRefills += 1;
            }
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
