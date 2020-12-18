/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int storedCount = 0;
        //  System.out.println("LENGTH OF DNA   " + dna.length());
        if (dna.indexOf("CAG") < 0) storedCount = 0;
        else {
            for (int i = dna.indexOf("CAG"); i < dna.length(); i++) {
                if (i + 3 <= dna.length()) {
                    String cag = dna.substring(i, i + 3);
                    //  System.out.println("i = " + i);
                    if (cag.equals("CAG")) {
                        count++;
                        i = i + 2;
                        //   System.out.println("EQUALS  count = " + count);
                        storedCount = Math.max(count, storedCount);
                    }
                    else {
                        //   System.out.println(
                        //        "|| BREAK count = " + count + "  storedCount = " + storedCount);
                        storedCount = Math.max(count, storedCount);
                        //   System.out.println("  storedCount = " + storedCount);
                        count = 0;

                    }
                }
                else break;
            }
        }
        return storedCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String removed = s;
        removed = removed.replace("\n", "");
        removed = removed.replace("\t", "");
        removed = removed.replaceAll("\\s", "");

        return removed;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String diagnosis;
        if (maxRepeats <= 9) diagnosis = "not human";
        else if (maxRepeats <= 35) diagnosis = "normal";
        else if (maxRepeats <= 39) diagnosis = "high risk";
        else if (maxRepeats <= 180) diagnosis = "Huntington’s";
        else diagnosis = "not human";
        return diagnosis;
    }

    public static void main(String[] args) {
        String file = args[0];
        In input = new In(file);
        String s = input.readAll();
        s = removeWhitespace(s);
        // System.out.println(s);
        int repeats = maxRepeats(s);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));
    }

}

