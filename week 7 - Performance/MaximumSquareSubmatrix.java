/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int m = a.length;
        // System.out.println("m =  " + m);
        int counter = 0;

        int[][] quadratic = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                // System.out.println("counter =  " + counter);
                if (i == 0 || j == 0) {
                    quadratic[i][j] = a[i][j];
                    counter = Math.max(counter, quadratic[i][j]);
                }
                else if (a[i][j] > 0) {
                    quadratic[i][j] = 1 + Math
                            .min(Math.min(quadratic[i][j - 1], quadratic[i - 1][j]),
                                 quadratic[i - 1][j - 1]);
                    counter = Math.max(counter, quadratic[i][j]);
                }
                // System.out.println(
                //  "i =  " + i + "  j =  " + j + "  quadratic[i][j]=  " + quadratic[i][j]
                //  + "  counter =  " + counter);
            }
        }

        return counter;

    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(a));
    }
}
