/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double r = Double.parseDouble(args[1]);
        double c = 0.0;

        for (int i = 1; i <= n; i++) {
            {
                double b = Math.pow(i, r);
                double a = 1.0 / b;
                c += a;
            }
        }

        System.out.println(c);
    }
}
