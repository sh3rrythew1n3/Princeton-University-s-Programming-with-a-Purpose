/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        boolean pos;

        // interger must be positive
        pos = (a > 0) && (b > 0) && (c > 0);

        boolean squared;

        // sum of the squares of the two of the integers must equal the square of the third integer
        squared = ((a * a) + (b * b) == (c * c)) || ((a * a) + (c * c) == (b * b)) || (
                (b * b) + (c * c) == (a * a));

        boolean theorem;
        theorem = pos && squared;

        System.out.println(theorem);
    }
}
