/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int exp = 0;
        double c = 0.0;
        double average = 1.0;

        while (exp < trials) {
            exp++;
            double step = 0.0;
            int x = 0;
            int y = 0;

            while ((Math.abs(x) + Math.abs(y)) != r) {
                double prob = Math.random();
                step++;
                {
                    if (prob < 0.25) x++;
                    else if (0.50 > prob) x--;
                    else if (0.75 > prob) y++;
                    else if (1 > prob) y--;
                }
            }
            c = step + c;
        }

        average = c / trials;
        System.out.println("average number of steps = " + average);

    }
}
