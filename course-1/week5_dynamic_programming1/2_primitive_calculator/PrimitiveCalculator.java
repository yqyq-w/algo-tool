import java.util.*;


public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> dp_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] minOp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int add1 = 100000;
            int mul2 = 100000;
            int mul3 = 100000;

            //Integer[] opNum = {100000,100000,100000};
            // int[] op = {100000,100000,100000};
            if (i - 1 >= 0){
                add1 = minOp[i - 1] + 1;
            }
            if (i % 2 == 0) {
                mul2 = minOp[i/ 2] + 1;
            }
            if (i % 3 == 0) {
                mul3 = minOp[i / 3] + 1;
            }

          //minOp[i] = (int) Collections.min(Arrays.asList(opNum));
            minOp[i] = Math.min(add1, Math.min(mul2, mul3));
        }


        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0 && minOp[n / 3] == minOp[n] - 1) {
                n /= 3;
            } else if (n % 2 == 0 && minOp[n / 2] == minOp[n] - 1) {
                n /= 2;
            } else { // 如果有条件minOp[n - 1] == minOp[n] - 1，最后的1永远减不掉；何况条件是多余的
                n -= 1;
            }
        }

        //while (n > 1) {} 
        //sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //List<Integer> sequence = optimal_sequence(n);
        List<Integer> sequence = dp_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

