/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {


    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        boolean result = false;
        if (n < 0) result = false;
        else {
            int count = 0;
            long x = 1;
            long y = (int) Math.cbrt(n);

            while (x < y) {
                long x3 = (x * x * x);
                long y3 = (y * y * y);
                long sum = x3 + y3;
                // System.out.println(
                //  "y= " + y + "  y3 = " + y3 + " x=  " + x + "  x3=  " + x3 + " sum =  " + sum);
                if (sum < n) {
                    x = x + 1;
                    //  System.out.println("SUM < N  so new x= " + x);
                }
                else if (sum > n) {
                    y = y - 1;
                    // System.out.println("SUM > N  so new y= " + y);
                }
                else {
                    count++;
                    x = x + 1;
                    y = y - 1;
                    // System.out.println("SUM = N  || y= " + y + "  x=  " + x);
                }

                if (count >= 2) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
