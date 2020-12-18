/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        String b = "0  ";
        String a = "*  ";


        for (int i = 0; i < n; i++) {
            {
                for (int y = 0; y < n; y++) {
                    if (Math.abs(i - y) <= width) System.out.print(a);
                    else System.out.print(b);
                }
                System.out.println();
            }
        }


    }
}
