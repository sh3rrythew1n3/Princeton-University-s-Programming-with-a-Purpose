/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] freq = new int[args.length - 1];


        for (int a = 0; a < freq.length; a++) {
            freq[a] = Integer.parseInt(args[a + 1]);
        }

        int sum = 0;
        int[] total = new int[freq.length];
        for (int b = 0; b < freq.length; b++) {
            sum += freq[b];
            total[b] = sum;
        }

        for (int y = 0; y < m; y++) {
            int r = (int) (total[freq.length - 1] * Math.random());
            for (int c = 0; c < freq.length; c++) {
                if (r < total[c]) {
                    System.out.println(c + 1);
                    break;
                }
            }
        }
    }
}
