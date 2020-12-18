/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amplified = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amplified[i] = a[i] * alpha;
        }
        return amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        int backwards = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[i] = a[backwards];
            backwards--;
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] joined = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            joined[i] = a[i];
        }
        int j = a.length;
        for (int n = 0; j < joined.length; n++) {
            joined[j] = b[n];
            j++;
        }
        return joined;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int aa = a.length;
        int bb = b.length;
        if (bb > aa) {
            double[] newA = new double[bb];
            for (int j = 0; j < aa; j++) {
                newA[j] = a[j];
            }

            double[] remixed = new double[bb];
            for (int i = 0; i < bb; i++) {
                remixed[i] = b[i] + newA[i];
            }
            return remixed;
        }
        else {
            double[] newB = new double[aa];
            for (int j = 0; j < bb; j++) {
                newB[j] = b[j];
            }

            double[] remixed = new double[aa];
            for (int i = 0; i < aa; i++) {
                remixed[i] = a[i] + newB[i];
            }
            return remixed;
        }

    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        if (alpha == 1 / 137) {
            int y = (a.length / 137);
            double[] resample = new double[y + 1];
            for (int i = 0; i < y; i++) {
                int x = (int) Math.round(i * alpha);
                resample[i] = a[x];
            }
            return resample;
        }
        else {
            int y = (int) (a.length / alpha);
            double[] resample = new double[y];
            for (int i = 0; i < y; i++) {
                int x = (int) (i * alpha);
                resample[i] = a[x];
            }
            return resample;
        }
    }

    public static void main(String[] args) {
        double[] samples = StdAudio.read("beatbox.wav");
        double alpha = 1 / 137;
        amplify(samples, alpha);
        double[] samples2 = StdAudio.read("singer.wav");
        double[] b = reverse(samples2);
        double[] samples3 = StdAudio.read("chimes.wav");
        double[] samples4 = StdAudio.read("harp.wav");
        merge(samples3, samples4);
        mix(samples, samples4);
        double[] samples5 = StdAudio.read("exposure.wav");
        changeSpeed(samples5, alpha);
        StdAudio.play(b);

    }
}
