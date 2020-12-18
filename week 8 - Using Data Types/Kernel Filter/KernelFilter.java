/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        Picture same = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++)
            for (int row = 0; row < picture.height(); row++)
                same.set(col, row, picture.get(col, row));
        return same;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        //  System.out.println("|| WIDTH = " + width + "  HEIGHT=  " + height);
        Picture same = new Picture(width, height);
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                //   System.out.println("col = " + col + "  row = " + row);
                int colRight = col;
                int rowTop = row;
                int colLeft = col;
                int rowBot = row;

                if (col - 1 < 0) colLeft = width;
                if (col + 1 >= width) colRight = -1;
                if (row - 1 < 0) rowTop = height;
                if (row + 1 >= height) rowBot = -1;

                Color color1 = picture.get(colLeft - 1, rowTop - 1);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                //   System.out.println(
                //  "COLOR 1 / colLeft - 1 IS  " + (colLeft - 1) + "  rowTop - 1  IS " + (rowTop
                //   - 1));
                Color color2 = picture.get(col, rowTop - 1);
                //  System.out.println(
                // "COLOR 2 / " + col + "   " + (rowTop - 1));
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();
                Color color3 = picture.get(colRight + 1, rowTop - 1);
                //   System.out.println(
                //  "COLOR 3 / colRight +1 IS  " + (colRight + 1) + "  rowTop - 1  IS " + (
                //   rowTop - 1));
                int r3 = color3.getRed();
                int g3 = color3.getGreen();
                int b3 = color3.getBlue();
                Color color4 = picture.get(colLeft - 1, row);
                int r4 = color4.getRed();
                int g4 = color4.getGreen();
                int b4 = color4.getBlue();
                Color color5 = picture.get(col, row);
                int r5 = color5.getRed();
                int g5 = color5.getGreen();
                int b5 = color5.getBlue();
                Color color6 = picture.get(colRight + 1, row);
                int r6 = color6.getRed();
                int g6 = color6.getGreen();
                int b6 = color6.getBlue();
                Color color7 = picture.get(colLeft - 1, rowBot + 1);
                //    System.out.println(
                //   "COLOR 7 / colLeft - 1 IS  " + (colLeft - 1) + "  rowBot + 1  IS " + (rowBot
                //    + 1));
                int r7 = color7.getRed();
                int g7 = color7.getGreen();
                int b7 = color7.getBlue();
                Color color8 = picture.get(col, rowBot + 1);
                // System.out.println(
                // "COLOR 8 / " + col + "   " + (rowBot + 1));
                int r8 = color8.getRed();
                int g8 = color8.getGreen();
                int b8 = color8.getBlue();
                Color color9 = picture.get(colRight + 1, rowBot + 1);
                // System.out.println(
                // "COLOR 9 / colRight +1 IS  " + (colRight + 1) + "  rowBot + 1  IS " + (
                //    rowBot + 1));
                int r9 = color9.getRed();
                int g9 = color9.getGreen();
                int b9 = color9.getBlue();

                // sum of 3x3 to get new red color
                double sumR1 = r1 + (r2 * 2) + r3 + (r4 * 2) + (r5 * 4) + (r6 * 2) + r7 + (r8 * 2)
                        + r9;
                int sumR = (int) Math.round(sumR1 / 16);
                if (sumR < 0) sumR = 0;
                if (sumR > 255) sumR = 255;

                // sum of 3x3 to get new green color
                double sumG1 = g1 + (g2 * 2) + g3 + (g4 * 2) + (g5 * 4) + (g6 * 2) + g7 + (g8 * 2)
                        + g9;
                int sumG = (int) Math.round(sumG1 / 16);
                if (sumG < 0) sumG = 0;
                if (sumG > 255) sumG = 255;

                // sum of 3x3 to get new blue color
                double sumB1 = b1 + (b2 * 2) + b3 + (b4 * 2) + (b5 * 4) + (b6 * 2) + b7 + (b8 * 2)
                        + b9;
                int sumB = (int) Math.round(sumB1 / 16);
                if (sumB < 0) sumB = 0;
                if (sumB > 255) sumB = 255;

                same.set(col, row, new Color(sumR, sumG, sumB));
            }
        return same;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        //  System.out.println("|| WIDTH = " + width + "  HEIGHT=  " + height);
        Picture same = new Picture(width, height);
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                //   System.out.println("col = " + col + "  row = " + row);
                int colRight = col;
                int rowTop = row;
                int colLeft = col;
                int rowBot = row;

                if (col - 1 < 0) colLeft = width;
                if (col + 1 >= width) colRight = -1;
                if (row - 1 < 0) rowTop = height;
                if (row + 1 >= height) rowBot = -1;


                Color color2 = picture.get(col, rowTop - 1);
                //  System.out.println(
                // "COLOR 2 / " + col + "   " + (rowTop - 1));
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();

                Color color4 = picture.get(colLeft - 1, row);
                int r4 = color4.getRed();
                int g4 = color4.getGreen();
                int b4 = color4.getBlue();
                Color color5 = picture.get(col, row);
                int r5 = color5.getRed();
                int g5 = color5.getGreen();
                int b5 = color5.getBlue();
                Color color6 = picture.get(colRight + 1, row);
                int r6 = color6.getRed();
                int g6 = color6.getGreen();
                int b6 = color6.getBlue();

                Color color8 = picture.get(col, rowBot + 1);
                // System.out.println(
                // "COLOR 8 / " + col + "   " + (rowBot + 1));
                int r8 = color8.getRed();
                int g8 = color8.getGreen();
                int b8 = color8.getBlue();


                // sum of 3x3 to get new red color
                int sumR = (r2 * -1) + (r4 * -1) + (r5 * 5) + (r6 * -1) + (r8 * -1);
                if (sumR < 0) sumR = 0;
                if (sumR > 255) sumR = 255;

                // sum of 3x3 to get new green color
                int sumG = (g2 * -1) + (g4 * -1) + (g5 * 5) + (g6 * -1) + (g8 * -1);
                if (sumG < 0) sumG = 0;
                if (sumG > 255) sumG = 255;

                // sum of 3x3 to get new blue color
                int sumB = (b2 * -1) + (b4 * -1) + (b5 * 5) + (b6 * -1) + (b8 * -1);
                if (sumB < 0) sumB = 0;
                if (sumB > 255) sumB = 255;

                same.set(col, row, new Color(sumR, sumG, sumB));
            }
        return same;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        //  System.out.println("|| WIDTH = " + width + "  HEIGHT=  " + height);
        Picture same = new Picture(width, height);
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                //   System.out.println("col = " + col + "  row = " + row);
                int colRight = col;
                int rowTop = row;
                int colLeft = col;
                int rowBot = row;

                if (col - 1 < 0) colLeft = width;
                if (col + 1 >= width) colRight = -1;
                if (row - 1 < 0) rowTop = height;
                if (row + 1 >= height) rowBot = -1;

                Color color1 = picture.get(colLeft - 1, rowTop - 1);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                //   System.out.println(
                //  "COLOR 1 / colLeft - 1 IS  " + (colLeft - 1) + "  rowTop - 1  IS " + (rowTop
                //   - 1));
                Color color2 = picture.get(col, rowTop - 1);
                //  System.out.println(
                // "COLOR 2 / " + col + "   " + (rowTop - 1));
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();
                Color color3 = picture.get(colRight + 1, rowTop - 1);
                //   System.out.println(
                //  "COLOR 3 / colRight +1 IS  " + (colRight + 1) + "  rowTop - 1  IS " + (
                //   rowTop - 1));
                int r3 = color3.getRed();
                int g3 = color3.getGreen();
                int b3 = color3.getBlue();
                Color color4 = picture.get(colLeft - 1, row);
                int r4 = color4.getRed();
                int g4 = color4.getGreen();
                int b4 = color4.getBlue();
                Color color5 = picture.get(col, row);
                int r5 = color5.getRed();
                int g5 = color5.getGreen();
                int b5 = color5.getBlue();
                Color color6 = picture.get(colRight + 1, row);
                int r6 = color6.getRed();
                int g6 = color6.getGreen();
                int b6 = color6.getBlue();
                Color color7 = picture.get(colLeft - 1, rowBot + 1);
                //    System.out.println(
                //   "COLOR 7 / colLeft - 1 IS  " + (colLeft - 1) + "  rowBot + 1  IS " + (rowBot
                //    + 1));
                int r7 = color7.getRed();
                int g7 = color7.getGreen();
                int b7 = color7.getBlue();
                Color color8 = picture.get(col, rowBot + 1);
                // System.out.println(
                // "COLOR 8 / " + col + "   " + (rowBot + 1));
                int r8 = color8.getRed();
                int g8 = color8.getGreen();
                int b8 = color8.getBlue();
                Color color9 = picture.get(colRight + 1, rowBot + 1);
                // System.out.println(
                // "COLOR 9 / colRight +1 IS  " + (colRight + 1) + "  rowBot + 1  IS " + (
                //    rowBot + 1));
                int r9 = color9.getRed();
                int g9 = color9.getGreen();
                int b9 = color9.getBlue();

                // sum of 3x3 to get new red color
                int sumR = (r1 * -1) + (r2 * -1) + (r3 * -1) + (r4 * -1) + (r5 * 8) + (r6 * -1) + (
                        r7 * -1) + (r8 * -1) + (r9 * -1);

                if (sumR < 0) sumR = 0;
                if (sumR > 255) sumR = 255;

                // sum of 3x3 to get new green color
                int sumG = (g1 * -1) + (g2 * -1) + (g3 * -1) + (g4 * -1) + (g5 * 8) + (g6 * -1) + (
                        g7 * -1) + (g8 * -1) + (g9 * -1);

                if (sumG < 0) sumG = 0;
                if (sumG > 255) sumG = 255;

                // sum of 3x3 to get new blue color
                int sumB = (b1 * -1) + (b2 * -1) + (b3 * -1) + (b4 * -1) + (b5 * 8) + (b6 * -1) + (
                        b7 * -1) + (b8 * -1) + (b9 * -1);

                if (sumB < 0) sumB = 0;
                if (sumB > 255) sumB = 255;

                same.set(col, row, new Color(sumR, sumG, sumB));
            }
        return same;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        //  System.out.println("|| WIDTH = " + width + "  HEIGHT=  " + height);
        Picture same = new Picture(width, height);
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                //   System.out.println("col = " + col + "  row = " + row);
                int colRight = col;
                int rowTop = row;
                int colLeft = col;
                int rowBot = row;

                if (col - 1 < 0) colLeft = width;
                if (col + 1 >= width) colRight = -1;
                if (row - 1 < 0) rowTop = height;
                if (row + 1 >= height) rowBot = -1;

                Color color1 = picture.get(colLeft - 1, rowTop - 1);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                //   System.out.println(
                //  "COLOR 1 / colLeft - 1 IS  " + (colLeft - 1) + "  rowTop - 1  IS " + (rowTop
                //   - 1));
                Color color2 = picture.get(col, rowTop - 1);
                //  System.out.println(
                // "COLOR 2 / " + col + "   " + (rowTop - 1));
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();

                Color color4 = picture.get(colLeft - 1, row);
                int r4 = color4.getRed();
                int g4 = color4.getGreen();
                int b4 = color4.getBlue();
                Color color5 = picture.get(col, row);
                int r5 = color5.getRed();
                int g5 = color5.getGreen();
                int b5 = color5.getBlue();
                Color color6 = picture.get(colRight + 1, row);
                int r6 = color6.getRed();
                int g6 = color6.getGreen();
                int b6 = color6.getBlue();

                Color color8 = picture.get(col, rowBot + 1);
                // System.out.println(
                // "COLOR 8 / " + col + "   " + (rowBot + 1));
                int r8 = color8.getRed();
                int g8 = color8.getGreen();
                int b8 = color8.getBlue();
                Color color9 = picture.get(colRight + 1, rowBot + 1);
                // System.out.println(
                // "COLOR 9 / colRight +1 IS  " + (colRight + 1) + "  rowBot + 1  IS " + (
                //    rowBot + 1));
                int r9 = color9.getRed();
                int g9 = color9.getGreen();
                int b9 = color9.getBlue();

                // sum of 3x3 to get new red color
                int sumR = (r1 * -2) + (r2 * -1) + (r4 * -1) + r5 + r6 + r8 + (r9 * 2);

                if (sumR < 0) sumR = 0;
                if (sumR > 255) sumR = 255;

                // sum of 3x3 to get new green color
                int sumG = (g1 * -2) + (g2 * -1) + (g4 * -1) + g5 + g6 + g8 + (g9 * 2);

                if (sumG < 0) sumG = 0;
                if (sumG > 255) sumG = 255;

                // sum of 3x3 to get new blue color
                int sumB = (b1 * -2) + (b2 * -1) + (b4 * -1) + b5 + b6 + b8 + (b9 * 2);

                if (sumB < 0) sumB = 0;
                if (sumB > 255) sumB = 255;

                same.set(col, row, new Color(sumR, sumG, sumB));
            }
        return same;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        // System.out.println("|| WIDTH = " + width + "  HEIGHT=  " + height);
        Picture same = new Picture(width, height);
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                //  System.out.println("col = " + col + "  row = " + row);
                int colC1 = col;
                int rowC1 = row;
                int colC2 = col;
                int rowC2 = row;
                int colC3 = col;
                int rowC3 = row;
                int colC4 = col;
                int rowC4 = row;

                int colC6 = col;
                int colC7 = col;
                int colC8 = col;
                int colC9 = col;

                int rowC6 = row;
                int rowC7 = row;
                int rowC8 = row;
                int rowC9 = row;

                if (col - 1 < 0) {
                    // System.out.println(" IF col - 1 < 0");
                    colC4 = width;
                    colC1 = width;
                    colC2 = width;
                    colC3 = width;
                }
                else if (col - 2 < 0) {
                    //   System.out.println(" IF col - 2 < 0");
                    colC1 = width + 1;
                    colC2 = width + 1;
                    colC3 = width + 1;
                }
                else if (col - 3 < 0) {
                    //   System.out.println(" IF col - 3 < 0");
                    colC1 = width + 2;
                    colC2 = width + 2;
                }
                else if (col - 4 < 0) {
                    //  System.out.println(" IF col - 4 < 0");
                    colC1 = width + 3;
                }

                if (row - 1 < 0) {
                    //  System.out.println(" IF row - 1 < 0");
                    rowC4 = height;
                    rowC1 = height;
                    rowC2 = height;
                    rowC3 = height;
                }
                else if (row - 2 < 0) {
                    //  System.out.println(" IF row - 2 < 0");
                    rowC1 = height + 1;
                    rowC2 = height + 1;
                    rowC3 = height + 1;
                }

                else if (row - 3 < 0) {
                    //  System.out.println(" IF row - 3 < 0");
                    rowC1 = height + 2;
                    rowC2 = height + 2;

                }
                else if (row - 4 < 0) {
                    // System.out.println(" IF row - 4 < 0");
                    rowC1 = height + 3;
                }


                if (col + 1 >= width) {
                    //  System.out.println(" IF col + 1 >= width");
                    colC6 = -1;
                    colC7 = -1;
                    colC8 = -1;
                    colC9 = -1;
                }
                else if (col + 2 >= width) {
                    //  System.out.println(" IF col + 2 >= width");
                    colC7 = -2;
                    colC8 = -2;
                    colC9 = -2;
                }
                else if (col + 3 >= width) {
                    // System.out.println(" IF col + 3 >= width");
                    colC8 = -3;
                    colC9 = -3;
                }
                else if (col + 4 >= width) {
                    // System.out.println(" IF col + 4 >= width");
                    colC9 = -4;
                }

                if (row + 1 >= height) {
                    // System.out.println(" IF row + 1 >= height");
                    rowC6 = -1;
                    rowC7 = -1;
                    rowC8 = -1;
                    rowC9 = -1;
                }
                else if (row + 2 >= height) {
                    //  System.out.println(" IF row + 2 >= height");
                    rowC7 = -2;
                    rowC8 = -2;
                    rowC9 = -2;
                }
                else if (row + 3 >= height) {
                    //  System.out.println(" IF row + 3 >= height");
                    rowC8 = -3;
                    rowC9 = -3;
                }
                else if (row + 4 >= height) {
                    //  System.out.println(" IF row + 4 >= height");
                    rowC9 = -4;
                }


                Color color1 = picture.get(colC1 - 4, rowC1 - 4);
                // System.out.println(
                //   "COLOR 1 / colC1 IS  " + (colC1 - 4) + "  rowC1  IS " + (rowC1
                //  - 4));
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();

                Color color2 = picture.get(colC2 - 3, rowC2 - 3);
                // System.out.println(
                //  "COLOR 2 / " + (colC2 - 3) + "   " + (rowC2 - 3));
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();
                Color color3 = picture.get(colC3 - 2, rowC3 - 2);
                // System.out.println(
                //  "COLOR 3 / colC3 IS  " + (colC3 - 2) + "  rowC3 IS " + (
                //      rowC3 - 2));
                int r3 = color3.getRed();
                int g3 = color3.getGreen();
                int b3 = color3.getBlue();
                Color color4 = picture.get(colC4 - 1, rowC4 - 1);
                // System.out.println(
                //  "COLOR 4 / " + (colC4 - 1) + "   " + (rowC4 - 1));
                int r4 = color4.getRed();
                int g4 = color4.getGreen();
                int b4 = color4.getBlue();
                Color color5 = picture.get(col, row);
                int r5 = color5.getRed();
                int g5 = color5.getGreen();
                int b5 = color5.getBlue();
                Color color6 = picture.get(colC6 + 1, rowC6 + 1);
                // System.out.println(
                //  "COLOR 6 / " + (colC6 + 1) + "   " + (rowC6 + 1));
                int r6 = color6.getRed();
                int g6 = color6.getGreen();
                int b6 = color6.getBlue();
                Color color7 = picture.get(colC7 + 2, rowC7 + 2);
                //  System.out.println(
                //   "COLOR 7 / colC7  IS  " + (colC7 + 2) + "  rowC7  IS " + (rowC7 + 2));
                int r7 = color7.getRed();
                int g7 = color7.getGreen();
                int b7 = color7.getBlue();
                Color color8 = picture.get(colC8 + 3, rowC8 + 3);
                //   System.out.println(
                //   "COLOR 8 / " + (colC8 + 3) + "   " + (rowC8 + 3));
                int r8 = color8.getRed();
                int g8 = color8.getGreen();
                int b8 = color8.getBlue();
                Color color9 = picture.get(colC9 + 4, rowC9 + 4);
                //  System.out.println(
                // "COLOR 9 / colC9  IS  " + (colC9 + 4) + "  rowC9  IS " + (
                //    rowC9 + 4));
                int r9 = color9.getRed();
                int g9 = color9.getGreen();
                int b9 = color9.getBlue();

                // sum of 3x3 to get new red color
                double sumR1 = r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9;
                int sumR = (int) Math.round(sumR1 / 9);
                if (sumR < 0) sumR = 0;
                if (sumR > 255) sumR = 255;

                // sum of 3x3 to get new green color
                double sumG1 = g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9;
                int sumG = (int) Math.round(sumG1 / 9);
                if (sumG < 0) sumG = 0;
                if (sumG > 255) sumG = 255;

                // sum of 3x3 to get new blue color
                double sumB1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9;
                int sumB = (int) Math.round(sumB1 / 9);
                if (sumB < 0) sumB = 0;
                if (sumB > 255) sumB = 255;

                same.set(col, row, new Color(sumR, sumG, sumB));
            }
        return same;
    }

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture motion = motionBlur(pic);
        motion.show();
        Picture ident = identity(pic);
        ident.show();
        Picture gau = gaussian(pic);
        gau.show();
        Picture sharp = sharpen(pic);
        sharp.show();
        Picture lap = laplacian(pic);
        lap.show();
        Picture em = emboss(pic);
        em.show();
     

    }

}
