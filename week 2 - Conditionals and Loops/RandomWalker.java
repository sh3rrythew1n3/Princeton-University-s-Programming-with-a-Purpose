/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;

        int step = 0;

        System.out.println("(" + x + ", " + y + ")");

        while ((Math.abs(x) + Math.abs(y)) != r) {
            double prob = Math.random();
            step++;
            {
                if (prob < 0.25) x++;
                else if (0.50 > prob) x--;
                else if (0.75 > prob) y++;
                else if (1 > prob) y--;
            }

            System.out.println("(" + x + ", " + y + ")");
        }

        System.out.println("steps = " + step);

    }
}
