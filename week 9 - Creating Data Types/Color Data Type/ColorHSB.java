/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        saturation = s;
        brightness = b;
        validate(hue, saturation, brightness);
    }

    // throws an IllegalArgumentException
    private static void validate(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");

    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (saturation == 0 || brightness == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("argument is null");
        }
        else {
            int min1 = (this.hue - that.hue) * (this.hue - that.hue);
            int min2 = Math.abs(this.hue - that.hue);
            min2 = (360 - min2) * (360 - min2);
            int minimum = Math.min(min1, min2);
            int sum = minimum + ((this.saturation - that.saturation) * (this.saturation
                    - that.saturation)) + ((this.brightness - that.brightness) * (this.brightness
                    - that.brightness));
            return sum;
        }
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB original = new ColorHSB(h, s, b);


        String storedn = "name";
        ColorHSB closestColor = null;
        int storeddistance = Integer.MAX_VALUE;


        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int inputh = StdIn.readInt();
            int inputs = StdIn.readInt();
            int inputb = StdIn.readInt();
            ColorHSB inputcolor = new ColorHSB(inputh, inputs, inputb);

            // update champion color if closer
            int distance = original.distanceSquaredTo(inputcolor);
            if (distance < storeddistance) {
                storeddistance = distance;
                storedn = name;
                closestColor = inputcolor;
            }
        }

        System.out.println(storedn + " " + closestColor);
    }
}
