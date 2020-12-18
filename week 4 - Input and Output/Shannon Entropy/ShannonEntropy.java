/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        // compute frequencies
        // freq[i] = # times integer i appears
        int[] freq = new int[m + 1];
        for (int j = 0; !StdIn.isEmpty(); j++) {
            int value = StdIn.readInt();
            freq[value]++;
        }
        int sum = 0;
        for (int n = 0; n < freq.length; n++) {
            sum += freq[n];
        }

        // compute Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            double p = freq[i];
            p = p / sum;
            if (freq[i] > 0) {
                double abs = Math.abs(p * (Math.log(p) / Math.log(2)));
                entropy += abs;
            }
        }

        // print results
        StdOut.printf("%.4f\n", entropy);

    }
}
