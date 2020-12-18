/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] row = new int[n];
        int[] column = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                row[i] = row[i / 2];
                column[i] = column[i / 2];
            }
            else {

                row[i] = (1 - row[i - 1]);
                column[i] = (1 - column[i - 1]);
            }
        }


        for (int b = 0; b < n; b++) {
            for (int j = 0; j < n; j++) {
                if (column[j] == row[b]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }


    }
}
