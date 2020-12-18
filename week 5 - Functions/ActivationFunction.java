/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double a = 0.0;
        if (x == Double.POSITIVE_INFINITY) a = 1.0;
        else if (x == Double.NEGATIVE_INFINITY) a = 0.0;
        else if (Double.isNaN(x)) a = Double.NaN;
        else {
            if (x < 0) a = 0;
            else if (x == 0) a = 0.5;
            else if (x > 0) a = 1;
        }
        return a;
    }


    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double sigma = (1 + Math.exp(-x));
        sigma = 1 / sigma;
        return sigma;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double tanh;
        if (x >= 20) tanh = 1;
        else if (x <= -20) tanh = -1.0;
        else {
            tanh = Math.exp(x) - Math.exp(-x);
            tanh = tanh / (Math.exp(x) + Math.exp(-x));
        }
        return tanh;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        double f = 0;
        if (x == Double.POSITIVE_INFINITY) f = 1;
        else if (x == Double.NEGATIVE_INFINITY) f = -1;
        else {
            f = 1 + Math.abs(x);
            f = x / f;
        }
        return f;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double a = 0.0;
        if (x == Double.POSITIVE_INFINITY) a = 1.0;
        else if (x == Double.NEGATIVE_INFINITY) a = -1.0;
        else if (Double.isNaN(x)) a = Double.NaN;
        else {
            if (x <= -2) a = -1;
            else if (0 <= x && x < 2) {
                a = Math.pow(x, 2) / 4;
                a = x - a;
            }
            else if (x < 0 && -2 < x) {
                a = Math.pow(x, 2) / 4;
                a = x + a;
            }
            else if (x >= 2) a = 1;
        }
        return a;
    }

    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);
        if (Double.isNaN(input)) {
            System.out.println("heaviside(" + input + ") = NaN");
            System.out.println("  sigmoid(" + input + ") = NaN");
            System.out.println("     tanh(" + input + ") = NaN");
            System.out.println(" softsign(" + input + ") = NaN");
            System.out.println("     sqnl(" + input + ") = NaN");
        }
        else {
            double answer1 = heaviside(input);
            System.out.println("heaviside(" + input + ") = " + answer1);

            double answer2 = sigmoid(input);
            System.out.println("  sigmoid(" + input + ") = " + answer2);

            double answer3 = tanh(input);
            System.out.println("     tanh(" + input + ") = " + answer3);

            double answer4 = softsign(input);
            System.out.println(" softsign(" + input + ") = " + answer4);

            double answer5 = sqnl(input);
            System.out.println("     sqnl(" + input + ") = " + answer5);
        }
    }
}
