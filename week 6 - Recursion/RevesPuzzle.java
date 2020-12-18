/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    private static void reves(int n, String from_rod,
                              String to_rod, String aux_rod1,
                              String aux_rod2) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disc " + n +
                                       " from " + from_rod +
                                       " to " + to_rod);
            return;
        }

        reves(n - 2, from_rod, aux_rod1, aux_rod2,
              to_rod);
        System.out.println("Move disc " + (n - 1) +
                                   " from " + from_rod +
                                   " to " + aux_rod2);
        System.out.println("Move disc " + n +
                                   " from " + from_rod +
                                   " to " + to_rod);
        System.out.println("Move disc " + (n - 1) +
                                   " from " + aux_rod2 +
                                   " to " + to_rod);
        // reves(n - 2, aux_rod1, to_rod, from_rod, aux_rod2);
        reves(n - 2, aux_rod1, to_rod, aux_rod2, from_rod);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "D", "B", "C");

    }
}
