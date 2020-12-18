/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    public static long count(int[] a) {
        int counting = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) counting++;
            }
        }
        return counting;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        if (n == 0) {
            return a;
        }
        if (k < n) {
            int newK = (int) k;
            a[n - 1 - newK] = n - 1;
            int rest = 0;

            int i = 0;
            while (rest < n - 1) {
                if (a[i] == 0 && rest != n - 1) {
                    //  System.out.println(
                    // "IF // IN i = " + i + "  a[i] =  " + a[i] + "  rest= " + rest);
                    a[i] = rest;
                    rest++;
                    i++;
                    // System.out.println("IF // OUT i= " + i + "  rest =  " + rest);
                }
                else if (a[i] == 0 && rest == n - 1) {
                    // System.out.println("ELSE IF *IN* rest= " + rest + "  i =  " + i);
                    rest++;
                    // System.out.println("ELSE IF *OUT* rest= " + rest + "  i =  " + i);
                    continue;
                }
                else {
                    i++;
                    // System.out.println("ELSE IF not0    i =  " + i);
                    continue;
                }

            }
        }


        else {
            if (k >= n - 1) {
                int last = n - 1;
                int i = 0;
                int count = 0;
                while (k > 0) {
                    if (last < k) {
                        // System.out.println("|| last= " + last + "  i =  " + i);
                        a[i] = last;
                        // System.out.println("|| a[i]= " + a[i] + "  i =  " + i);
                        k = k - last;
                        last--;
                        i++;
                        count++;
                        //  System.out.println(
                        //  "|| last= " + last + "  k =  " + k + "  i =  " + i
                        //  + "  count =  "
                        //  + count);
                    }

                    else {
                        int newK = (int) k;
                        // System.out.println(
                        //  "\\  n - 1 - newK =  " + (n - 1 - newK));
                        a[n - 1 - newK] = last;
                        count++;
                        //  System.out.println(
                        // "\\ a[6]  " + a[n - 1 - newK] + "  count =  " + count);
                        int length = n - count;
                        int rest = 0;
                        while (rest < length) {
                            if (a[i] == 0) {
                                //  System.out.println(
                                //"IN i = " + i + "  a[i] =  " + a[i] + "  rest= "
                                //         + rest);
                                a[i] = rest;
                                rest++;
                                i++;
                                //  System.out.println("OUT rest= " + rest + "  i =  " + i);
                            }
                            else {
                                i++;
                                // System.out.println("NOT 0 so    i =  " + i);
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
        }

        return a;

    }


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] b = generate(n, k);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}


