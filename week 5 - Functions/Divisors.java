/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            a = b;
            return a;
        }
        else if (b == 0) {
            return a;
        }
        else {
            if (b > a) {
                int t = b;
                b = a;
                a = t;
            }

            int remainder;
            while (true) {
                remainder = a % b;
                a = b;
                b = remainder;
                if (remainder == 0) break;
            }
            return a;
        }

    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) return 0;
        else {
            if (b > a) {
                int t = b;
                b = a;
                a = t;
            }
            int lmc = a / gcd(a, b);
            lmc = lmc * b;
            return lmc;
        }
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        boolean prime;
        if (gcd(a, b) == 1) prime = true;
        else prime = false;
        return prime;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) return 0;
        else {
            int result = 1;
            for (int i = 2; i < n; i++) {
                if (areRelativelyPrime(n, i)) result++;
            }
            return result;
        }
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int answer1 = gcd(a, b);
        System.out.println("gcd(" + a + ", " + b + ") = " + answer1);
        int answer2 = lcm(a, b);
        System.out.println("lcm(" + a + ", " + b + ") = " + answer2);
        boolean answer3 = areRelativelyPrime(a, b);
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + answer3);
        int answer4 = totient(a);
        System.out.println("totient(" + a + ") = " + answer4);
        int answer5 = totient(b);
        System.out.println("totient(" + b + ") = " + answer5);
    }
}

