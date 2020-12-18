/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[] array1d = new boolean[m * n];
        int[][] together = new int[m + 2][n + 2];
        boolean[][] mines = new boolean[m + 2][n + 2];
        int bomb = 0;
        int product = m * n;

        if (k >= (product)) {
            for (int a = 1; a <= m; a++) {
                for (int b = 1; b <= n; b++) {
                    System.out.print("*  ");
                }
                System.out.println();
            }
        }


        if (k < (product)) {
            for (int i = 0; i < k; i++) {
                do {
                    bomb = (int) (Math.random() * (m * n));
                } while (array1d[bomb]);
                array1d[bomb] = true;
            }
            int row = 1;
            int column = 1;
            for (int f = 0; f < m; f++) {
                for (int j = 0; j < n; j++) {
                    column = j + 1;
                    mines[row][column] = array1d[(f * n) + j];
                    if (mines[row][column]) {
                        together[row + 1][column + 1] += 1;
                        together[row][column + 1] += 1;
                        together[row + 1][column] += 1;
                        together[row - 1][column - 1] += 1;
                        together[row][column - 1] += 1;
                        together[row - 1][column] += 1;
                        together[row - 1][column + 1] += 1;
                        together[row + 1][column - 1] += 1;
                    }
                }
                row++;
            }


            for (int a = 1; a <= m; a++) {
                for (int b = 1; b <= n; b++) {
                    if (mines[a][b] != false)
                        System.out.print("*  ");
                    else
                        System.out.print(together[a][b] + "  ");
                }
                System.out.println();
            }
        }

    }

}

