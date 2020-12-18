/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        hours = h;
        minutes = m;
        validate(hours, minutes);

    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.matches("[0-9][0-9]:[0-9][0-9]")) {
            throw new IllegalArgumentException("invalid time: " + s);
        }
        hours = Integer.parseInt(s.substring(0, 2));
        minutes = Integer.parseInt(s.substring(3, 5));
        validate(hours, minutes);
    }

    // throws an IllegalArgumentException h hours and m minutes is an invalid time
    private static void validate(int h, int m) {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("the hours must be between 0 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("the minutes must be between 0 and 59");
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) return true;
        else if (this.hours > that.hours) return false;
        else {
            if (this.minutes < that.minutes) return true;
            else return false;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minutes == 59 && hours == 23) {
            minutes = 0;
            hours = 0;
        }
        else if (minutes == 59 && hours < 23) {
            minutes = 0;
            hours = hours + 1;
        }
        else minutes = minutes + 1;

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta is negative");
        else if (delta % 60 == 0) {
            int addedhrs = delta / 60;
            hours = hours + addedhrs;
            if (hours > 23) hours = hours % 24;
        }
        else {
            int addedhrs = delta / 60;
            hours = hours + addedhrs;
            // System.out.println(hours);
            int addedmins = delta % 60;
            int min = addedmins + minutes;
            if (min > 60) {
                //  System.out.println("min > 60 triggered");
                addedhrs = min / 60;
                //  System.out.println("added_hrs " + addedhrs + " min " + min);
                hours = hours + addedhrs;
                addedmins = min % 60;
                minutes = addedmins;
            }
            else minutes = addedmins + minutes;
            //  System.out.println(hours + " hours % 24 = " + hours % 24);
            if (hours > 23) hours = (hours % 24);
        }


    }

    public static void main(String[] args) {
        Clock start = new Clock(args[0]);
        Clock stop = new Clock(args[1]);
        System.out.println(start);
        System.out.println(start.isEarlierThan(stop));
        start.tic();
        System.out.println(start);
        stop.toc(822);
        System.out.println(stop);


    }
}
