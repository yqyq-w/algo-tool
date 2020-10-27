import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        int n = s.length();
        int m = t.length();
        int[][] distance = new int[n + 1][m + 1];
        int insertion;
        int deletion;
        int mismatch;
        int match;
        //Integer[] idmm = new Integer[4];
        for (int i = 0; i <= n; i++){
            distance[i][0] = i;
        }
        for (int j = 0; j <= m; j++){
            distance[0][j] = j;
        }

        for (int j = 1; j <= m; j++) {
            for(int i = 1; i <= n; i++) {
                insertion = distance[i][j - 1] + 1;
                deletion = distance[i - 1][j] + 1;
                mismatch = distance[i - 1][j - 1] + 1;
                match = distance[i - 1][j - 1];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    distance[i][j] = Math.min(match, Math.min(insertion, deletion));
                } else {
                    distance[i][j] = Math.min(mismatch, Math.min(insertion, deletion));
                }
            }
        }

        return distance[n][m];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
