/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double dx = x2 - x1;
        double sinX = Math.sin(dx / 2);
        double sinX2 = Math.pow(sinX, 2);


        double dy = y2 - y1;
        double sinY = Math.sin(dy / 2);
        double sinY2 = Math.pow(sinY, 2);
        double cos = Math.cos(x1) * Math.cos(x2) * sinY2;
        double a = sinX2 + cos;
        double distance = Math.asin(Math.sqrt(a));
        System.out.println(2.0 * 6371.0 * distance + " kilometers");


    }
}
