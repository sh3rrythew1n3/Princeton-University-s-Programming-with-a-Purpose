/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        String filename = args[0];
        // k is how many bars to display in each bar chart
        int k = Integer.parseInt(args[1]);
        In input = new In(filename);
        // create the bar chart
        String title = input.readLine();
        String xAxis = input.readLine();
        String source = input.readLine();
        //  System.out.println(
        //          "marking chart || title= " + title + " /xAxis = " + xAxis + " /source=  " + source);
        BarChart chart = new BarChart(title, xAxis, source);
        String caption = "date";
        while (input.hasNextLine()) {
            String space = input.readLine();
            int records = Integer.parseInt(input.readLine());
            //   System.out.println(" NEW LINE OF RECORDS = " + records);
            Bar[] entry = new Bar[records];
            for (int i = 0; i < records; i++) {
                String perrecord = input.readLine();
                //    System.out.println("perrecord = " + perrecord);
                String[] splitrecord = perrecord.split(",");
                //    System.out.println(
                //          "year= " + splitrecord[0] + " city = " + splitrecord[1] + " value = "
                //         + splitrecord[3] + " category = "
                //           + splitrecord[4]);
                String year = splitrecord[0];
                String city = splitrecord[1];
                // String country = splitrecord[2];
                int value = Integer.parseInt(splitrecord[3]);
                String category = splitrecord[4];
                caption = year;
                entry[i] = new Bar(city, value, category);
                // System.out.println(entry[i].getName());
                //  System.out.println(entry[i].getValue());
                //  System.out.println(entry[i].getCategory());
            }
            chart.setCaption(caption);
            Arrays.sort(entry, Collections.reverseOrder());
            //  System.out.println("^^SORTED ^^^^^");
            //  for (int i = 0; i < records; i++) {
            //   System.out.println(entry[i].getName());
            //   System.out.println(entry[i].getValue());
            //  System.out.println(entry[i].getCategory());
            //   }

            // draw the bar chart
            for (int i = 0; i < k; i++) {
                chart.add(entry[i].getName(), entry[i].getValue(), entry[i].getCategory());
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(10);
            chart.reset();
            StdDraw.clear();
        }
    }
}
