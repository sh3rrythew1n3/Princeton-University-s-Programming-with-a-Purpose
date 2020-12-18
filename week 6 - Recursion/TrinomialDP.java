/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        else {
            k = Math.abs(k);
            int length;
            if (k > n) length = k;
            else length = n;
            int column = length + 2;
            long[][] tri = new long[length][column];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < column; j++) {
                    if (i == 0 && j == 0) tri[0][0] = 1;
                    else if (j < -i || j > i) {
                        tri[i][j] = 0;
                    }
                    else {
                        tri[i][j] = tri[i - 1][Math.abs(j - 1)] + tri[i - 1][j] + tri[i - 1][j + 1];
                    }
                }
            }


            return tri[n - 1][Math.abs(k - 1)] + tri[n - 1][k] + tri[n - 1][k + 1];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}
